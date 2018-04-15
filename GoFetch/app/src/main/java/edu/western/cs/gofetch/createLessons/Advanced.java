package edu.western.cs.gofetch.createLessons;

import java.util.ArrayList;

import edu.western.cs.gofetch.model.Lesson;

/**
 * Created by shanecalhoun on 4/11/18.
 */

public class Advanced {
    public static ArrayList<Lesson> advancedLessons(){
        ArrayList<Lesson> list = new ArrayList<>();


        Lesson headDown = new Lesson();

        headDown.setTitle("Rollover");
        headDown.setDescription("This is just a headDown");
        headDown.setSteps("1) headDown \n" +
                "2) headDown");
        list.add(headDown);



        Lesson lookAtMe = new Lesson();

        lookAtMe.setTitle("Rollover");
        lookAtMe.setDescription("This is just a lookAtMe");
        lookAtMe.setSteps("1) lookAtMe \n" +
                "2) lookAtMe");
        list.add(lookAtMe);


        Lesson putAway = new Lesson();

        putAway.setTitle("Rollover");
        putAway.setDescription("This is just a putAway");
        putAway.setSteps("1) putAway \n" +
                "2) putAway");
        list.add(putAway);
        

        Lesson heel = new Lesson();

        heel.setTitle("Rollover");
        heel.setDescription("This is just a heel");
        heel.setSteps("1) heel \n" +
                "2) heel");
        list.add(heel);
        
        
        Lesson offLeash = new Lesson();

        offLeash.setTitle("Off-Leash Training");
        offLeash.setDescription("This is just a offLeash");
        offLeash.setSteps("1) offLeash \n" +
                "2) offLeash");
        list.add(offLeash);

        return list;
    }
}
