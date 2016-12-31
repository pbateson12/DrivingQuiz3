package com.peterbateson.drivingquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    private Button mSignUpButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        mSignUpButton2 = (Button)findViewById(R.id.sign_up_button2);
        mSignUpButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent BackToWelcome = new Intent(SignUpActivity.this, WelcomeActivity.class);
                startActivity(BackToWelcome);
            }
        });
    }

    public void onSignUpClick(View v)
    {
        if(v.getId() == R.id.sign_up_button2) {
            EditText username = (EditText) findViewById(R.id.user_name);
            EditText email = (EditText) findViewById(R.id.user_email);
            EditText password = (EditText) findViewById(R.id.user_password);
            EditText password2 = (EditText) findViewById(R.id.user_password2);

            String usernameString = username.getText().toString();
            String emailString = email.getText().toString();
            String passwordString = password.getText().toString();
            String password2String = password2.getText().toString();

            if(passwordString != password2String)
            {
                Toast passwordsDoNotMatch = Toast.makeText(SignUpActivity.this, "Passwords do not match!", Toast.LENGTH_SHORT);
                passwordsDoNotMatch.show();
            }
        }


    }

}
