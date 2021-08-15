package com.example.amaltheaapplication;

import com.google.firebase.firestore.Exclude;

import java.util.List;

public class Capsule_Results {
    private String userID;
    private String capsuleID;
    List<String> resultsOfCapsule;

    public Capsule_Results() {
        //Empty const no args needed.
    }

    //Constructor with all args inside.
    public Capsule_Results(String userID , String capsuleID , List<String> resultsOfCapsule) {
        this.userID = userID;
        this.capsuleID = capsuleID;
        this.resultsOfCapsule = resultsOfCapsule;
    }

    @Exclude
    public String getUserID(){
        return userID;
    }
    public void setUserID(){
        this.userID = userID;
    }
    public String getCapsuleID(){
        return capsuleID;
    }
    public void setCapsuleID(){
        this.capsuleID = capsuleID;
    }
    public List<String> getResultsOfCapsule(){
        return resultsOfCapsule;
    }

}
