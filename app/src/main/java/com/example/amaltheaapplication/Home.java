package com.example.amaltheaapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class Home extends AppCompatActivity {


    LinearLayout Linear_Profile , Linear_Results, Linear_Questions , Linear_Nutritionsist , Linear_Map , Linear_Translate;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Initialize Menu variables.
        Linear_Profile = findViewById(R.id.profileMenu);
        Linear_Results = findViewById(R.id.parentResultsMenu);
        Linear_Questions = findViewById(R.id.questionsMenu);
        Linear_Nutritionsist = findViewById(R.id.nutritionistMenu);
        Linear_Map = findViewById(R.id.mapMenu);
        Linear_Translate = findViewById(R.id.translateMenu);


        //Make Linear xml clickable like buttons.

        Linear_Profile.setClickable(true);
        Linear_Results.setClickable(true);
        Linear_Questions.setClickable(true);
        Linear_Nutritionsist.setClickable(true);
        Linear_Map.setClickable(true);
        Linear_Translate.setClickable(true);

        //onClick Events

        Linear_Profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Home.this, RegisterStepOne.class);
                startActivity(intent);


            }
        });



    }







    /*  ~~~~We will put it in profileMenu activity ~~~~~~~~~~~~~~~~
    public void logout(View view) {
        FirebaseAuth.getInstance().signOut(); //logout
        startActivity(new Intent(getApplicationContext(), Login.class));
        finish();
    }
    */

}