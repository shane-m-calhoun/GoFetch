package edu.western.cs.gofetch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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
                intent.putExtra("level", "0");
                startActivity(intent);
            }//OnClick for puppy
        });//SetOnClickListener for beginner

        Button beginner = findViewById(R.id.beginner_lesson_button);
        beginner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BasicLessonList.this, BeginnerLessonList.class);
                intent.putExtra("level", "1");
                startActivity(intent);
            }//OnClick for beginner
        });//SetOnClickListener for beginner

        Button intermediate = findViewById(R.id.intermediate_lesson_button);
        intermediate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BasicLessonList.this, IntermediateLessonList.class);
                intent.putExtra("level", "3");
                startActivity(intent);
            }//OnClick for intermediate lessons
        });//SetOnClickListener for intermediate lessons
        Button advanced = findViewById(R.id.advanced_lesson_button);
        advanced.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BasicLessonList.this, AdvancedLessonList.class);
                intent.putExtra("level", "4");
                startActivity(intent);
            }//OnClick for Advanced lessons
        });//SetOnClickListener for advanced lessons
    }//OnCreate

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.help_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }//OnCreateOptionsMenu

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.help_icon:
                Intent intent = new Intent(BasicLessonList.this, Help.class);
                startActivity(intent);
                return true;
            case R.id.home_icon:
                Intent intent1 = new Intent(BasicLessonList.this, DogProfile.class);
                startActivity(intent1);
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}//BasicLessonList
