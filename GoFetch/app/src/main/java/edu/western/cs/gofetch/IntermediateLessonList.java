package edu.western.cs.gofetch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class IntermediateLessonList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intermediate_lesson_list);
    }//OnCreate
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.help_menu2, menu);
        return super.onCreateOptionsMenu(menu);
    }//OnCreateOptionsMenu

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.help_icon:
                Intent intent = new Intent(IntermediateLessonList.this, Help.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }//switch statement
    }//OnOptionsItemSelected
}//IntermediateLessonList