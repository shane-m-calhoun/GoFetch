package edu.western.cs.gofetch.Dog;

/**
 * Created by honginpark on 1/29/18.
 */

public class Dog {

    //your contact model class
    private String first_name;
    private String breed;
    private int weight;
    private String email;
    private int age;
    private int points;

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
    public void setWeight(int weight){
        this.weight = weight;
    }
    public int getWeight(){
        return weight;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return age;
    }
    public void setPoints(int points){
        this.points = points;
    }
    public int getPoints(){
        return points;
    }



}//End of Contact Class
