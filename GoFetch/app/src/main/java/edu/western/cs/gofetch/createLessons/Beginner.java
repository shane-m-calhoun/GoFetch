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
                "4) Once your puppy catches up to you say, \"Yes! Good boy/girl!\" Then press your clicker and give your dog a treat. ");

        list.add(comeHere);


        Lesson sitDown = new Lesson();

        sitDown.setTitle("Sit Down");
        sitDown.setDescription("Teaching your dog is very useful. It will help you to teach your dog to lay and sit. Once your dog knows how to sit on command, your will be using it more than you expected \n \n" +
                "As with any lesson, use plenty of treats and a calm voice! \n \n ");
        sitDown.setSteps("1) First, get your dog's attention using the clicker method. \n \n" +
                "2) Show your dog a treat. \n \n" +
                "3) Move the treat from the tip of the dog's nose to behind the dogs head. \n \n " +
                "4) Tell the dog \"sit\" as it is sitting down. \n \n" +
                "5) Praise the dog for doing the trick. \n \n" +
                "6) Release the dog from the sit position by saying \"ok\"  or \"come here,\" press your clicker and give the dog a treat.\n \n" +
                "7) Repeat the trick for the rest of the training session. Keep training until the dog does it perfectly for a whole training lesson or two. ");

        list.add(sitDown);


        Lesson layDown = new Lesson();

        layDown.setTitle("Lay Down");
        layDown.setDescription("Like sit, getting your dog to lay down is useful and will help you teach your dog more advanced tricks. " +
                "The more basic tricks that your dog knows will allow them to be a better listener which will make them a more behaved dog. \n \n" +
                "Once again, give your dog plenty of treats while you are teaching your dog something new and always use a calm voice.");
        layDown.setSteps("1) Get your dogs attention using the clicker method. \n \n" +
                "2) Show the dog a treat \n \n" +
                "3) Have the dog sit \n \n" +
                "4) Once the dog is sitting, hold the treat in front of their nose and slowly lower the treat to the ground. \n \n " +
                "5) As the dog is laying down, say \"lay\" or \"lay down.\" \n \n " +
                "6) Praise the dog. \n \n" +
                "7) Release the dog from the sit position by saying \"ok\"  or \"come here,\" press your clicker and give the dog a treat. \n \n" +
                "8) Repeat the trick for the rest of the training session. Keep training until the dog does it perfectly for a whole training session or two. ");

        list.add(layDown);


        Lesson stay = new Lesson();

        stay.setTitle("Stay");
        stay.setDescription("Stay is the most useful beginner lesson. When a guest comes to the house, stay will prevent the dog from running up and jumping on your guest." +
                "Stay will also be very useful when playing fetch (an intermediate lessons) or when your dog sees a bird or another dog while the dog is hiking off-leash (an advanced-lesson). \n \n");
        stay.setSteps("1) Get your dog's attention using the clicker method and have the dog lay down. \n \n" +
                "2) Now tell your dog to stay in a calm voice and hold your hand in front of the dogs face with your palm facing the dog. \n \n" +
                "3) After a few second, press your clicker and give the dog a treat while the dog is still laying down. \n \n " +
                "BE ADVISED: If your dog does not stay, do not yell at your dog, simply do not use your clicker and do not reward the dog. " +
                "Yelling at the dog can be counterproductive, the dog will think you yelled at them for staying. \n \n" +
                "4) Repeat 1-3 for an entire training session. \n \n " +
                "5) When the dog is ready, repeat step 1-3 but taking a step back after you tell your dog to stay. When you click, take a step forward and give your dog a treat. Try to get this perfect for an entire lesson. \n \n " +
                "6) Finally, keep progressing the length and distance that your dog stays. Do not progress to quickly, this will only be counterproductive. ");

        list.add(stay);

        return list;
    }
}
