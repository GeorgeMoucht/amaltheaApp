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
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import static android.content.ContentValues.TAG;

public class RegisterStepOne extends AppCompatActivity {
    EditText mEmail , mPassword , mVerPassword, mFirstName , mLastName;
    Button mRegisterToStepTwo;
    TextView mTextToLogin , tvToDoc;
    FirebaseAuth fAuth;
    FirebaseFirestore  fStore;
    ProgressBar progressBar;
    String userID;
    String role = "patient";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_step_one);

        //Hooks to all XML objects.
        mFirstName = findViewById(R.id.ptFirstName2);
        mLastName = findViewById(R.id.ptLastName2);
        mEmail = findViewById(R.id.ptEmail);
        mPassword = findViewById(R.id.ptPassword);
        mVerPassword = findViewById(R.id.ptVerPassword);
        mRegisterToStepTwo = findViewById(R.id.btnToContinue);
        mTextToLogin = findViewById(R.id.tvToRegister);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        progressBar = findViewById(R.id.progressBar);
        tvToDoc = findViewById(R.id.tvToDoctorRegister);

        //if the user is logged in redirect him in Activity_Home, without login/sign up.
        /*if(fAuth.getCurrentUser() != null) {
            startActivity(new Intent (getApplicationContext(),Home.class));
            finish();
        }*/

        mRegisterToStepTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();
                String verPassword = mVerPassword.getText().toString().trim();
                String firstName = mFirstName.getText().toString().trim();
                String lastName = mLastName.getText().toString().trim();
                String rOle = role;


                if(TextUtils.isEmpty(firstName)){
                    mFirstName.setError("First Name is required.");
                    return;
                }
                if(TextUtils.isEmpty(lastName)){
                    mFirstName.setError("Last Name is required.");
                    return;
                }
                if(TextUtils.isEmpty(email)){
                    mEmail.setError("Email is required.");
                    return;
                }
                if (!isValid(email)) {
                    mEmail.setError("Incorrect Email.");
                    return;
                }
                if(TextUtils.isEmpty(password)) {
                    mPassword.setError("Password is required.");
                    return;
                }
                if(TextUtils.isEmpty(verPassword)) {
                    mPassword.setError("Password is required.");
                    return;
                }
                if(isAlpha(firstName) == false) {
                    mFirstName.setError("First Name can't be numeric.");
                    return;
                }
                if(isAlpha(lastName) == false) {
                    mLastName.setError("Last Name can't be numeric.");
                    return;
                }
                if(password.length() <= 6) {
                    mPassword.setError("The length of password must be at least 6 characters");
                    return;
                }
                if(!(password.equals(verPassword))) {
                    mVerPassword.setError("Incorrect Password.");
                    return;
                }


                progressBar.setVisibility(View.VISIBLE);


                //register the user in the firebase.
                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                      if(task.isSuccessful()) {
                          Toast.makeText(RegisterStepOne.this,  "User Created.", Toast.LENGTH_SHORT).show();

                          //Initialize user ID from Auth
                          userID = fAuth.getCurrentUser().getUid();

                          Map<String,Object> user = new HashMap<>();
                          user.put("firstName",firstName);
                          user.put("lastName",lastName);
                          user.put("email",email);
                          user.put("password",password);
                          user.put("role",rOle);
                          user.put("AuthUserID", userID);

                          fStore.collection("users")
                                  .add(user)
                                  .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                      @Override
                                      public void onSuccess(DocumentReference documentReference) {
                                          Toast.makeText(RegisterStepOne.this,"Sucessfull register in cloud",Toast.LENGTH_SHORT).show();

                                      }
                                  }).addOnFailureListener(new OnFailureListener() {
                              @Override
                              public void onFailure(@NonNull Exception e) {
                                  Toast.makeText(RegisterStepOne.this,"Failed register in cloud",Toast.LENGTH_SHORT).show();

                              }
                          });

                          startActivity(new Intent (getApplicationContext(),Home.class));
                      }else {
                          Toast.makeText(RegisterStepOne.this,  "Error in Sign Up." +task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                      }
                    }
                });

            }


        });

        //Text redirect, back to login page.
        mTextToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterStepOne.this, Login.class);
                startActivity(intent);
            }
        });



        //redirect to RegisterAsDoctor class.
        tvToDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterStepOne.this, RegisterAsDoctor.class);
                startActivity(intent);
            }
        });

    }
    //Test if it's alpha.
    public boolean isAlpha(String name) {
        char[] chars = name.toCharArray();

        for (char c : chars) {
            if(!Character.isLetter(c)) {
                return false;
            }
        }

        return true;
    }
    //test if it is an Email.
    private static boolean isValid(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null){
            return false;
        }
        return pat.matcher(email).matches();
    }



}