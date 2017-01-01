package com.peterbateson.drivingquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;
import android.widget.TextView;
import android.content.Intent;

public class QuizActivity extends AppCompatActivity {

    public int currentScore = 0;
    private int mCurrentIndex = 0;

    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private Button mCheatButton;
    private TextView mQuestionTextView;
    private boolean mAnswerIsTrue;

    public String currentScoreString = String.valueOf(currentScore);


    private TrueFalse[] mQuestionBank = new TrueFalse[] {
            new TrueFalse(R.string.question_1, false),
            new TrueFalse(R.string.question_2, true),
            new TrueFalse(R.string.question_3, false),
            new TrueFalse(R.string.question_4, false),
            new TrueFalse(R.string.question_5, true),
    };

    public void updateQuestion()
    {
        int question = mQuestionBank[mCurrentIndex].getmQuestion();
        mQuestionTextView.setText(question);
    }


    private void updateScore() {
        TextView Score = (TextView)findViewById(R.id.onScreenScore);
        Score.setText(currentScoreString);
    }

    private void checkAnswer(boolean userPressedTrue) {
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].ismTrueQuestion();
        mCurrentIndex = mCurrentIndex + 1;

        if (userPressedTrue == answerIsTrue) {
            currentScore = currentScore + 1;
            currentScoreString = String.valueOf(currentScore);
        }

        if(mCurrentIndex<5){
            updateQuestion();
        } else {
            Intent toFinalScorePage = new Intent(QuizActivity.this, FinalScoreActivity.class);
            toFinalScorePage.putExtra("score", currentScoreString);
            startActivity(toFinalScorePage);
        }

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mQuestionTextView = (TextView)findViewById(R.id.question_text_view);

        mTrueButton = (Button)findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
                updateScore();
            }
        });

        mFalseButton = (Button)findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
                updateScore();
            }
        });

        mNextButton = (Button)findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = mCurrentIndex + 1;
                if(mCurrentIndex<5){
                    updateQuestion();
                } else {
                    Intent toFinalScorePage = new Intent(QuizActivity.this, FinalScoreActivity.class);
                    toFinalScorePage.putExtra("score", currentScoreString);
                    startActivity(toFinalScorePage);
                }
            }
        });

        mCheatButton = (Button)findViewById(R.id.cheat_button);
        mCheatButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int messageCheat = 0;
                    mAnswerIsTrue = mQuestionBank[mCurrentIndex].ismTrueQuestion();

                    if (mAnswerIsTrue) {
                        messageCheat = R.string.answer_true;
                    } else {
                        messageCheat = R.string.answer_false;
                    }

                    Toast.makeText(getApplicationContext(), messageCheat, Toast.LENGTH_LONG)
                            .show();

                    mCurrentIndex = mCurrentIndex + 1;
                    if(mCurrentIndex<5){
                        updateQuestion();
                    } else {
                        Intent toFinalScorePage = new Intent(QuizActivity.this, FinalScoreActivity.class);
                        toFinalScorePage.putExtra("score", currentScoreString);
                        startActivity(toFinalScorePage);
                    }

                }
        });

        updateQuestion();

    }

}
