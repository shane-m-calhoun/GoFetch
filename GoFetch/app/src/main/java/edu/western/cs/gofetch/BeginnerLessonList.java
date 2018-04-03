package edu.western.cs.gofetch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import edu.western.cs.gofetch.adapter.CustomAdapterL;
import edu.western.cs.gofetch.data.LessonData;
import edu.western.cs.gofetch.model.Lesson;

public class BeginnerLessonList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beginner_lesson_list);

        final ArrayList<Lesson> mLessonList = beginnerLessons();

        ListView listView = findViewById(R.id.beginner_list);

        CustomAdapterL listAdapter = new CustomAdapterL(BeginnerLessonList.this, R.layout.lesson_list, mLessonList);
        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(BeginnerLessonList.this, StartLesson.class);

                intent.putExtra("title", mLessonList.get(i).getTitle());
                intent.putExtra("description", mLessonList.get(i).getDescription());
                intent.putExtra("steps", mLessonList.get(i).getSteps());
                intent.putExtra("level", "1");

                startActivity(intent);
            }
        });
    }//OnCreate

    public ArrayList<Lesson> beginnerLessons(){
        ArrayList<Lesson> list = new ArrayList<>();

        return list;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.help_menu2, menu);
        return super.onCreateOptionsMenu(menu);
    }//OnCreateOptionsMenu

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.help_icon:
                Intent intent = new Intent(BeginnerLessonList.this, Help.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }//switch statement
    }//OnOptionsItemSelected
}//BeginnerLessonList
