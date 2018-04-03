package edu.western.cs.gofetch.data;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import edu.western.cs.gofetch.model.Lesson;


/**
 * Created by shanecalhoun on 4/2/18.
 */

public class LessonData {

    public ArrayList<Lesson> mLessonList = new ArrayList<>();


    String data = "[\n" +
            "\n" +
            "                            {\n" +
            "                                         \"level\":\"0\",\n" +
            "                            \"title\":\"Test\",\n" +
            "                            \"description\":\"test\",\n" +
            "                            \"steps\":\"Steps test\",\n" +
            "                            }\n" +
            "\n" +
            "    ]";

    //build arraylist using json string
    public ArrayList<Lesson> buildData() {


        try {

            JSONArray jsonArray = new JSONArray(data);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);


                Lesson lesson = new Lesson();
                lesson.setTitle(jsonObject.getString("title"));
                lesson.setDescription(jsonObject.getString("description"));
                lesson.setSteps(jsonObject.getString("steps"));

                mLessonList.add(lesson);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }



        return mLessonList;
    }
}