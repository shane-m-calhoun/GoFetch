package edu.western.cs.gofetch.model;

import java.io.Serializable;

import io.realm.annotations.PrimaryKey;

/**
 * Created by shanecalhoun on 4/2/18.
 */

public class Lesson{

    String level;
    String title;
    String description;
    String steps;


    public String getLevel(){
        return level;
    }
    public void setLevel(String level){
        this.level = level;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }

    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    public String getSteps(){
        return steps;
    }
    public void setSteps(String steps){
        this.steps = steps;
    }

}
