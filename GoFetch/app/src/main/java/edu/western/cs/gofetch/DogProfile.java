package edu.western.cs.gofetch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DogProfile extends AppCompatActivity {
    public static final String EXTRA_BREED = "breed";
    public static final String EXTRA_POINTS = "points";
    public static final String EXTRA_AGE = "age";
    public static final String EXTRA_WEIGHT = "weight";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog_profile);

        TextView points = findViewById(R.id.profile_points);
        Intent intent = getIntent();
        String points1 = intent.getStringExtra(EXTRA_POINTS);
        points.setText(points1);

        TextView breed = findViewById(R.id.profile_breed);
        Intent intent1 = getIntent();
        String breed1 = intent1.getStringExtra(EXTRA_BREED);
        breed.setText(breed1);

        TextView age = findViewById(R.id.profile_age);
        Intent intent2 = getIntent();
        String age1 = intent2.getStringExtra(EXTRA_AGE);
        age.setText(age1);

        TextView weight = findViewById(R.id.profile_weight);
        Intent intent3 = getIntent();
        String weight1 = intent3.getStringExtra(EXTRA_WEIGHT);
        weight.setText(weight1);
    }
}
