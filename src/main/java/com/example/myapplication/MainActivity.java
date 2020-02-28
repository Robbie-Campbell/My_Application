package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button second_activity = (Button) findViewById(R.id.newPage);
        second_activity.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), SecondActivity.class);
                startIntent.putExtra("com.example.myapplication.SOMETHING", "Hello world!");
                startActivity(startIntent);
            }
        });
        // Launch an activity outside of our app
        Button googleButton = (Button) findViewById(R.id.googleButton);
        googleButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String google = "http://www.google.com";
                Uri webAddress = Uri.parse((google));

                Intent goToGoogle = new Intent(Intent.ACTION_VIEW, webAddress);
                if (goToGoogle.resolveActivity(getPackageManager()) != null) {
                    startActivity(goToGoogle);
                }
            }
        });
    }
}