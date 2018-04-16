package edu.western.cs.gofetch.createLessons;

import java.util.ArrayList;

import edu.western.cs.gofetch.model.Lesson;

/**
 * Created by shanecalhoun on 4/11/18.
 */

public class Intermediate {
    public static ArrayList<Lesson> intermediateLessons(){
        ArrayList<Lesson> list = new ArrayList<>();


        Lesson leaveIt = new Lesson();

        leaveIt.setTitle("Leave It");
        leaveIt.setDescription("Teaching your do to leave something has many benefits. Not only can it help your dog in learning fetch (next lesson), it could also save your dogs life! \n \n" +
                "For teaching your dog to leave things, you will need a boring treats and some very tasty treats. \n \n ");
        leaveIt.setSteps("1) Put the boring treats in one hand and make a fist, make sure to have the tasty treats in an accessible place. Your dog will try licking and/or pawing at your fist put don't let the dog get the treat. " +
                "As soon as your dog stops, tell the dog \"good leave it,\" press the clicker and give the dog one of the tasty treats. \n Repeat this a few times until the dog stops trying to go for the treat in the closed fist. \n \n" +
                "2) Now repeat step one, but this time, when your dog stops, open the fist and tell the dog \"leave it.\" After a couple of seconds, praise the dog, press the clicker and reward the dog with the tasty treat. " +
                "Repeat this step multiple times, while progressing in the amount of time before the reward\n \n " +
                "3) Now do this again but on the floor. Set the boring treat on the floor, tell the dog to leave it, and reward with the tasty treat. \n \n" +
                "4) Finally, put your dog on a leash and do the leave-it command when you throw a treat. Remember to still give the dog a treat from a different location. " +
                "Also, to ensure the dog knows leave it well, do this step with treats and toys. " +
                "");
        list.add(leaveIt);


        Lesson fetch = new Lesson();

        fetch.setTitle("Rollover");
        fetch.setDescription("Fetch is a great way to get your dog some exercise. Fetch can also improve your dog's ability to stay when there are distractions. " +
                "Teaching your dog to stay when you throw a toy will make it much easier for your dog to learn to walk off-leash while there are plenty of distractions. \n \n ");
        fetch.setSteps("1) Find a toy that your dog loves. \n \n" +
                "2) First, you need to teach your dog to chase the toy. Shake the toy around to get the dogs attention. Once the dog goes to grab the toy from you, throw the toy a couple of feet and say \"fetch\". " +
                "When the dog grabs the toy, press your clicker and reward the dog with a treat. Repeat this step a few time while progressing in the distance that you throw the toy. \n \n" +
                "3) Now it is time to add extra motivation. When you throw the toy, hold back your dog for a couple of seconds while telling them to wait. Then let go of your dog and tell them to go fetch. " +
                "Once again, when your dog gets the toy, press the clicker and reward the dog with a treat. Now repeat this step multiple times. \n \n " +
                "4) Now let's get your dog to bring the toy back. Put a leash on your dog (10-15 feet long). Throw the toy, tell your dog to go fetch and once the grab the toy tell your dog to bring it back. " +
                "If needed, give a light tug on the leash to motivate the dog to come back to you. Once the dog brings the toy back, press the clicker and reward the dog with a treat. " +
                "If your dog fails to bring it back, don't scold the dog, rather go get the toy while not pressing the clicker and not giving a treat. Now keep repeating until your dog gets the hang of bringing the toy back to you. \n \n" +
                "5) Finally, teach your dog to drop the toy. When your dog brings the toy back, show the dog a treat and tell them to leave it. Once the dog drop the toy, press the clicker and reward them with a treat. Repeat this step multiple times. \n \n" +
                "6) Keep having fun with your dog and give them daily exercise with a 15 minute session of fetch. Slowly use the clicker and treats less. Fetch will be a great way to tire your dog out before you teach your dog new lessons. ");
        list.add(fetch);


        Lesson playDead = new Lesson();

        playDead.setTitle("Play Dead");
        playDead.setDescription("This is a fun and cute trick that you can teach your dog. Other than being cute, the more tricks that your dog knows, the better the will be at listening. " +
                "Also, teaching your dog fun tricks will challenge their brain, making it easier to teach the more advanced lessons. \n \n ");
        playDead.setSteps("1) Get your dog into the lay down position. \n \n" +
                "2) Kneel down in front of your dog. \n \n " +
                "3) Hold the treat next to the dog's head and move it back towards the shoulder. \n \n " +
                "4) At this the point the dog should fall to it's side and tell the dog \"play dead,\" press the clicker and reward the dog with a treat. \n \n " +
                "5) Repeat this multiple times until the dog is able to play dead without being guided by a treat. \n \n" +
                "6) Do an entire training session with the dog playing dead without being guided by a treat. Start using less treats and move to only praising the dog.");
        list.add(playDead);


        Lesson rollover = new Lesson();

        rollover.setTitle("Roll Over");
        rollover.setDescription("This is a fun and cute trick that you can teach your dog. Other than being cute, the more tricks that your dog knows, the better the will be at listening. " +
                "Also, teaching your dog fun tricks will challenge their brain, making it easier to teach the more advanced lessons. \n \n ");
        rollover.setSteps("1) Get your dog into the lay down position. \n \n" +
                "2) Kneel down next to your dog and hold a treat to the side of their head. The dog will most likely lay on their side, if not, move the treat back towards their shoulder. \n \n " +
                "3) Move the treat back and over the dogs head. This will cause the dog to roll over. \n \n" +
                "4) Tell the dog \"roll over,\" press your clicker and reward the dog with the treat. \n \n " +
                "5) Repeat this multiple times until the dog is able to roll over without being guided by a treat. \n \n" +
                "6) Do an entire training session with the dog rolling over without being guided by a treat. Start using less treats and move to only praising the dog. ");
        list.add(rollover);


        Lesson spin = new Lesson();

        spin.setTitle("Spin");
        spin.setDescription("This trick your dog will love! Spinning is a fun and cute trick that you can teach your dog. Other than being cute, this trick helps stretch your dog out, which helps with preventing injuries. " +
                "Also, teaching your dog fun tricks will challenge their brain, making it easier to teach the more advanced lessons.\n \n");
        spin.setSteps("1) Put a treat in front of your dog's nose. \n \n" +
                "2) Move the treat in the direction you want the dog to spin \n \n " +
                "3) Once the dog makes it all the way around, say \"spin,\" press your clicker and reward the dog with the treat. \n \n" +
                "4) Repeat this multiple times until the dog is able to spin without being guided by a treat. \n \n" +
                "5) Do an entire training session with the dog spinning without being guided by a treat. Start using less treats and move to only praising the dog.");
        list.add(spin);

        return list;
    }
}
