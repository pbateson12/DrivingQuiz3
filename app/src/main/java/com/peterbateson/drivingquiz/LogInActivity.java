package com.peterbateson.drivingquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LogInActivity extends AppCompatActivity {


    private Button mLogInButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        mLogInButton2 = (Button)findViewById(R.id.log_in_button2);
        mLogInButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent userProfile = new Intent(LogInActivity.this, WelcomeUserActivity.class);
                startActivity(userProfile);
            }

        });
    }


}
