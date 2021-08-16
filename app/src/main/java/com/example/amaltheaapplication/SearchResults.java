package com.example.amaltheaapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SearchResults extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        TextView mTitleWindow = (TextView) findViewById(R.id.titleWindow);
        TextView mMessageWindow = (TextView) findViewById(R.id.messageWindow);

        StringBuilder stringBuilder = new StringBuilder();

        String someMessage = " This is some test message that I write for my ScrollView. ";

        for(int i = 0; i < 100; i++) {
            stringBuilder.append(someMessage);
        }
        mMessageWindow.setText(stringBuilder.toString());

    }
}