package edu.western.cs.gofetch.model;

import java.io.Serializable;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by shanecalhoun on 4/12/18.
 */

public class History extends RealmObject implements Serializable {

        @PrimaryKey
        private String id;
        private String dogId;
        private String lessonTitle;
        private String lessonLevel;
        private String performanceLevel;
        private String sessionNotes;

        public String getId(){
            return id;
        }
        public void setId(String id){
            this.id = id;
        }

        public String getDogId(){
            return dogId;
        }
        public void setDogId(String dogId){
            this.dogId = dogId;
        }

        public String getLessonTitle(){
            return lessonTitle;
        }
        public void setLessonTitle(String lessonTitle){
            this.lessonTitle = lessonTitle;
        }

        public String getLessonLevel(){
            return lessonLevel;
        }
        public void setLessonLevel(String lessonLevel){
            this.lessonLevel = lessonLevel;
        }

        public String getPerformanceLevel(){
            return performanceLevel;
        }
        public void setPerformanceLevel(String performanceLevel){
            this.performanceLevel = performanceLevel;
        }

        public String getSessionNotes(){
            return sessionNotes;
        }
        public void setSessionNotes(String sessionNotes){
            this.sessionNotes = sessionNotes;
        }
}
