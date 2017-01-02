package com.peterbateson.drivingquiz;

import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class SignUpActivity extends AppCompatActivity
{

    Button SignUpButton;
    EditText enterUsername;
    EditText enterPassword;

    DatabaseHelperLogIn databaseHelperLogIn;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        databaseHelperLogIn = new DatabaseHelperLogIn(this);
        databaseHelperLogIn = databaseHelperLogIn.open();

        enterUsername = (EditText)findViewById(R.id.editTextUserName);
        enterPassword = (EditText)findViewById(R.id.editTextPassword);

        SignUpButton =(Button)findViewById(R.id.sign_up_button1);
        SignUpButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String username = enterUsername.getText().toString();
                String password = enterPassword.getText().toString();

                if(username.equals("")||password.equals(""))
                {
                    Toast.makeText(getApplicationContext(), "You need both a password and a username to make an account!", Toast.LENGTH_LONG)
                            .show();
                    return;
                } else {
                    databaseHelperLogIn.insertUserDetails(username, password);
                    Toast.makeText(getApplicationContext(), "Sign Up Successful", Toast.LENGTH_LONG).show();
                    Intent intentBackHome=new Intent(getApplicationContext(),WelcomeActivity.class);
                    startActivity(intentBackHome);
                }
            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        databaseHelperLogIn.close();
    }

}

