package com.example.amaltheaapplication;

import java.util.List;

public class Patient {
     String FirstName;
     String LastName;
     String Email;
     String Password;
     String Role;

    //Constructor
    Patient() {

    }
    Patient(String fName , String lName, String eMail , String pAssword, String role) {
        FirstName = fName;
        LastName = lName;
        Email = eMail;
        Password = pAssword;
        Role = role;
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

    public String getRole() {
        return Role;
    }
    public void setRole() { this.Role = Role; }
    @Override
    public String toString() {
        return "User{"+
                "First Name: " +FirstName+ '\''+
                ", Last Name: " +LastName+
                ", Email: " +Email+
                "role : " +Role+
                '}';
    }
}
