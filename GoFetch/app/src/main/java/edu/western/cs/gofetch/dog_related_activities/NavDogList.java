package edu.western.cs.gofetch.dog_related_activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import edu.western.cs.gofetch.NavHelp;
import edu.western.cs.gofetch.R;
import edu.western.cs.gofetch.account_related_activities.MainActivity;
import edu.western.cs.gofetch.adapter.CustomRealmAdapter;
import edu.western.cs.gofetch.leaderboard_related_activites.Leaderboard;
import edu.western.cs.gofetch.model.Dog;
import io.realm.Realm;
import io.realm.RealmResults;

public class NavDogList extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {



    ArrayList<Dog> dogs = new ArrayList<>();

    Realm realm;
    RealmResults<Dog> mResults;
    ArrayList<Dog> mDogList;
    CustomRealmAdapter mCustomRealmAdapter;

    private String SHARED_PREF = "share_dog";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_dog_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
       //ActionBar actionBar = getSupportActionBar();
//        actionBar.setDisplayShowHomeEnabled(true);
        //actionBar.setHomeAsUpIndicator(R.drawable.ic_reorder_black_24dp);

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
                Intent intent = new Intent(NavDogList.this, NavDogProfile.class);
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
                Intent intent = new Intent(NavDogList.this, AddDog.class);
                intent.putExtra("method", "add");
                startActivity(intent);
            }//OnClick
        });//setOnClickListener

    }//OnCreate

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nav_dog_list, menu);
        //getMenuInflater().inflate(R.menu.menu, menu);
        //return super.onCreateOptionsMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
        switch (item.getItemId()) {
            case R.id.add_dog:
                Intent intent = new Intent(NavDogList.this, AddDog.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }//Switch statement
        //return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Intent intent = new Intent(NavDogList.this, AddDog.class);
            intent.putExtra("method", "add");
            startActivity(intent);
            // Handle the camera action

        } else if (id == R.id.nav_help) {
            Intent intent = new Intent(NavDogList.this, NavHelp.class);
            startActivity(intent);
            //Help
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//
        }//else if for nav_gallery

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu, menu);
//        return super.onCreateOptionsMenu(menu);
//    }//OnCreateOptionsMenu
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.add_dog:
//                Intent intent = new Intent(DogList.this, AddDog.class);
//                startActivity(intent);
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }//Switch statement
//    }//OnOptionItemSelected
}
