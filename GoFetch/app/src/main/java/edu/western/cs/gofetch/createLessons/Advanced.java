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

        headDown.setTitle("Head Down");
        headDown.setDescription("Getting your dog to lay their head down is really cute and it is the easiest advanced lesson to teach your dog. " +
                "In the next lesson, we teach how to get your dog to look at you and when head down and look at me is combined, it is adorable." +
                "Besides being cute, head down is a great position to tell your dog to stay in since it minimizes distractions. \n \n ");
        headDown.setSteps("1) Get your dog in the lay down position. \n \n" +
                "2) Kneel down in front of your dog and hold a treat in front of the dogs nose. \n \n " +
                "3) Slowly bring the treat to the ground. \n \n" +
                "4) As your dog lays their head onto the floor, tell the dog \"head down,\" press the clicker and reward your dog with a treat. \n \n " +
                "5) Keep repeating this until your dog is able to lay their head down through only a verbal command and not being guided by the treat. \n \n" +
                "6) Once your dog knows the trick by command, begin to lengthen the duration before you press your clicker and give the dog a reward. ");
        list.add(headDown);



        Lesson lookAtMe = new Lesson();

        lookAtMe.setTitle("Look at Me");
        lookAtMe.setDescription("Dogs are intelligent animals and they can detect humans' emotions through facial expression. " +
                "By teaching your dog to look at you on command, they will be able to detect when you are proud of them and when you are disappointed with them. " +
                "Look at me is also a great way to get your dog to pay attention to you and not the distractions in the environment, making the dog better behaved. \n \n");
        lookAtMe.setSteps("1) Either have your dog sit or stand, it should be practiced in both positions. \n \n" +
                "2) Show your dog a treat, and raise the treat to your nose. \n \n " +
                "3) As the dog follows the treat to your face, tell your dog \"look at me.\" \n \n" +
                "4) Press your clicker and reward the dog with a treat. \n \n " +
                "5) Keep repeating until your dog does not needed to be guided by the treat inorder to look at you. \n \n " +
                "6) Practice this everywhere that you and your dog goes. \n \n " +
                "7) Finally, challenge your dog to lay their head down and look at you while they keep their head on the ground. ");
        list.add(lookAtMe);


        Lesson putAway = new Lesson();

        putAway.setTitle("Put Away");
        putAway.setDescription("Teaching your dog to put away their toys on command will make your life so much easier..." +
                "now you will not have to clean up after your dog! \n \n ");
        putAway.setSteps("1) Get a basket that you want to store all of your dog's toys in. " +
                "Keep the basket in the same place, that way your dog won't have to search for it or get confused. \n \n" +
                "2) Place a toy next to the basket and tell them to get the toy. \n \n" +
                "3) Once the dog has the toy, lure the dog over the basket with a treat. \n \n" +
                "4) When over the basket, tell your dog \"leave it,\"" +
                "5) When the dog drops the toy in the basket, tell them \"put away,\" press your clicker, and reward your dog with a treat. \n \n" +
                "5) Keep practicing until the dog can do it on command. \n \n" +
                "6) Remember, consistency is key, so keep practicing everyday! ");
        list.add(putAway);
        

        Lesson noLeashPull = new Lesson();

        noLeashPull.setTitle("No Leash Pull");
        noLeashPull.setDescription("Dogs are not born to walk on leashes, they must be taught. " +
                "Teaching your dog to properly walk on a leash is very time consuming and takes a lot of consistency. " +
                "It requires lots of tasty treats and lots of practice. " +
                "Once your dog is able to walk by your side while they are on a leash, it will become a breeze to teach your dog to walk off-leash.\n \n ");
        noLeashPull.setSteps("1) Equip your dog with a harness and a 6-foot leash. \n \n" +
                "2) Start in front of your home. By having your dog in a familiar environment, your dog will have less distractions. \n \n " +
                "3) Get your dog to sit and stay, walk up next to your dog and stand still. \n \n " +
                "4) Once your next to your dog, release the dog by using a command, such as \"ok.\"" +
                "5) The goal is to let your dog know that they have to keep an eye on your and that your choosing the direction that you walk. \n " +
                "This is done by changing directions frequently. Every time your dog's shoulder goes ahead of your hip, turn around with no command. \n \n" +
                "6) Once your dog turns around and gets next to you again, press your clicker and give your dog a treat. \n \n" +
                "7) Keep repeating step 5 and 6 until your dog is staying at your side. \nTHIS WILL TAKE A LONG TIME TO BUILD THE HABIT! \n \n" +
                "8) Eventually, your dog will be consistently walking by your side. When your dog doesn't stay by your side, just repeat step 5 and 6. " +
                "If your dog is having a bad day you might have to go back to step 4 in the middle of your walk. \n \n" +
                "9) If your dog gets distracted, have your dog sit and ask them to look at you. " +
                "When your dog looks at you, praise them, press your clicker, and give your dog a tasty reward. " +
                "Eventually, your dog will stop being distracted, which means they are ready to start learning to walk off-leash!!! \n \n " +
                "Practice, practice, practice! This lesson takes a lot of consistency, but it will pay off in the future! ");
        list.add(noLeashPull);
        
        
        Lesson offLeash = new Lesson();

        offLeash.setTitle("Off-Leash Training");
        offLeash.setDescription("Training your dog to be able to walk off-leash has many benefits. " +
                "In most places, it is required that your dog is on a leash, but having your dog know how to walk off-leash will make the dog listen to you everywhere. " +
                "For example, if your dog knows how to walk off-leash, it will be much easier to control your dog at a dog park. " +
                "Also, some hiking trails allow your dog to be off-leash and you don't want your dog to chase a bird off of a cliff! " +
                "Follow these steps and before you know it, your dog will be well behaved when off-leash. \n \n " +
                "You will need: 15-20 foot leash/lead, your dog's favorite fetch toy, and lots of treats. \n \n ");
        offLeash.setSteps("1) First, get your dog some exercise so they will listen to your better. \n \n" +
                "2) Take your dog to a large field that is familiar to your dog and put the dog on a 15-20 foot leash (use caution and don't get tripped by the leash). " +
                "The leas is only used if your dog starts running towards a distraction, otherwise you do not need to hold the leash. \n \n" +
                "3) Practice all of the past lessons that your dog can do flawlessly at home. \n \n " +
                "4) Reward for every single good behavior since your dog is in a different environment than the one they are use to. \n \n" +
                "5) Practice the surprise stay: Get your dogs attention with a toy. Once you have your dog's attention, throw the toy and tell them to stay at the same time. " +
                "If your dog stays, press your clicker and reward the dog with a treat. If your dog chases the toy, grab the leash and calmly say \"No, stay.\" \n \n " +
                "6) Practice this frequently and in new environments. After 4-6 months your dog should listen to you no matter what and they will be ready to walk off the leash.");
        list.add(offLeash);

        return list;
    }
}
