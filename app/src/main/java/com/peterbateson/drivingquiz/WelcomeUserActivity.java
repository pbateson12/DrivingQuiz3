package com.peterbateson.drivingquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

public class WelcomeUserActivity extends AppCompatActivity {

    private Button mStartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_user);

        String username = getIntent().getStringExtra("Username");
        TextView welcomeUsername = (TextView)findViewById(R.id.welcomeUsername);
        welcomeUsername.setText(username);

        mStartButton =(Button)findViewById(R.id.start_button);
        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Start = new Intent(WelcomeUserActivity.this, QuizActivity.class);
                startActivity(Start);
            }
        });

    }

}
