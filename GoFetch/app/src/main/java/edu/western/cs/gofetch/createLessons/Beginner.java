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

        Lesson comeHere = new Lesson();

        comeHere.setTitle("\"Come Here\"");
        comeHere.setDescription("25pts - Not only is it nice to have your dog come to you when you want some loving, it also can save your dog's life. " +
                "For example, if your dog just ran out of the house and is headed straight towards the road, \"Come Here,\" could prevent your dog from getting hit by a car. \n \n" +
                "With this lesson, it is best to start in your house, then your yard or a grass area, and progress to a busy area with lots of distractions. " +
                "Remember, the clicker can be used to get their attention and it will really help with this lesson \n \n");
        comeHere.setSteps("1) Put your puppy on a leash. The longer the leash, the better. A 10-foot to 20-f0ot leash is the best and this length will also help with off leash training. \n \n" +
                "2) Hold on to the leash and say, \"Come here,\" while quickly moving backwards. \n \n" +
                "3) Keep moving back until your puppy gets all the way to you. If your puppy is not responding, give a light tug on the leash while saying, \"Come here.\" \n \n" +
                "4) Once your puppy catches up to you say, \"Yes! Good boy/girl!\" Then give your dog a treat. ");

        list.add(comeHere);

        Lesson test = new Lesson();

        test.setTitle("Sit Training");
        test.setDescription("This is just a test");
        test.setSteps("1) test \n" +
                "2) test");

        list.add(test);

        return list;
    }
}
