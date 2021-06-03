package com.example.amaltheaapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static android.content.ContentValues.TAG;

public class RegisterAsDoctorStepTwo extends AppCompatActivity {

    ArrayList<String> numberlist = new ArrayList<>();

    EditText mAFM, mAMKA, mPersonalid;
    Button mRegisterDocBtn;
    ProgressBar progressBar;
    String mFirstName, mLastName, mEmail, mPassword, userID;
    public FirebaseAuth fAuth = FirebaseAuth.getInstance();
    public FirebaseFirestore fStore = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_as_doctor_step_two);



        mAFM = findViewById(R.id.ptAFM);
        mAMKA = findViewById(R.id.ptAMKA);
        mPersonalid = findViewById(R.id.ptPersonalid);
        mRegisterDocBtn = findViewById(R.id.btnRegisterAsDoc2);
        progressBar = findViewById(R.id.progressBar3);

        //retrive the data from RegisterStepOne.class
        mFirstName = getIntent().getStringExtra("KeyFirstName");
        mLastName = getIntent().getStringExtra("KeyLastName");
        mEmail = getIntent().getStringExtra("KeyEmail");
        mPassword = getIntent().getStringExtra("KeyPassword");

        mRegisterDocBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String AFM = mAFM.getText().toString();
                String AMKA = mAMKA.getText().toString();
                String Personalid = mPersonalid.getText().toString();
                String Email = mEmail;
                String FirstName = mFirstName;
                String LastName = mLastName;
                String Password = mPassword;

                if (TextUtils.isEmpty(AFM)) {
                    mAFM.setError("AFM is required");
                    return;
                }
                if (TextUtils.isEmpty(AMKA)) {
                    mAMKA.setError("AMKA is required");
                    return;
                }
                if (TextUtils.isEmpty(Personalid)) {
                    mPersonalid.setError("Personal ID is required");
                    return;
                }





            }
        });

    }





}