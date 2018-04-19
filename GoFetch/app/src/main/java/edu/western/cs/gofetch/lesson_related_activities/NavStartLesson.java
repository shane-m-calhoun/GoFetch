package edu.western.cs.gofetch.lesson_related_activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
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

import edu.western.cs.gofetch.Help;
import edu.western.cs.gofetch.NavSaveToHistory;
import edu.western.cs.gofetch.R;
import edu.western.cs.gofetch.dog_related_activities.NavDogList;
import edu.western.cs.gofetch.dog_related_activities.NavDogProfile;
//import edu.western.cs.gofetch.leaderboard_related_activites.Leaderboard;
import edu.western.cs.gofetch.model.Dog;
import io.realm.Realm;

public class NavStartLesson extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private TextView titleText;
    private TextView counterText;
    private TextView lessonInfoText;
    private Button counterButton;
    private Button finishButton;

    private CountDownTimer countDownTimer;
    private long timeLeft = 900000;
    private long originalTime = 900000;
    private boolean timerRunning;
    private boolean timerFinished;

    private double points;
    private double addedPoints;

    Realm realm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_start_lesson);
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

        Intent i = getIntent();
        final String level = i.getStringExtra("level");

        SharedPreferences sharedPreferences = getSharedPreferences("share_dog", MODE_PRIVATE);
        final String id = sharedPreferences.getString("dogID", "");

        titleText = findViewById(R.id.start_lesson_title);
        counterText = findViewById(R.id.countdown_text);
        lessonInfoText = findViewById(R.id.info);
        counterButton = findViewById(R.id.counter_button);
        finishButton = findViewById(R.id.finish_button);

        Intent intent = getIntent();
        final String title = intent.getStringExtra("title");
        String description = intent.getStringExtra("description");
        String steps = intent.getStringExtra("steps");

        titleText.setText(title);
        lessonInfoText.setText(description + "\n" + steps);

        realm = Realm.getDefaultInstance();
        final Dog dog = realm.where(Dog.class).equalTo("id", id).findFirst();
        points = dog.getPoints();


        switch (level){
            case "0":
                addedPoints = 25;
                break;
            case "1":
                addedPoints = 50;
                break;
            case "2":
                addedPoints = 75;
                break;
            case "3":
                addedPoints = 100;
                break;
            default:
                addedPoints = 0;
                break;

        }




        counterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!timerFinished) {
                    startStop();
                }
            }
        });

        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(timeLeft > originalTime/2){
                    addedPoints = 0;
                } else if(timeLeft <= originalTime/2 && timeLeft > 60000) {
                    addedPoints = addedPoints/2;
                }

                realm.beginTransaction();
                dog.setPoints(points + addedPoints);
                realm.commitTransaction();

                Intent i = new Intent(NavStartLesson.this, NavSaveToHistory.class);
                i.putExtra("lessonTitle", title);
                i.putExtra("lessonLevel", level);
                i.putExtra("pointsReceived", String.valueOf(addedPoints));

                startActivity(i);
            }
        });


    }//OnCreate method



    public void startStop(){
        if(timerRunning){
            stopTimer();
        } else {
            startTimer();
        }
    }

    public void startTimer(){
        countDownTimer = new CountDownTimer(timeLeft, 1000) {
            @Override
            public void onTick(long l) {
                timeLeft = l;
                updateTimer();
            }

            @Override
            public void onFinish() {
                counterButton.setVisibility(View.INVISIBLE);
                timerFinished = true;
            }
        }.start();

        counterButton.setText("Pause");
        counterButton.setBackgroundColor(getResources().getColor(R.color.Yellow));
        timerRunning = true;
    }

    public void  stopTimer(){
        countDownTimer.cancel();
        counterButton.setText("Start");
        counterButton.setBackgroundColor(getResources().getColor(R.color.Green));
        timerRunning = false;
    }

    public void updateTimer(){
        int minutes = (int) timeLeft / 60000;
        int seconds = (int) timeLeft % 60000 / 1000;

        String timeleftText;

        timeleftText = "" + minutes;
        timeleftText += ":";
        if (seconds < 10){
            timeleftText += "0";
        }
        timeleftText += seconds;

        counterText.setText(timeleftText);
    }

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
        getMenuInflater().inflate(R.menu.nav_start_lesson, menu);
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

//        if (id == R.id.nav_start_detailed_lessons) {
//            Intent intent = new Intent(NavStartLesson.this, NavDetailLessonList.class);
//            startActivity(intent);
//            //Detailed Lessons
        if (id == R.id.nav_start_basic_lessons) {
            Intent intent = new Intent(NavStartLesson.this, NavBasicLessonList.class);
            startActivity(intent);
        } else if (id == R.id.nav_start_profile) {
            Intent intent = new Intent(NavStartLesson.this, NavDogProfile.class);
            startActivity(intent);
        } else if (id == R.id.nav_start_dog_list) {
            Intent intent = new Intent(NavStartLesson.this, NavDogList.class);
            startActivity(intent);
        }  else if (id == R.id.nav_start_help) {
            Intent intent = new Intent(NavStartLesson.this, Help.class);
            startActivity(intent);
        } //else if (id == R.id.nav_send) {

        //}

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
