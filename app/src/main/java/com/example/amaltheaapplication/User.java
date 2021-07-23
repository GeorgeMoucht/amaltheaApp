package com.example.amaltheaapplication;

import java.util.List;

public class User {
     String firstName;
     String lastName;
     String email;
     String password;
     String role;

     /*CRPYPTO https://cloud.google.com/firestore/docs/server-side-encryption */

    //Constructor
    User() {

    }
    User(String fName , String lName, String eMail , String pAssword, String role) {
        firstName = fName;
        lastName = lName;
        email = eMail;
        password = pAssword;
        role = role;
    }
    //Xriazomaste kai enan constructor me Ta stoixeia p theloyme otan dimioyrgoyme user.

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName() {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName() {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail() {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword() {
        this.password = password;
    }

    public String getRole() {
        return role;
    }
    public void setRole() { this.role = role; }
    @Override
    public String toString() {
        return "User{"+
                "First Name: " +firstName+ '\''+
                ", Last Name: " +lastName+
                ", Email: " +email+
                "role : " +role+
                '}';
    }
}
