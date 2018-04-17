package edu.western.cs.gofetch.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import edu.western.cs.gofetch.R;

import edu.western.cs.gofetch.model.History;
import io.realm.RealmBaseAdapter;
import io.realm.RealmResults;

/**
 * Created by shanecalhoun on 4/16/18.
 */

public class CustomRealmAdapterHistory extends RealmBaseAdapter {
    RealmResults<History> mResults;

    public CustomRealmAdapterHistory(RealmResults<History> results){
        super(results);
        mResults = results;
    }

    public void updateCustomRealmAdapter(RealmResults<History> newResults){
        mResults= newResults;
        updateData(newResults);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        View view;
        if(convertView==null){

            LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
            view = layoutInflater.inflate(R.layout.history_list_item, viewGroup, false);


        }else{
            view = convertView;
        }


        //identify textview and set text from Realmresults
        TextView title = view.findViewById(R.id.hist_title);
        TextView date = view.findViewById(R.id.history_date);

        History history = mResults.get(position);

        title.setText(history.getLessonTitle());
        date.setText(history.getDate());




        return view;
    }

}
