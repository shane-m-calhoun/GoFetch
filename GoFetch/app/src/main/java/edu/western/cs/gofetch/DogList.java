package edu.western.cs.gofetch;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import edu.western.cs.gofetch.Dog.Dog;


public class DogList extends AppCompatActivity {

    ArrayList<Dog> dogs = new ArrayList<Dog>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog_list);

        Dog kenai = new Dog();
        kenai.setFirst_name("Kenai");
        kenai.setAge(1);
        kenai.setBreed("Mini Aussie");
        kenai.setPoints(100);
        kenai.setWeight(25);
        ListView dogList = findViewById(R.id.dog_list);
        dogs.add(kenai);
        CustomAdapter adapter = new CustomAdapter(DogList.this, R.layout.activity_dog_profile, dogs);
        dogList.setAdapter(adapter);



    }//onCreate
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }//OnCreateOptionsMenu

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_dog:
                Intent intent = new Intent(DogList.this, AddDog.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }//Switch statement
    }//OnOptionItemSelected



}//DogList
