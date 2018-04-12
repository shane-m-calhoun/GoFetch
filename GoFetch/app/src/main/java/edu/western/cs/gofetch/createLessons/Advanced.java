package edu.western.cs.gofetch.createLessons;

import java.util.ArrayList;

import edu.western.cs.gofetch.model.Lesson;

/**
 * Created by shanecalhoun on 4/11/18.
 */

public class Advanced {
    public static ArrayList<Lesson> advancedLessons(){
        ArrayList<Lesson> list = new ArrayList<>();

        Lesson test = new Lesson();

        test.setTitle("Off-Leash Training");
        test.setDescription("This is just a test");
        test.setSteps("1) test \n" +
                "2) test");
        list.add(test);

        return list;
    }
}
