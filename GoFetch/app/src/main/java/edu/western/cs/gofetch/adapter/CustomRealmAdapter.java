package edu.western.cs.gofetch.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import edu.western.cs.gofetch.R;
import edu.western.cs.gofetch.model.Dog;
import io.realm.RealmBaseAdapter;
import io.realm.RealmResults;

/**
 * Created by shanecalhoun on 4/1/18.
 */

public class CustomRealmAdapter extends RealmBaseAdapter {

    RealmResults<Dog> mResults;

    public CustomRealmAdapter(RealmResults<Dog> results){
        super(results);
        mResults = results;
    }

    public void updateCustomRealmAdapter(RealmResults<Dog> newResults){
        mResults= newResults;
        updateData(newResults);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        View view;
        if(convertView==null){

            LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
            view = layoutInflater.inflate(R.layout.list, viewGroup, false);


        }else{
            view = convertView;
        }


        //identify textview and set text from Realmresults
        TextView dogName = view.findViewById(R.id.dog_name);

        Dog dog = mResults.get(position);

        dogName.setText(dog.getFirst_name());




        return view;
    }
}
