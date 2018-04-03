package edu.western.cs.gofetch.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import edu.western.cs.gofetch.R;

import edu.western.cs.gofetch.model.Lesson;


/**
 * Created by shanecalhoun on 4/2/18.
 */

public class CustomAdapterL extends ArrayAdapter{
    private Context mContext;
    private int mListItemLayout;
    private ArrayList<Lesson> mList;

    public CustomAdapterL(Context context, int resource, ArrayList<Lesson> lessons) {
        super(context,resource,lessons);

        mContext = context;
        mListItemLayout = resource;
        mList = lessons;

    }

    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        View view;


        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        view = layoutInflater.inflate(mListItemLayout, null, false);





        //identify textview and set text from Realmresults
        TextView LessonName = view.findViewById(R.id.lesson_title);

        Lesson lesson = mList.get(position);

        LessonName.setText(lesson.getTitle());




        return view;
    }

}