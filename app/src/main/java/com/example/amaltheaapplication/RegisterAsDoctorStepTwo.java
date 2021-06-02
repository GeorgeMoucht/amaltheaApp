package com.example.amaltheaapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class RegisterAsDoctorStepTwo extends AppCompatActivity {

    ArrayList<String> numberlist = new ArrayList<>();

    EditText mAFM, mAMKA, mPersonalid;
    Button mRegisterDocBtn;
    ProgressBar progressBar;
    String mFirstName, mLastName, mEmail, mPassword, userID;
    FirebaseAuth fAuth = FirebaseAuth.getInstance();
    FirebaseFirestore fStore = FirebaseFirestore.getInstance();

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

    //Get json bada.
    public void get_json() {
        String json;

        try
        {
            InputStream is = getAssets().open("GovDoctorDB.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read();
            is.close();

            json = new String(buffer, "UTF-8");
            JSONArray jsonArray = new JSONArray(json);

            for(int i = 0; i<jsonArray.length();i++) {
                JSONObject obj = jsonArray.getJSONObject(i);

                //isws mia sinartish poy na kanei to registration???

            }


        }catch (IOException e)
        {
            e.printStackTrace();
        }catch (JSONException e)
        {
            e.printStackTrace();
        }

    }

}