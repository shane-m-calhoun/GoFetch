package edu.western.cs.gofetch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BasicLessonList extends AppCompatActivity {
    //Array less[] = ["Puppy", "Beginner", "Intermediate", "Advanced"];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_lesson_list);

        Button puppy = findViewById(R.id.puppy_lesson_button);
        puppy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BasicLessonList.this, PuppyLessonList.class);
                startActivity(intent);
            }//OnClick for puppy
        });//SetOnClickListener for beginner

        Button beginner = findViewById(R.id.beginner_lesson_button);
        beginner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent beginnerIntent = new Intent(BasicLessonList.this, BeginnerLessonList.class);
                startActivity(beginnerIntent);
            }//OnClick for beginner
        });//SetOnClickListener for beginner

        Button intermediate = findViewById(R.id.intermediate_lesson_button);
        intermediate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent interIntent = new Intent(BasicLessonList.this, IntermediateLessonList.class);
                startActivity(interIntent);
            }//OnClick for intermediate lessons
        });//SetOnClickListener for intermediate lessons
        Button advanced = findViewById(R.id.advanced_lesson_button);
        advanced.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent advancedIntent = new Intent(BasicLessonList.this, AdvancedLessonList.class);
                startActivity(advancedIntent);
            }//OnClick for Advanced lessons
        });//SetOnClickListener for advanced lessons
    }//OnCreate
}//BasicLessonList
