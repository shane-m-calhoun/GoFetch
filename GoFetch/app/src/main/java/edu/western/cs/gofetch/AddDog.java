package edu.western.cs.gofetch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddDog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dog);
        //Create Save Button to go back to dog list activity
        Button saveButton = findViewById(R.id.save_dog);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddDog.this, DogList.class);
                startActivity(intent);
            }//OnClick
        });//SetOnClickListener
    }//OnCreate
}//AddDog
