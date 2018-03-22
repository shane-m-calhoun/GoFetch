package edu.western.cs.gofetch;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import edu.western.cs.gofetch.Dog.Dog;

/**
 * Created by Owner on 3/20/2018.
 */

public class CustomAdapter extends ArrayAdapter {
    private Context mContext;
    private int mListItemLayout;
    public ArrayList<Dog> mList;
    //Constructor
    public CustomAdapter(Context context, int resource, ArrayList<Dog> dog1) {
        super(context, resource, dog1);
        this.mContext = context;
        this.mListItemLayout = resource;
        this.mList = dog1;
    }//CustomAdapter


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(mListItemLayout, null, false);
        TextView dogName = view.findViewById(R.id.dog_name);
       /* TextView points = view.findViewById(R.id.profile_points);
        TextView breed = view.findViewById(R.id.profile_breed);
        TextView age = view.findViewById(R.id.profile_age);
        TextView weight = view.findViewById(R.id.profile_weight);*/

        final Dog dog = mList.get(position);
        dogName.setText(dog.getFirst_name());
       /* points.setText(dog.getPoints());
        breed.setText(dog.getBreed());
        age.setText(dog.getAge());
        weight.setText(dog.getWeight());*/

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, DogProfile.class);
                /*intent.putExtra(DogProfile.EXTRA_POINTS, dog.getPoints());
                intent.putExtra(DogProfile.EXTRA_BREED, dog.getBreed());
                intent.putExtra(DogProfile.EXTRA_AGE, dog.getAge());
                intent.putExtra(DogProfile.EXTRA_WEIGHT, dog.getWeight());*/
                mContext.startActivity(intent);
            }
        });


        return view;
    }//getView
}//CustomAdapter
