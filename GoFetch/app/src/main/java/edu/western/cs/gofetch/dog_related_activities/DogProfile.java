package edu.western.cs.gofetch.dog_related_activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import edu.western.cs.gofetch.leaderboard_related_activites.Leaderboard;
import edu.western.cs.gofetch.R;
import edu.western.cs.gofetch.lesson_related_activities.BasicLessonList;
import edu.western.cs.gofetch.model.Dog;
import io.realm.Realm;

public class DogProfile extends AppCompatActivity {
    public static final String EXTRA_ID = "id";
    Realm realm;
    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog_profile);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
//        Intent intent = getIntent();
//        //Contact contact = (Contact) intent.getSerializableExtra(EXTRA_CONTACT);
//        final String id = intent.getStringExtra(EXTRA_ID);


        SharedPreferences sharedPreferences = getSharedPreferences("share_dog", MODE_PRIVATE);
        id = sharedPreferences.getString("dogID", "");


        //retrieve contact from Realm
        realm = Realm.getDefaultInstance();
        final Dog dog = realm.where(Dog.class).equalTo("id", id).findFirst();

        TextView name = findViewById(R.id.profile_name_data);
        TextView points = findViewById(R.id.profile_points_data);
        TextView breed = findViewById(R.id.profile_breed_data);
        TextView age = findViewById(R.id.profile_age_data);
        TextView weight = findViewById(R.id.profile_weight_data);


        name.setText(dog.getFirst_name());
        points.setText(dog.getPoints() + " pts.");
        breed.setText(dog.getBreed());
        age.setText(dog.getAge());
        weight.setText(dog.getWeight());

        Button newLesson = findViewById(R.id.peofile_new_lesson_button);
        newLesson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent lessonIntent = new Intent(DogProfile.this, BasicLessonList.class);
                startActivity(lessonIntent);
            }//OnClick
        });//setOnClickListener
//        Button leaderBoard = findViewById(R.id.profile_leader_board_button);
//        leaderBoard.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent leaderIntent = new Intent(DogProfile.this, Leaderboard.class);
//                startActivity(leaderIntent);
//            }
//        });

    }//OnCreate


}//DogProfile
