package edu.western.cs.gofetch.model;

import java.io.Serializable;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by honginpark on 1/29/18.
 */

public class Dog extends RealmObject implements Serializable{

    @PrimaryKey
    private String id;
    private String first_name;
    private String breed;
    private String weight;
    private String email;
    private String age;
    private Double points;

    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }


    public void setBreed(String breed){
        this.breed = breed;
    }
    public String getBreed(){
        return breed;
    }


    public void setWeight(String weight){
        this.weight = weight;
    }
    public String getWeight(){
        return weight;
    }


    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }


    public void setAge(String age){
        this.age = age;
    }
    public String getAge(){
        return age;
    }


    public void setPoints(double points){
        this.points = points;
    }
    public double getPoints(){
        return points;
    }



}//End of Contact Class
