package com.example.amaltheaapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.FirestoreRegistrar;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class Profile extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<User> userArrayList;
    MyAdapter myAdapter;
    FirebaseFirestore db;


    FirebaseAuth fAuth;
    Button btnLogOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //Initilize all we need to process data in db, and print them.
        recyclerView = findViewById(R.id.profileRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        db = FirebaseFirestore.getInstance();
        userArrayList = new ArrayList<User>();
        myAdapter = new MyAdapter(Profile.this,userArrayList);

        //Reatrive the data from db now.
        EventChangeListener();

        //Log-out the user.
        fAuth = FirebaseAuth.getInstance();
        btnLogOut = findViewById(R.id.LogOutBtn);



    }
    //log out function.
    public void logout(View view) {
        FirebaseAuth.getInstance().signOut(); //logout
        startActivity(new Intent(getApplicationContext(), Login.class));
        finish();
    }

    private void EventChangeListener() {
        db.collection("users").orderBy("firstName", Query.Direction.ASCENDING)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                        //https://www.youtube.com/watch?v=Az4gXQAP-a4
                        //https://www.youtube.com/watch?v=Az4gXQAP-a4
                        //https://www.youtube.com/watch?v=Az4gXQAP-a4
                        //https://www.youtube.com/watch?v=Az4gXQAP-a4
                        //https://www.youtube.com/watch?v=Az4gXQAP-a4
                        //https://www.youtube.com/watch?v=Az4gXQAP-a4
                        //https://www.youtube.com/watch?v=Az4gXQAP-a4
                        //https://www.youtube.com/watch?v=Az4gXQAP-a4
                        //https://www.youtube.com/watch?v=Az4gXQAP-a4
                    }
                });

    }

}