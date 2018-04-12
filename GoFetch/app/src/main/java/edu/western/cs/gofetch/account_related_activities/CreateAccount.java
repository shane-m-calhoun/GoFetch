package edu.western.cs.gofetch.account_related_activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.western.cs.gofetch.R;
import edu.western.cs.gofetch.dog_related_activities.NavDogList;

public class CreateAccount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        //Create Button takes you to DogList Class!
        Button createButton = findViewById(R.id.create_button);
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CreateAccount.this, NavDogList.class);
                startActivity(intent);
            }//onClick method
        });//setOnClickListener
    }//onCreate


}//CreateAccount
