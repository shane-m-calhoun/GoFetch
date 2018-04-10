package edu.western.cs.gofetch.dog_related_activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import edu.western.cs.gofetch.R;
import edu.western.cs.gofetch.model.Dog;
import io.realm.Realm;
import io.realm.RealmResults;
import edu.western.cs.gofetch.adapter.CustomRealmAdapter;


public class DogList extends AppCompatActivity {

    ArrayList<Dog> dogs = new ArrayList<>();

    Realm realm;
    RealmResults<Dog> mResults;
    ArrayList<Dog> mDogList;
    CustomRealmAdapter mCustomRealmAdapter;

    private String SHARED_PREF = "share_dog";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog_list);
        //Toolbar and ActionBar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);

        RelativeLayout buttonLayout = findViewById(R.id.first_dog_layout);
        ListView dogList = findViewById(R.id.dog_list);
        Button firstDog = findViewById(R.id.first_dog_button);

        realm = Realm.getDefaultInstance();

        mResults= realm.where(Dog.class).findAll();

        mDogList = new ArrayList<>(mResults);

        if(mDogList.isEmpty()){
            dogList.setVisibility(ListView.GONE);
            buttonLayout.setVisibility(RelativeLayout.VISIBLE);
        }


        mCustomRealmAdapter = new CustomRealmAdapter(mResults);
        dogList.setAdapter(mCustomRealmAdapter);

        final SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREF, MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();





        dogList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(DogList.this, DogProfile.class);
                Dog dog = mDogList.get(i);
                editor.putString("dogID", dog.getId());
                editor.commit();
                Log.d("ddd","********"+dog.getFirst_name()+dog.getPoints());
                startActivity(intent);
            }
        });

        firstDog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DogList.this, AddDog.class);
                startActivity(intent);
            }//OnClick
        });//setOnClickListener



    }//onCreate
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }//OnCreateOptionsMenu

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_dog:
                Intent intent = new Intent(DogList.this, AddDog.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }//Switch statement
    }//OnOptionItemSelected
}//DogList
