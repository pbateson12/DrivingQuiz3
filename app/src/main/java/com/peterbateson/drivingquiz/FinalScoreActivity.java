package com.peterbateson.drivingquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;

public class FinalScoreActivity extends AppCompatActivity {


    private Button mReturnToHome;
    private String mFinalScore;
    private TextView mFinalScoreTextView;

    private void showScore(){
        mFinalScoreTextView = (TextView)findViewById(R.id.final_score);
        mFinalScoreTextView.setText(mFinalScore);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_score);

        mFinalScore = getIntent().getStringExtra("score");

        mReturnToHome = (Button)findViewById(R.id.return_to_home_button);
        mReturnToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ReturnToHome = new Intent(FinalScoreActivity.this, WelcomeActivity.class);
                startActivity(ReturnToHome);
            }
        });

        showScore();

    }
}
