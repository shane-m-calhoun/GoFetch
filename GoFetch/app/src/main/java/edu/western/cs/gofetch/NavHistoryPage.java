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
import android.widget.TextView;

import edu.western.cs.gofetch.dog_related_activities.AddDog;
import edu.western.cs.gofetch.dog_related_activities.NavDogList;
import edu.western.cs.gofetch.dog_related_activities.NavDogProfile;
import edu.western.cs.gofetch.lesson_related_activities.NavBasicLessonList;
import edu.western.cs.gofetch.model.History;
import edu.western.cs.gofetch.model.Lesson;
import io.realm.Realm;
import io.realm.RealmResults;

public class NavHistoryPage extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_history_page);
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

        TextView title = findViewById(R.id.textView_title);
        TextView level = findViewById(R.id.textView_level);
        TextView date = findViewById(R.id.textView_date);
        TextView time = findViewById(R.id.textView_time);
        TextView performance = findViewById(R.id.textView_performance);
        TextView notes = findViewById(R.id.textView_notes);
        Button back = findViewById(R.id.button_allHistory);
        
        String lessonLevel;

        Intent intent = getIntent();
        final String lessonId = intent.getStringExtra("lessonId");

        realm = Realm.getDefaultInstance();

        History history= realm.where(History.class).equalTo("id", lessonId).findFirst();

        switch (history.getLessonLevel()){
            case "0":
                lessonLevel = "Puppy Lesson";
                break;
            case "1":
                lessonLevel = "Beginner Lesson";
                break;
            case "2":
                lessonLevel = "Intermediate Lesson";
                break;
            case "3":
                lessonLevel = "Advanced Lesson";
                break;
            default:
                lessonLevel = "";
                break;

        }

        title.setText(history.getLessonTitle());
        level.setText(lessonLevel);
        date.setText(history.getDate());
        time.setText(history.getTime());
        performance.setText(history.getPointsReceived() +"pts. Received\n" + "Performance: " + history.getPerformanceLevel());
        notes.setText(history.getSessionNotes());

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(NavHistoryPage.this, NavHistory.class);
                startActivity(i);
            }
        });

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
        getMenuInflater().inflate(R.menu.nav_history_page, menu);
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
        if (id == R.id.nav_history_page_profile) {
            Intent intent = new Intent(NavHistoryPage.this, NavDogProfile.class);
            startActivity(intent);
        } else if (id == R.id.nav_history_page_list) {
            Intent intent = new Intent(NavHistoryPage.this, NavDogList.class);
            startActivity(intent);
        }else if (id == R.id.nav_history_list_add) {
            Intent intent = new Intent(NavHistoryPage.this, AddDog.class);
            intent.putExtra("method", "add");
            startActivity(intent);
            //Add Dog
        } else if (id == R.id.nav_history_list_edit_dog) {
            SharedPreferences sharedPreferences = getSharedPreferences("share_dog", MODE_PRIVATE);
            final String dogId = sharedPreferences.getString("dogID", "");

            Intent intent = new Intent(NavHistoryPage.this, AddDog.class);
            intent.putExtra("method", "edit");
            intent.putExtra("dogId", dogId);
            startActivity(intent);
            //Edit Dog Dog
        } else if (id == R.id.nav_history_page_new_lesson) {
            Intent intent = new Intent(NavHistoryPage.this, NavBasicLessonList.class);
            startActivity(intent);
        } else if (id == R.id.nav_history_page_help) {
            Intent intent = new Intent(NavHistoryPage.this, NavHelp.class);
            startActivity(intent);

        }




        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
