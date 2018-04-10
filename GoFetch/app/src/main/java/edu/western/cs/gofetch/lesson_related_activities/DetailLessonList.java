package edu.western.cs.gofetch.lesson_related_activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import edu.western.cs.gofetch.Help;
import edu.western.cs.gofetch.R;
import edu.western.cs.gofetch.adapter.CustomAdapterL;
import edu.western.cs.gofetch.dog_related_activities.DogProfile;
import edu.western.cs.gofetch.model.Lesson;

public class DetailLessonList extends AppCompatActivity {
    private ArrayList<Lesson> mLessonList;
    private String level;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_lesson_list);


        Intent intent = getIntent();
        level = intent.getStringExtra("level");

        switch (level){
            case "0":
                mLessonList = puppyLessons();
                break;
            case "1":
                mLessonList = beginnerLessons();
                break;
            case "2":
                mLessonList = intermediateLessons();
                break;
            case "3":
                mLessonList = advancedLessons();
                break;
            default:
                break;

        }


        ListView listView = findViewById(R.id.detail_lesson_list);

        CustomAdapterL listAdapter = new CustomAdapterL(DetailLessonList.this, R.layout.lesson_list, mLessonList);
        listView.setAdapter(listAdapter);
//        TextView listItem = findViewById(R.id.lesson_title);
//
//        switch (level){
//            case "0":
//                listItem.setBackgroundColor(getResources().getColor(R.color.Green));
//                break;
//            case "1":
//                listItem.setBackgroundColor(getResources().getColor(R.color.Yellow));
//                break;
//            case "2":
//                listItem.setBackgroundColor(getResources().getColor(R.color.Orange));
//            case "3":
//                listItem.setBackgroundColor(getResources().getColor(R.color.Red));
//                break;
//            default:
//                break;
//
//        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(DetailLessonList.this, StartLesson.class);

                intent.putExtra("title", mLessonList.get(i).getTitle());
                intent.putExtra("description", mLessonList.get(i).getDescription());
                intent.putExtra("steps", mLessonList.get(i).getSteps());
                intent.putExtra("level", level);

                startActivity(intent);
            }
        });

    }//OnCreate

    public ArrayList<Lesson> puppyLessons(){
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

    public ArrayList<Lesson> beginnerLessons(){
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

    public ArrayList<Lesson> intermediateLessons(){
        ArrayList<Lesson> list = new ArrayList<>();

        Lesson test = new Lesson();

        test.setTitle("Rollover Training");
        test.setDescription("This is just a test");
        test.setSteps("1) test \n" +
                "2) test");
        list.add(test);

        return list;
    }

    public ArrayList<Lesson> advancedLessons(){
        ArrayList<Lesson> list = new ArrayList<>();

        Lesson test = new Lesson();

        test.setTitle("Off-Leash Training");
        test.setDescription("This is just a test");
        test.setSteps("1) test \n" +
                "2) test");
        list.add(test);

        return list;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.help_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }//OnCreateOptionsMenu

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.help_icon:
                Intent intent = new Intent(DetailLessonList.this, Help.class);
                startActivity(intent);
                return true;
            case R.id.home_icon:
                Intent intent1 = new Intent(DetailLessonList.this, DogProfile.class);
                startActivity(intent1);
            default:
                return super.onOptionsItemSelected(item);
        }//switch statement
    }//OnOptionsItemSelected
}//PuppyLessonList