package edu.western.cs.gofetch.createLessons;

import java.util.ArrayList;

import edu.western.cs.gofetch.model.Lesson;

/**
 * Created by shanecalhoun on 4/11/18.
 */

public class Puppy {
    public static ArrayList<Lesson> puppyLessons(){
        ArrayList<Lesson> list = new ArrayList<>();

        Lesson crateTraining = new Lesson();

        crateTraining.setTitle("Crate Training");
        crateTraining.setDescription("25pts. - Dogs are den animals and crate training takes advantage of this natural instinct. " +
                "A den is a wild dog's home. It provides a place to sleep, hide from danger and raise their pups. " +
                "A crate will mimic this environment and provide your puppy with a place that they can find comfort and solitude. " +
                "It also comforts the owner, since they know that there puppy is not making a mess of the house while they are gone. \n \n" +
                "NEVER use the crate as punishment.\n \nNEVER force the puppy/dog into the crate.\n \nGive a TREAT when the dog enters the crate.\n \nDon't leave them in the crate for too long.\n \n" +
                "Puppies have small bladders and shouldn't be left in the crate for more than 3-4 hours.\n \n" +
                "Once you trust your dog to not destroy the house it should only be a place for them to voluntarily go.\n\n");
        crateTraining.setSteps("1) For the first multiple training session (15 minutes each), drop treats, or toss toys, into the crate and say, \"In your crate.\" Leave the door open and tell them, \"Good in your crate.\" " +
                "ALWAYS use a SOFT TONE. " +
                "Repeat this step until they seem comfortable with entering.\n \n" +
                "2) Feed your puppy/dog in their crate. (Leave the door closed for the length of the training session (15 minutes).\n \n" +
                "3) Start practicing longer crating periods.\n \n" +
                "4) Crate your puppy when you leave.\n \n" +
                "5) Crate your puppy at night.\n \n");

        list.add(crateTraining);


        Lesson pottyTraining = new Lesson();

        pottyTraining.setTitle("Potty Training");
        pottyTraining.setDescription("25pts - Cleaning up after your puppy pees or poops in the house is never a fun task. \n" +
                "Knowing how to properly potty train your puppy will make it less likely that you will ever have to do that. \n \n" +
                "Crate training your puppy first will make this process easier. \n \n" +
                "Naturally your puppy will not want to pee or poop in their space making the crate a great place for them to stay while you are gone or asleep. \n \n" +
                "Choose their sleeping spot carefully. \nBy having your puppy sleep in it's crate it will prevent them from wanting to go potty as soon as they wake up during the night. " +
                "If your puppy starts winning or barking at night, let them out so they do not have an accident in their crate. \n \n" +
                "Crate your puppy while you are gone. \nThis will help prevent them from developing a habit of peeing or pooping in the house. \n" +
                "Try to not be gone for more than 3-4hours. Puppies  have small bladders and it will be hard for them to hold it for that long. \n \n" +
                "If you find an accident in the house, NEVER punish or push the puppy's face into the mess...they will not understand why you are being abusive. \n \n");
        pottyTraining.setSteps("1) Limit the space your puppy is allowed to roam, if you can, buy a Dog Exercise Pen. \n \n" +
                "2) While you are at home, take your puppy outside once an hour. If possible, find a friend or neighbor that will let your puppy out while you are gone. \n \n" +
                "3) Every time that your puppy goes potty outside, reward them with praise and a treat. \n \n" +
                "4) Any time you catch your puppy going potty in the house, say, \"NO,\" but not too aggressively. " +
                "Quickly pick your puppy up and take it outside to finish. When the puppy starts going potty outside, once again, praise the puppy. \n \n");

        list.add(pottyTraining);


        return list;
    }
}
