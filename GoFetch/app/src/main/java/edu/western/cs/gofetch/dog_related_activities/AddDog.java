package edu.western.cs.gofetch.dog_related_activities;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import edu.western.cs.gofetch.R;
import edu.western.cs.gofetch.model.Dog;

import java.util.UUID;

import io.realm.Realm;

public class AddDog extends AppCompatActivity {

    Realm realm;
    private Dog dog;
    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dog);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        realm = Realm.getDefaultInstance();

        final EditText name = findViewById(R.id.edit_name);
        final EditText breed = findViewById(R.id.edit_breed);
        final EditText age = findViewById(R.id.edit_age);
        final EditText weight = findViewById(R.id.edit_weight);

        final Intent intent = getIntent();
        final String method = intent.getStringExtra("method");

        if(method.equals("edit")){
            id = intent.getStringExtra("dogId");
            dog = realm.where(Dog.class).equalTo("id", id).findFirst();

            name.setText(dog.getFirst_name());
            breed.setText(dog.getBreed());
            age.setText(dog.getAge());
            weight.setText(dog.getWeight());
        }

        //Create Save Button to go back to dog list activity
        Button saveButton = findViewById(R.id.save_dog);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(method.equals("add")) {
                    realm.beginTransaction();

                    dog = realm.createObject(Dog.class, UUID.randomUUID().toString());

                    dog.setFirst_name(name.getText().toString());
                    dog.setBreed(breed.getText().toString());
                    dog.setAge(age.getText().toString());
                    dog.setWeight(weight.getText().toString());
                    dog.setPoints(0);
                    realm.commitTransaction();

                }else if(method.equals("edit")){
                    realm.beginTransaction();
                    dog.setFirst_name(name.getText().toString());
                    dog.setBreed(breed.getText().toString());
                    dog.setAge(age.getText().toString());
                    dog.setWeight(weight.getText().toString());
                    dog.setPoints(0);
                    realm.commitTransaction();

                }

                Intent intent = new Intent(AddDog.this, NavDogList.class);
                startActivity(intent);
            }//OnClick
        });//SetOnClickListener
    }//OnCreate

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }
}//AddDog
