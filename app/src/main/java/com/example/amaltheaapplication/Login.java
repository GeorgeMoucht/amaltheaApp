package com.example.amaltheaapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;

public class Login extends AppCompatActivity {

    TextView textView ;
    Button btnLogin;
    EditText ptEmail , ptPassword;
    ProgressBar pgrBar;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        btnLogin = findViewById(R.id.btnToContinue);
        ptEmail = findViewById(R.id.ptEmail);
        ptPassword = findViewById(R.id.ptPassword);
        textView = findViewById(R.id.tvToRegister);
        pgrBar = findViewById(R.id.prgBarLog);

        fAuth = FirebaseAuth.getInstance();

        //when user click the Login button.
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = ptEmail.getText().toString().trim();
                String password = ptPassword.getText().toString().trim();


                if(TextUtils.isEmpty(email)){
                    ptEmail.setError("Email is required.");
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    ptPassword.setError("Password is required.");
                    return;
                }
                if (!isValid(email)) {
                    ptEmail.setError("Incorrect Email.");
                    return;
                }
                if(password.length() <= 6) {
                    ptPassword.setError("The length of password must be at least 6 characters");
                    return;
                }






                //firebase authentication and login system.
                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(Login.this,  "Successful Logged in.", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent (getApplicationContext(),Home.class));
                        }else{
                            Toast.makeText(Login.this,  "Error !." +task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });


        //redirect to Sign up by clicking the text below button.
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, RegisterStepOne.class);
                startActivity(intent);
            }

        });



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