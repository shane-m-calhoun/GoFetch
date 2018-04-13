package edu.western.cs.gofetch.account_related_activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.view.View;

import edu.western.cs.gofetch.dog_related_activities.NavDogList;
import edu.western.cs.gofetch.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar
        Toolbar toolbar =findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button login = findViewById(R.id.login_button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NavDogList.class);
                startActivity(intent);
            }
        });
        Button createAccount = findViewById(R.id.create_account_button);
        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CreateAccount.class);
                startActivity(intent);
            }
        });
    }









}//MainActivity Class
