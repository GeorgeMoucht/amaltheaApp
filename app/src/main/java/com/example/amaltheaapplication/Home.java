package com.example.amaltheaapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void logout(View view) {
        FirebaseAuth.getInstance().signOut(); //logout
        startActivity(new Intent(getApplicationContext(), Login.class));
        finish();
    }
}