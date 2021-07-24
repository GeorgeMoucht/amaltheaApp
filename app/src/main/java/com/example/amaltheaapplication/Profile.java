package com.example.amaltheaapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.FirestoreRegistrar;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class Profile extends AppCompatActivity {

    Button btnLogOut;
    TextView dFirstName, dLastName, dEmail;

    FirebaseFirestore db;
    FirebaseAuth fAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        dFirstName= findViewById(R.id.tvFirstNamep);
        dLastName = findViewById(R.id.tvLastNamep);
        dEmail = findViewById(R.id.tvEmailp);

        btnLogOut = findViewById(R.id.LogOutBtn);

        db = FirebaseFirestore.getInstance();

        //Append TextViews with logged in user data.
        fetchdata();



    }

    //This is the function that Query Select Profile data of logged in user.    ~ yt: Firestore Query | Firestore LIKE query | MD-Jamal~
    public void fetchdata() {

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if(user != null) {
            String ma = user.getEmail();
        }

        db.collection("users")
                .whereEqualTo("email",user.getEmail())
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        for(QueryDocumentSnapshot document : queryDocumentSnapshots) {
                            //Care! All fields my be exactly the same with db fields.
                            dFirstName.append(" "+document.getString("firstName"));
                            dLastName.append(""+document.getString("lastName"));
                            dEmail.append(""+document.getString("email"));
                        }
                    }
                });
    }
    //log out function.
    public void logout(View view) {
        FirebaseAuth.getInstance().signOut(); //logout
        startActivity(new Intent(getApplicationContext(), Login.class));
        finish();
    }





}