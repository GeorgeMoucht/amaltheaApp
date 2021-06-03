package com.example.amaltheaapplication;

import java.util.List;

public class Patient {
     String FirstName;
     String LastName;
     String Email;
     String Password;

    //Constructor
    Patient() {

    }
    Patient(String fName , String lName, String eMail , String pAssword) {
        FirstName = fName;
        LastName = lName;
        Email = eMail;
        Password = pAssword;
    }
    //Xriazomaste kai enan constructor me Ta stoixeia p theloyme otan dimioyrgoyme user.

    public String getFirstName() {
        return FirstName;
    }
    public void setFirstName() {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }
    public void setLastName() {
        this.LastName = LastName;
    }

    public String getEmail() {
        return Email;
    }
    public void setEmail() {
        this.Email = Email;
    }

    public String getPassword() {
        return Password;
    }
    public void setPassword() {
        this.Password = Password;
    }

    @Override
    public String toString() {
        return "User{"+
                "First Name: " +FirstName+ '\''+
                ", Last Name: " +LastName+
                ", Email: " +Email+
                '}';
    }
}
