package com.example.amaltheaapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Arrays;
import java.util.List;

public class SearchResults extends AppCompatActivity {


    FirebaseFirestore db;
    FirebaseAuth fAuth;
    TextView mMessageWindow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);


        mMessageWindow = findViewById(R.id.tvEmailp);

        //Test for ScrollView.
        /*
        StringBuilder stringBuilder = new StringBuilder();

        String someMessage = " This is some test message that I write for my ScrollView. ";

        for(int i = 0; i < 100; i++) {
            stringBuilder.append(someMessage);
        }
        mMessageWindow.setText(stringBuilder.toString());
        */



        db = FirebaseFirestore.getInstance();
        //Append TextViews with logged in user data.
        fetchdataC();


    }



    //This is the function that Query Select Profile data of logged in user.    ~ yt: Firestore Query | Firestore LIKE query | MD-Jamal~
    public void fetchdataC() {

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if(user != null) {
            String ma = user.getEmail();
        }

        db.collection("results")
                .whereEqualTo("email",user.getEmail())
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        for(QueryDocumentSnapshot document : queryDocumentSnapshots) {
                            //Care! All fields must be exactly the same with db fields.
                            //Otherwise Querry will not work.

                            mMessageWindow.append("  "+document.getString("capsuleID"));
                        }
                    }
                });
    }
}