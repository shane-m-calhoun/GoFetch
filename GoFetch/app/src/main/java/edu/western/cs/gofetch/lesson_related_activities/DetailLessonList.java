package edu.western.cs.gofetch.lesson_related_activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import edu.western.cs.gofetch.Help;
import edu.western.cs.gofetch.R;
import edu.western.cs.gofetch.adapter.CustomAdapterL;
import edu.western.cs.gofetch.createLessons.Advanced;
import edu.western.cs.gofetch.createLessons.Beginner;
import edu.western.cs.gofetch.createLessons.Intermediate;
import edu.western.cs.gofetch.createLessons.Puppy;
import edu.western.cs.gofetch.data.LessonData;
import edu.western.cs.gofetch.dog_related_activities.DogProfile;
import edu.western.cs.gofetch.model.Lesson;

public class DetailLessonList extends AppCompatActivity {
    private ArrayList<Lesson> mLessonList;
    private String level;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_lesson_list);

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

        CustomAdapterL listAdapter = new CustomAdapterL(DetailLessonList.this, R.layout.lesson_list, mLessonList);
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
                Intent intent = new Intent(DetailLessonList.this, StartLesson.class);

                intent.putExtra("title", mLessonList.get(i).getTitle());
                intent.putExtra("description", mLessonList.get(i).getDescription());
                intent.putExtra("steps", mLessonList.get(i).getSteps());
                intent.putExtra("level", level);

                startActivity(intent);
            }
        });

    }//OnCreate


    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.help_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }//OnCreateOptionsMenu

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.help_icon:
                Intent intent = new Intent(DetailLessonList.this, Help.class);
                startActivity(intent);
                return true;
            case R.id.home_icon:
                Intent intent1 = new Intent(DetailLessonList.this, DogProfile.class);
                startActivity(intent1);
            default:
                return super.onOptionsItemSelected(item);
        }//switch statement
    }//OnOptionsItemSelected
}//PuppyLessonList