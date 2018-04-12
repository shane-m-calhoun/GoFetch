package edu.western.cs.gofetch.createLessons;

import java.util.ArrayList;

import edu.western.cs.gofetch.model.Lesson;

/**
 * Created by shanecalhoun on 4/11/18.
 */

public class Beginner {
    public static ArrayList<Lesson> beginnerLessons(){
        ArrayList<Lesson> list = new ArrayList<>();

        Lesson clickerTraining = new Lesson();

        clickerTraining.setTitle("Clicker Training");
        clickerTraining.setDescription("25pts. - Dogs learn by performing behaviors that result in a reward (treat). " +
                "The more often a dog performs a behavior that results in a reward, the more the dog will repeat that behavior. " +
                "By training a dog with a clicker, the sound will make them ready to receive a reward, which will allow your dog to learn new lessons quicker. \n \n" +
                "You can either buy a clicker, a dog whistle, or make a clicking noise with your mouth. \n \n");
        clickerTraining.setSteps("1) Condition your dog to the clicker. Sound the clicker and then reward the dog with a small treat (the primary reinforcer). \n\n" +
                "2) Towards the end of the first training session, start to praise and play (secondary reinforcer) with the dog after the dog's response and giving them a treat. \n \n" +
                "3) After multiple training sessions, begin to slowly take way the treat and the praise will eventually become the primary/only reward. \n \n " +
                "4) Don't move on to the next lesson until the dog is able to keep responding to the clicker noise for an entire session, while only rewarding the dog with praise. ");

        list.add(clickerTraining);

        Lesson test = new Lesson();

        test.setTitle("Sit Training");
        test.setDescription("This is just a test");
        test.setSteps("1) test \n" +
                "2) test");

        list.add(test);

        return list;
    }
}
