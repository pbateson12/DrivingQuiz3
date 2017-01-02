package com.peterbateson.drivingquiz;

import android.widget.Button;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;


public class LogInActivity extends AppCompatActivity
{

    private Button LogInButton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        LogInButton1 = (Button)findViewById(R.id.log_in_button1);
        LogInButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent userProfile = new Intent(LogInActivity.this, WelcomeUserActivity.class);
                startActivity(userProfile);
            }
        });
    }}

