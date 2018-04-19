package edu.western.cs.gofetch.dog_related_activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import edu.western.cs.gofetch.NavHelp;
import edu.western.cs.gofetch.NavHistory;
//import edu.western.cs.gofetch.leaderboard_related_activites.Leaderboard;
import edu.western.cs.gofetch.lesson_related_activities.NavBasicLessonList;
import edu.western.cs.gofetch.R;
import edu.western.cs.gofetch.model.Dog;
import io.realm.Realm;

public class NavDogProfile extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public static final String EXTRA_ID = "id";
    Realm realm;
    private String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_dog_profile);
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

        SharedPreferences sharedPreferences = getSharedPreferences("share_dog", MODE_PRIVATE);
        id = sharedPreferences.getString("dogID", "");


        //retrieve contact from Realm
        realm = Realm.getDefaultInstance();
        final Dog dog = realm.where(Dog.class).equalTo("id", id).findFirst();

        TextView name = findViewById(R.id.profile_name_data);
        TextView level = findViewById(R.id.profile_level_data);
        TextView points = findViewById(R.id.profile_points_data);
        TextView breed = findViewById(R.id.profile_breed_data);
        TextView age = findViewById(R.id.profile_age_data);
        TextView weight = findViewById(R.id.profile_weight_data);


        int lvl = (int)Math.round(dog.getPoints())/100 + 1;


        name.setText(dog.getFirst_name());
        level.setText(String.valueOf(lvl));
        points.setText(dog.getPoints() + " pts.");
        breed.setText(dog.getBreed());
        age.setText(dog.getAge());
        weight.setText(dog.getWeight());

        Button newLesson = findViewById(R.id.peofile_new_lesson_button);
        newLesson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent lessonIntent = new Intent(NavDogProfile.this, NavBasicLessonList.class);
                startActivity(lessonIntent);
            }//OnClick
        });

        Button history = findViewById(R.id.profile_go_to_history_button);
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NavDogProfile.this, NavHistory.class);
                startActivity(intent);
            }//OnClick
        });

        //setOnClickListener
//        Button leaderBoard = findViewById(R.id.profile_leader_board_button);
//        leaderBoard.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent leaderIntent = new Intent(DogProfile.this, Leaderboard.class);
//                startActivity(leaderIntent);
//            }
//        });
    }//OnCreate method

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
        getMenuInflater().inflate(R.menu.nav_dog_profile, menu);
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

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Intent intent = new Intent(NavDogProfile.this, NavDogList.class);
            startActivity(intent);
            //Go to Do List
        }   else if (id == R.id.nav_profile_add) {
            Intent intent = new Intent(NavDogProfile.this, AddDog.class);
            intent.putExtra("method", "add");
            startActivity(intent);
            //Add Dog
//
        } else if (id == R.id.nav_profile_edit_dog) {
            SharedPreferences sharedPreferences = getSharedPreferences("share_dog", MODE_PRIVATE);
            final String dogId = sharedPreferences.getString("dogID", "");

            Intent intent = new Intent(NavDogProfile.this, AddDog.class);
            intent.putExtra("method", "edit");
            intent.putExtra("dogId", dogId);
            startActivity(intent);
            //Edit Dog Dog
        } else if (id == R.id.nav_slideshow) {
            Intent intent = new Intent(NavDogProfile.this, NavBasicLessonList.class);
            startActivity(intent);
            //Basic Lessons
        }else if (id == R.id.nav_help1) {
            Intent intent = new Intent(NavDogProfile.this, NavHelp.class);
            startActivity(intent);
            //Help
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
