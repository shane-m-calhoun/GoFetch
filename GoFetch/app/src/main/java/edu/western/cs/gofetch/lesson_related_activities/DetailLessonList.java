package edu.western.cs.gofetch.lesson_related_activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import edu.western.cs.gofetch.Help;
import edu.western.cs.gofetch.R;
import edu.western.cs.gofetch.adapter.CustomAdapterL;
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
                mLessonList = puppyLessons();
                break;
            case "1":
                mLessonList = beginnerLessons();
                break;
            case "2":
                mLessonList = intermediateLessons();
                break;
            case "3":
                mLessonList = advancedLessons();
                break;
            default:
                break;

        }


        ListView listView = findViewById(R.id.detail_lesson_list);

        CustomAdapterL listAdapter = new CustomAdapterL(DetailLessonList.this, R.layout.lesson_list, mLessonList);
        listView.setAdapter(listAdapter);

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

    public ArrayList<Lesson> puppyLessons(){
        ArrayList<Lesson> list = new ArrayList<>();

        Lesson test = new Lesson();
        test.setTitle("Crate Training");
        test.setDescription("This is just a test");
        test.setSteps("1) test \n" +
                "2) test");
        list.add(test);

        return list;
    }

    public ArrayList<Lesson> beginnerLessons(){
        ArrayList<Lesson> list = new ArrayList<>();

        Lesson test = new Lesson();
        test.setTitle("Sit Training");
        test.setDescription("This is just a test");
        test.setSteps("1) test \n" +
                "2) test");
        list.add(test);

        return list;
    }

    public ArrayList<Lesson> intermediateLessons(){
        ArrayList<Lesson> list = new ArrayList<>();

        Lesson test = new Lesson();
        test.setTitle("Rollover Training");
        test.setDescription("This is just a test");
        test.setSteps("1) test \n" +
                "2) test");
        list.add(test);

        return list;
    }

    public ArrayList<Lesson> advancedLessons(){
        ArrayList<Lesson> list = new ArrayList<>();

        Lesson test = new Lesson();
        test.setTitle("Off-Leash Training");
        test.setDescription("This is just a test");
        test.setSteps("1) test \n" +
                "2) test");
        list.add(test);

        return list;
    }

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