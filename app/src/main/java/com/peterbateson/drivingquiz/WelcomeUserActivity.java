package com.peterbateson.drivingquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class WelcomeUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_user);
        String userString = getIntent().getStringExtra("Username");

        TextView welcomeUser = (TextView)findViewById(R.id.user_name2);
        welcomeUser.setText(userString);
    }

}
