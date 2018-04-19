package edu.western.cs.gofetch;

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
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import edu.western.cs.gofetch.dog_related_activities.AddDog;
import edu.western.cs.gofetch.dog_related_activities.NavDogList;
import edu.western.cs.gofetch.dog_related_activities.NavDogProfile;
import edu.western.cs.gofetch.lesson_related_activities.NavBasicLessonList;
import edu.western.cs.gofetch.lesson_related_activities.NavDetailLessonList;
import edu.western.cs.gofetch.model.Dog;
import edu.western.cs.gofetch.model.History;
import edu.western.cs.gofetch.model.Lesson;
import io.realm.Realm;

public class NavSaveToHistory extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private TextView title;
    private TextView points;
    private Spinner spinner;
    private EditText editText;
    private Button button;

    private String lessonLevel;

    private String pointsReceived;

    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_save_to_history);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//
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

        Intent intent = getIntent();
        final String lessonTitle = intent.getStringExtra("lessonTitle");
        lessonLevel = intent.getStringExtra("lessonLevel");
        pointsReceived = intent.getStringExtra("pointsReceived");

        SharedPreferences sharedPreferences = getSharedPreferences("share_dog", MODE_PRIVATE);
        final String dogId = sharedPreferences.getString("dogID", "");

        realm = Realm.getDefaultInstance();
//        final Dog dog = realm.where(Dog.class).equalTo("id", dogId).findFirst();

        title = findViewById(R.id.save_to_history_title);
        points = findViewById(R.id.save_to_history_points);
        spinner = findViewById(R.id.save_history_spinner);
        editText  =findViewById(R.id.save_history_edit);
        button = findViewById(R.id.save_history_button);

        title.setText(lessonTitle);

        points.setText(pointsReceived + "pts. Received");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String performance = spinner.getSelectedItem().toString();
                String text = editText.getText().toString();
                String date = new SimpleDateFormat("MM-dd-yy").format(new Date());
                String time = new SimpleDateFormat("h:mm a").format(new Date());

                if(text == null){
                    text = "";
                }

                realm.beginTransaction();
                History history = realm.createObject(History.class, UUID.randomUUID().toString());
                history.setDogId(dogId);
                history.setLessonTitle(lessonTitle);
                history.setLessonLevel(lessonLevel);
                history.setPointsReceived(pointsReceived);
                history.setPerformanceLevel(performance);
                history.setSessionNotes(text);
                history.setDate(date);
                history.setTime(time);
                realm.commitTransaction();

                Intent intent = new Intent(NavSaveToHistory.this, NavDogProfile.class);
                startActivity(intent);

            }

        });


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            Intent intent = new Intent(NavSaveToHistory.this, NavDetailLessonList.class);
            intent.putExtra("level", lessonLevel);
            startActivity(intent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nav_save_to_history, menu);
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

        if (id == R.id.nav_save_history_profile) {
            Intent intent = new Intent(NavSaveToHistory.this, NavDogProfile.class);
            startActivity(intent);
        } else if (id == R.id.nav_save_go_list) {
            Intent intent = new Intent(NavSaveToHistory.this, NavDogList.class);
            startActivity(intent);
        } else if (id == R.id.nav_b_lesson) {
            Intent intent = new Intent(NavSaveToHistory.this, NavBasicLessonList.class);
            startActivity(intent);
        } else if (id == R.id.nav_d_lesson) {
            Intent intent = new Intent(NavSaveToHistory.this, NavDetailLessonList.class);
            startActivity(intent);

        } //else if (id == R.id.nav_share) {

//        } else if (id == R.id.nav_send) {
//
//        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
