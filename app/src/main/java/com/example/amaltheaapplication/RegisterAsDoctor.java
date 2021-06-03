package com.example.amaltheaapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class RegisterAsDoctor extends AppCompatActivity {
   //fdasfadsfasdfasdfasdfasdf
    TextView toLogin;
    EditText dFirstName , dLastName , dEmail, dPassword , dVerPassword;
    Button btnContinue;
    ProgressBar pgrBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_as_doctor);

        toLogin = findViewById(R.id.tvToLogin);
        dFirstName = findViewById(R.id.ptFirstName3);
        dLastName = findViewById(R.id.ptLastDoc);
        dEmail = findViewById(R.id.ptEmailDoc);
        dPassword = findViewById(R.id.ptPasswordDoc);
        dVerPassword = findViewById(R.id.ptVerPasswordDoc);
        btnContinue = findViewById(R.id.btnRegisterAsDoc);
        pgrBar = findViewById(R.id.progressBar2);

        btnContinue.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String FirstName = dFirstName.getText().toString().trim();
                String LastName = dLastName.getText().toString().trim();
                String Email = dEmail.getText().toString().trim();
                String Password = dPassword.getText().toString();
                String VerPassword = dVerPassword.getText().toString();


                if(TextUtils.isEmpty(FirstName)){
                    dFirstName.setError("First Name is required.");
                    return;
                }
                if(TextUtils.isEmpty(LastName)){
                    dLastName.setError("Last Name is required.");
                    return;
                }
                if(TextUtils.isEmpty(Email)){
                    dEmail.setError("Email is required.");
                    return;
                }
                if(TextUtils.isEmpty(Password)) {
                    dPassword.setError("Password is required.");
                }
                if(TextUtils.isEmpty(VerPassword)) {
                    dVerPassword.setError("Verification of Password required.");
                }


                Intent intent = new Intent(RegisterAsDoctor.this, RegisterAsDoctorStepTwo.class);
                intent.putExtra("KeyFirstName" , FirstName);
                intent.putExtra("KeyLastName" , LastName);
                intent.putExtra("KeyEmail" , Email);
                intent.putExtra("KeyPassword" , Password);


                pgrBar.setVisibility(View.VISIBLE);
                startActivity(intent);
            }
        });

        //redirect to Login by clicking the text below button.
        toLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterAsDoctor.this, Login.class);
                startActivity(intent);
            }
        });


    }

}