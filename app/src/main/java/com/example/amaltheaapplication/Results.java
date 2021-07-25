package com.example.amaltheaapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Results extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
    }





    //Redirect in activity_import_results.xml
    public void redirectToImportResults(View view) {
        startActivity(new Intent(getApplicationContext(), importResults.class));
        finish();
    }
    //Redirect in activity_import_results.xml
    public void redirectToSearchResults(View view) {
        startActivity(new Intent(getApplicationContext(), SearchResults.class));
        finish();
    }
}