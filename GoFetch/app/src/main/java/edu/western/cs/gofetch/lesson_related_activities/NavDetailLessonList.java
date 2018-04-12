package edu.western.cs.gofetch.lesson_related_activities;

import android.content.Intent;
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
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import edu.western.cs.gofetch.Help;
import edu.western.cs.gofetch.R;
import edu.western.cs.gofetch.adapter.CustomAdapterL;
import edu.western.cs.gofetch.createLessons.Advanced;
import edu.western.cs.gofetch.createLessons.Beginner;
import edu.western.cs.gofetch.createLessons.Intermediate;
import edu.western.cs.gofetch.createLessons.Puppy;
import edu.western.cs.gofetch.dog_related_activities.NavDogProfile;
import edu.western.cs.gofetch.leaderboard_related_activites.Leaderboard;
import edu.western.cs.gofetch.model.Lesson;

public class NavDetailLessonList extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private ArrayList<Lesson> mLessonList;
    private String level;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_detail_lesson_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Intent intent = getIntent();
        level = intent.getStringExtra("level");

        switch (level){
            case "0":
                mLessonList = Puppy.puppyLessons();
                break;
            case "1":
                mLessonList = Beginner.beginnerLessons();
                break;
            case "2":
                mLessonList = Intermediate.intermediateLessons();
                break;
            case "3":
                mLessonList = Advanced.advancedLessons();
                break;
            default:
                break;

        }


        ListView listView = findViewById(R.id.detail_lesson_list);

        CustomAdapterL listAdapter = new CustomAdapterL(NavDetailLessonList.this, R.layout.lesson_list, mLessonList);
        listView.setAdapter(listAdapter);
//        TextView listItem = findViewById(R.id.lesson_title);
//
//        switch (level){
//            case "0":
//                listItem.setBackgroundColor(getResources().getColor(R.color.Green));
//                break;
//            case "1":
//                listItem.setBackgroundColor(getResources().getColor(R.color.Yellow));
//                break;
//            case "2":
//                listItem.setBackgroundColor(getResources().getColor(R.color.Orange));
//            case "3":
//                listItem.setBackgroundColor(getResources().getColor(R.color.Red));
//                break;
//            default:
//                break;
//
//        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(NavDetailLessonList.this, StartLesson.class);

                intent.putExtra("title", mLessonList.get(i).getTitle());
                intent.putExtra("description", mLessonList.get(i).getDescription());
                intent.putExtra("steps", mLessonList.get(i).getSteps());
                intent.putExtra("level", level);

                startActivity(intent);
            }
        });
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
        getMenuInflater().inflate(R.menu.nav_detail_lesson_list, menu);
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

        if (id == R.id.nav_basic_less_list) {
            Intent intent = new Intent(NavDetailLessonList.this, NavBasicLessonList.class);
            startActivity(intent);
            //Basic Lessons
        } else if (id == R.id.nav_d_profile) {
            Intent intent = new Intent(NavDetailLessonList.this, NavDogProfile.class);
            startActivity(intent);
            //Dog Profile
        } else if (id == R.id.nav_detail_leaderboard) {
            Intent intent = new Intent(NavDetailLessonList.this, Leaderboard.class);
            startActivity(intent);
            //Leaderboard

        } else if (id == R.id.nav_detail_help) {
            Intent intent = new Intent(NavDetailLessonList.this, Help.class);
            startActivity(intent);
            //Help

        } //else if (id == R.id.nav_share) {

//        } else if (id == R.id.nav_send) {
//
//        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
