package com.peterbateson.drivingquiz;

import android.widget.Button;
import android.widget.EditText;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class WelcomeActivity extends AppCompatActivity
{
    DatabaseHelperLogIn databaseHelperLogIn;
    Button LogInButton2;
    Button SignUpButton2;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        databaseHelperLogIn =new DatabaseHelperLogIn(this);
        databaseHelperLogIn = databaseHelperLogIn.open();

        SignUpButton2 = (Button)findViewById(R.id.sign_up_button2);
        SignUpButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intentSignUP=new Intent(getApplicationContext(),SignUpActivity.class);
                startActivity(intentSignUP);
            }
        });

        LogInButton2 = (Button)findViewById(R.id.log_in_button2);

    }


    public void signIn(View V)
    {

        final Dialog dialog = new Dialog(WelcomeActivity.this);
        dialog.setContentView(R.layout.activity_log_in); //pop up the activity_log_in.xml
        dialog.setTitle("User Login Pop Up");

        final EditText UserName = (EditText)dialog.findViewById(R.id.username);
        final  EditText Password = (EditText)dialog.findViewById(R.id.password);

        Button LogInButton1 = (Button)dialog.findViewById(R.id.log_in_button1);

        LogInButton1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String usernameString = UserName.getText().toString();
                String passwordString = Password.getText().toString();

                String userPasswordString = databaseHelperLogIn.getUserDetails(usernameString);

                if (!passwordString.equals(userPasswordString)) {
                    Toast.makeText(WelcomeActivity.this, "Incorrect Details", Toast.LENGTH_LONG)
                            .show();
                } else {
                    Toast.makeText(WelcomeActivity.this, "You have successfully logged in!", Toast.LENGTH_LONG)
                            .show();
                    dialog.dismiss();
                    Intent userProfile = new Intent(WelcomeActivity.this, WelcomeUserActivity.class);
                    userProfile.putExtra("Username", usernameString);
                    startActivity(userProfile);
                }
            }
        });

        dialog.show();

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        databaseHelperLogIn.close();
    }

}




