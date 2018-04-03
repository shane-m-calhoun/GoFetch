package edu.western.cs.gofetch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StartLesson extends Activity {
    private TextView titleText;
    private TextView counterText;
    private TextView lessonInfoText;
    private Button counterButton;

    private CountDownTimer countDownTimer;
    private long timeLeft = 10000;
    private boolean timerRunning;
    private boolean timerFinished;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_lesson);

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





        counterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!timerFinished) {
                    startStop();
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

}
