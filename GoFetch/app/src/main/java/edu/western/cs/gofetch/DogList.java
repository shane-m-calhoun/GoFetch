package edu.western.cs.gofetch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import edu.western.cs.gofetch.adapter.CustomAdapter;
import edu.western.cs.gofetch.model.Dog;
import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;
import edu.western.cs.gofetch.adapter.CustomRealmAdapter;


public class DogList extends AppCompatActivity {

    ArrayList<Dog> dogs = new ArrayList<>();

    Realm realm;
    RealmResults<Dog> mResults;
    ArrayList<Dog> mDogList;
    CustomRealmAdapter mCustomRealmAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog_list);



//        Dog kenai = new Dog();
//        kenai.setFirst_name("Kenai");
//        kenai.setAge("1");
//        kenai.setBreed("Mini Aussie");
//        kenai.setPoints(100);
//        kenai.setWeight("25");
//        dogs.add(kenai);
//
//        Dog beacon = new Dog();
//        beacon.setFirst_name("Beacon");
//        beacon.setAge("2");
//        beacon.setBreed("Pointer");
//        beacon.setPoints(100);
//        beacon.setWeight("75");
//        dogs.add(beacon);

        realm = Realm.getDefaultInstance();

        mResults= realm.where(Dog.class).findAll();

        mDogList = new ArrayList<>(mResults);


        ListView dogList = findViewById(R.id.dog_list);

        mCustomRealmAdapter = new CustomRealmAdapter(mResults);
        dogList.setAdapter(mCustomRealmAdapter);



        dogList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(DogList.this, DogProfile.class);
                Dog dog = mDogList.get(i);
                intent.putExtra("id", dog.getId());
                Log.d("ddd","********"+dog.getFirst_name()+dog.getPoints());
                startActivity(intent);
            }
        });



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
