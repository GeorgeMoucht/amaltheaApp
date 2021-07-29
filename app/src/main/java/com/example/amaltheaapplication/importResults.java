package com.example.amaltheaapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class importResults extends AppCompatActivity {

    EditText tv;
    Button btnImportCapResData;
    FirebaseFirestore fStore;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_import_results);

        tv = findViewById(R.id.etCapsuleId);
        btnImportCapResData = findViewById(R.id.btnCommitCapResultsToDB);

        //Retrieve the data from EditText.
        String capsuleId = tv.getText().toString();


        //When user click the Import Btn, all this happens.
        btnImportCapResData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImportNewCapResults(capsuleId);                                      //Import new Result to db.
            }
        });

    }


    //The function that interact with db to create our new Users Results.
    public void ImportNewCapResults(String capsuleId) {

        fAuth = FirebaseAuth.getInstance();

        String userId = fAuth.getCurrentUser().getUid();

        Map<String,Object> results = new HashMap<>();
        results.put("AuthUserID", userId);
        results.put("CapsuleID", capsuleId);
        //We need somehow to put the List of results here. ===========================================================================================================
        ArrayListOfResults();
        fStore.collection("results")
                .add(results)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(importResults.this,"Sucessfull register in cloud",Toast.LENGTH_SHORT).show();

                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(importResults.this,"Failed register in cloud",Toast.LENGTH_SHORT).show();

            }
        });


    }
    //Because we didn't manage to make the capsule software,
    //the ArrayList that we put in db is created as example
    //to be able to test and continue the application.
    //In next versions of project we are planning to re-create this function
    //to real interact with the capsule.
    public void ArrayListOfResults() {
        
    }
}