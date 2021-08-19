package com.example.amaltheaapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class SearchResults extends AppCompatActivity {

    FirebaseFirestore db;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        TextView mTitleWindow = (TextView) findViewById(R.id.titleWindow);
        TextView mMessageWindow = (TextView) findViewById(R.id.messageWindow);


        fetchCapsuleData(mMessageWindow);
        //Test for ScrollView.
        /*
        StringBuilder stringBuilder = new StringBuilder();

        String someMessage = " This is some test message that I write for my ScrollView. ";

        for(int i = 0; i < 100; i++) {
            stringBuilder.append(someMessage);
        }
        mMessageWindow.setText(stringBuilder.toString());
        */


    }
    public void fetchCapsuleData(TextView MessageWindow){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String userID;


        if( user != null) {
            String ma = user.getEmail();
        }

        //Initialize user ID from Auth
        userID = fAuth.getCurrentUser().getUid();
        db = FirebaseFirestore.getInstance();


        db.collection("")

    }
}