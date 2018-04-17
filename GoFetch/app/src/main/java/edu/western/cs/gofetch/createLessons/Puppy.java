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

        Lesson handling = new Lesson();

        handling.setTitle("Bathing");
        handling.setDescription("25pts - Getting your puppy comfortable with taking a bath is important. Not only will this make it easier for your, it will make it less stressful for your puppy. " +
                "When doing this lesson, if your puppy freaks out, slow it down! Give them more treats, be playful, and reassure the puppy that it is ok. Always keep a calm voice! Keep the water at room temperature. \n \n");
        handling.setSteps("1) Take a long walk first. This will make your puppy tired and they will have less energy to fight you. \n \n" +
                "2) Slowly introduce the puppy to the bed. Get them in the bath tub on their own by guiding the puppy in with a treat. \n \n" +
                "3) Keep giving the puppy treats, this will cause them to like the bath tub. After multiple treats, turn the bath tub on low so the noise doesn't scare them. keep being playful, reassuring, and givng a liberal amount of treats. \n \n" +
                "4) Fill up a cup with water and slowly pour it on your puppy. Keep talking to your puppy in a soft voice. \n \n" +
                "5) Once they are fully comfortable with all the steps above, give them a full bath and massage the soap into the puppy's fur, which will make the bath that more enjoyable for the puppy. ");

        list.add(handling);

        Lesson nailTrimming = new Lesson();

        nailTrimming.setTitle("Nail Trimming");
        nailTrimming.setDescription("25pts - Trimming your puppy's nails can be very difficult, especially when they start to grow. If properly trained, this task will not only be easier for you, it will be a lot less " +
                "stressful for your puppy. Introducing this to your puppy at a young age will make it easier for you to control them and it will make them more accepting of the process. \n \n" +
                "Make sure you have the proper tools: high-quality dog nail clippers and styptic powder. \n \n" +
                "Before trimming, look for the quick (vain). It is pretty easy to see the quick on puppies with white nails. " +
                "If you cut the quick, they will bleed and the only thing that will help you stop the bleeding is the styptic powder. \n \n" +
                "It is best to take your puppy to the vet or a groomer to get this done. Although, some people want to save a few bucks, so here is the steps to make it a comfortable process for both you and your puppy. \n \n");
        nailTrimming.setSteps("1) Handle your puppy's paws often before you ever clip their nails. Simply hold and rub their paws for a couple of training sessions before moving onto the next step. \n \n" +
                "2) Introduce your puppy to the clippers for one or two training sessions. Simply have the clippers closed and touch them to each of their nails." +
                "Do this with plenty of treats, this way the puppy will associate the clippers with treats. \n \n" +
                "3) Time to clip! Hold your puppy's paw firm enough so the cant pull away, but keep it gentle so they are not in pain. \n \n" +
                "4) Cut at a 45-degree angle, taking a small amount off at a time. Trim until you see the white insides of the nail with a small dot of black in the center. \n \n" +
                "5) Repeat step 3 and 4 for each nail. The more treats you give your puppy while trimming their nails, the more they will like the process. \n \n" +
                "^) Check and/or cut the dog's nails every three weeks. The more asphalt/cement your dog walks on, the less you will have to trim your dog's nails. ");

        list.add(nailTrimming);

        Lesson brushingTeeth = new Lesson();

        brushingTeeth.setTitle("Brushing Teeth");
        brushingTeeth.setDescription("25pts - Dog kisses are great, except when the dog's mouth is not cleaning. A clean mouth not only makes dog kisses better, it also gives them a healthy mouth and prevents expensive vet bills. " +
                "Training your puppy to let you brush their teeth at a young will make it an easier process when they are older. \n \n" +
                "Make sure to use the dog specific tooth paste and a soft brush. \n \n " +
                "The more teeth cleaning treats you use, such as Greenies or Bully Sticks, the less you will have to brush your dogs teeth. \n \n" +
                "Remember to take it slow and be reassuring. Use plenty of treats and mainly focus on the plaque. \n \n");
        brushingTeeth.setSteps("1) For the first couple of sessions, pull up the puppy's lips and touch their gums, this will allow them to get use to you touching their mouth. " +
                "Make sure to give them treats so the puppy will like you touching their mouth. \n \n" +
                "2) Find the right time. After your puppy gets some exercise will be the best time. \n \n" +
                "3) Get the gums ready by rubbing your finger across them. This will get your puppy ready for something to be touching their gums. \n \n" +
                "4) Let your dog lick the tooth past so they will see the taste as a treat. If your puppy refuses to lick the tooth paste, get a new flavor. \n \n" +
                "5) Now start brushing your puppy's teeth at a 45-degree angle and move in a circular motion while focusing on the plaque. \n \n" +
                "6) End on a positive note: give your puppy a treat and be playful. ");

        list.add(brushingTeeth);




        return list;
    }
}
