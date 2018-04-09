package edu.western.cs.gofetch.lesson_related_activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import edu.western.cs.gofetch.dog_related_activities.DogProfile;
import edu.western.cs.gofetch.Help;
import edu.western.cs.gofetch.R;
import edu.western.cs.gofetch.model.Dog;
import edu.western.cs.gofetch.model.Lesson;
import io.realm.Realm;

public class StartLesson extends AppCompatActivity {
    private TextView titleText;
    private TextView counterText;
    private TextView lessonInfoText;
    private Button counterButton;

    private CountDownTimer countDownTimer;
    private long timeLeft = 10000;
    private boolean timerRunning;
    private boolean timerFinished;

    private int points;

    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_lesson);

        Intent i = getIntent();
        final String level = i.getStringExtra("level");

        SharedPreferences sharedPreferences = getSharedPreferences("share_dog", MODE_PRIVATE);
        String id = sharedPreferences.getString("dogID", "");

        titleText = findViewById(R.id.start_lesson_title);
        counterText = findViewById(R.id.countdown_text);
        lessonInfoText = findViewById(R.id.info);
        counterButton = findViewById(R.id.counter_button);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String description = intent.getStringExtra("description");
        String steps = intent.getStringExtra("steps");

        titleText.setText(title);
        lessonInfoText.setText(description + "\n" + steps);

        realm = Realm.getDefaultInstance();
        final Dog dog = realm.where(Dog.class).equalTo("id", id).findFirst();
        points = dog.getPoints();


        switch (level){
            case "0":
                points += 25;
                break;
            case "1":
                points += 50;
                break;
            case "2":
                points += 75;
                break;
            case "3":
                points += 100;
                break;
            default:
                break;

        }




        counterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!timerFinished) {
                    startStop();
                } else {
                    realm.beginTransaction();
                    dog.setPoints(points);
                    realm.commitTransaction();

                    Intent i = new Intent(StartLesson.this, DogProfile.class);
                    startActivity(i);
                }
            }
        });

    }

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
                counterButton.setText("Complete");
                counterButton.setBackgroundColor(getResources().getColor(R.color.Red));
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

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.help_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }//OnCreateOptionsMenu

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.help_icon:
                Intent intent = new Intent(StartLesson.this, Help.class);
                startActivity(intent);
                return true;
            case R.id.home_icon:
                Intent intent1 = new Intent(StartLesson.this, DogProfile.class);
                startActivity(intent1);
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
