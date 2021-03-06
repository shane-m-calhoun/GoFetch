package edu.western.cs.gofetch;

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
import android.widget.TextView;

import java.util.ArrayList;

import edu.western.cs.gofetch.adapter.CustomRealmAdapter;
import edu.western.cs.gofetch.adapter.CustomRealmAdapterHistory;
import edu.western.cs.gofetch.dog_related_activities.AddDog;
import edu.western.cs.gofetch.dog_related_activities.NavDogList;
import edu.western.cs.gofetch.dog_related_activities.NavDogProfile;
import edu.western.cs.gofetch.lesson_related_activities.NavBasicLessonList;
import edu.western.cs.gofetch.model.Dog;
import edu.western.cs.gofetch.model.History;
import io.realm.Realm;
import io.realm.RealmResults;

public class NavHistory extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private Realm realm;
    RealmResults<History> mResults;
    ArrayList<History> mHistoryList;
    CustomRealmAdapterHistory mCustomRealmAdapter;
    private String id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_history);
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

        ListView historyList = findViewById(R.id.nav_history);
        RelativeLayout noHistory = findViewById(R.id.no_history_layout);
        Button noHistBack = findViewById(R.id.no_history);

        SharedPreferences sharedPreferences = getSharedPreferences("share_dog", MODE_PRIVATE);
        id = sharedPreferences.getString("dogID", "");

        realm = Realm.getDefaultInstance();

        mResults= realm.where(History.class).equalTo("dogId", id).findAll();

        mHistoryList = new ArrayList<>(mResults);

        if(mHistoryList.isEmpty()){
            historyList.setVisibility(ListView.GONE);
            noHistory.setVisibility(RelativeLayout.VISIBLE);
        }

        mCustomRealmAdapter = new CustomRealmAdapterHistory(mResults);
        historyList.setAdapter(mCustomRealmAdapter);

        historyList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(NavHistory.this, NavHistoryPage.class);
                History history = mHistoryList.get(i);
                intent.putExtra("lessonId", history.getId());
                startActivity(intent);
            }
        });

        noHistBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NavHistory.this, NavDogProfile.class);
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
            Intent intent = new Intent(NavHistory.this, NavDogProfile.class);
            startActivity(intent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nav_history, menu);
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
        if (id == R.id.nav_history_profile) {
            Intent intent = new Intent(NavHistory.this, NavDogProfile.class);
            startActivity(intent);
        } else if (id == R.id.nav_history_list) {
            Intent intent = new Intent(NavHistory.this, NavDogList.class);
            startActivity(intent);
        }else if (id == R.id.nav_history_add) {
            Intent intent = new Intent(NavHistory.this, AddDog.class);
            intent.putExtra("method", "add");
            startActivity(intent);
            //Add Dog
        } else if (id == R.id.nav_history_edit_dog) {
            SharedPreferences sharedPreferences = getSharedPreferences("share_dog", MODE_PRIVATE);
            final String dogId = sharedPreferences.getString("dogID", "");

            Intent intent = new Intent(NavHistory.this, AddDog.class);
            intent.putExtra("method", "edit");
            intent.putExtra("dogId", dogId);
            startActivity(intent);
            //Edit Dog Dog
        } else if (id == R.id.nav_history_new_lesson) {
            Intent intent = new Intent(NavHistory.this, NavBasicLessonList.class);
            startActivity(intent);
        } else if (id == R.id.nav_history_help) {
            Intent intent = new Intent(NavHistory.this, NavHelp.class);
            startActivity(intent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
