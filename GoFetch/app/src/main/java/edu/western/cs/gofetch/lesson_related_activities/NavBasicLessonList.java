package edu.western.cs.gofetch.lesson_related_activities;

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

import edu.western.cs.gofetch.Help;
import edu.western.cs.gofetch.R;
import edu.western.cs.gofetch.dog_related_activities.AddDog;
import edu.western.cs.gofetch.dog_related_activities.NavDogList;
import edu.western.cs.gofetch.dog_related_activities.NavDogProfile;
//import edu.western.cs.gofetch.leaderboard_related_activites.Leaderboard;

public class NavBasicLessonList extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_basic_lesson_list);
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
        Button puppy = findViewById(R.id.puppy_lesson_button);
        puppy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NavBasicLessonList.this, NavDetailLessonList.class);
                intent.putExtra("level", "0");
                startActivity(intent);
            }//OnClick for puppy
        });//SetOnClickListener for puppy

        Button beginner = findViewById(R.id.beginner_lesson_button);
        beginner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NavBasicLessonList.this, NavDetailLessonList.class);
                intent.putExtra("level", "1");
                startActivity(intent);
            }//OnClick for beginner
        });//SetOnClickListener for beginner

        Button intermediate = findViewById(R.id.intermediate_lesson_button);
        intermediate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NavBasicLessonList.this, NavDetailLessonList.class);
                intent.putExtra("level", "2");
                startActivity(intent);
            }//OnClick for intermediate lessons
        });//SetOnClickListener for intermediate lessons
        Button advanced = findViewById(R.id.advanced_lesson_button);
        advanced.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NavBasicLessonList.this, NavDetailLessonList.class);
                intent.putExtra("level", "3");
                startActivity(intent);
            }//OnClick for Advanced lessons
        });//SetOnClickListener for advanced lessons
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
        getMenuInflater().inflate(R.menu.nav_basic_lesson_list, menu);
        setTitle("Choose a Level");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Intent intent = new Intent(NavBasicLessonList.this, NavDogProfile.class);
            startActivity(intent);
            //Dog Profile
        } else if (id == R.id.nav_gallery) {
            Intent intent = new Intent(NavBasicLessonList.this, NavDogList.class);
            startActivity(intent);
            //Dog List
        } else if (id == R.id.nav_slideshow) {
            Intent intent = new Intent(NavBasicLessonList.this, AddDog.class);
            intent.putExtra("method", "add");
            startActivity(intent);
            //Add Dog
        } else if (id == R.id.nav_edit) {
            SharedPreferences sharedPreferences = getSharedPreferences("share_dog", MODE_PRIVATE);
            final String dogId = sharedPreferences.getString("dogID", "");

            Intent intent = new Intent(NavBasicLessonList.this, AddDog.class);
            intent.putExtra("method", "edit");
            intent.putExtra("dogId", dogId);
            startActivity(intent);
            //Add Dog
        } else if (id == R.id.nav_help2) {
            Intent intent = new Intent(NavBasicLessonList.this, Help.class);
            startActivity(intent);
            //Help
        } //else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
