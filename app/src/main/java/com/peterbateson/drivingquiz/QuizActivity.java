package com.peterbateson.drivingquiz;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;
import android.widget.Button;
import android.widget.TextView;
import android.os.Bundle;
import android.content.Intent;

public class QuizActivity extends AppCompatActivity {

    public int currentScore = 0;
    private int Index = 0;
    private Button TrueButton;
    private Button FalseButton;
    private Button SkipButton;
    private Button CheatButton;
    private TextView currentQuestion;
    private boolean AnswerIsTrue;

    public String currentScoreString = String.valueOf(currentScore);


    private QuestionAnswers[] QuestionBank = new QuestionAnswers[] {
            new QuestionAnswers(R.string.question_1, false),
            new QuestionAnswers(R.string.question_2, true),
            new QuestionAnswers(R.string.question_3, false),
            new QuestionAnswers(R.string.question_4, false),
            new QuestionAnswers(R.string.question_5, true),
            new QuestionAnswers(R.string.question_6, false),
            new QuestionAnswers(R.string.question_7, true),
            new QuestionAnswers(R.string.question_8, true),
            new QuestionAnswers(R.string.question_9, false),
            new QuestionAnswers(R.string.question_10, true),
            new QuestionAnswers(R.string.question_11, false),
            new QuestionAnswers(R.string.question_12, false),
            new QuestionAnswers(R.string.question_13, false),
            new QuestionAnswers(R.string.question_14, true),
            new QuestionAnswers(R.string.question_15, true),
            new QuestionAnswers(R.string.question_16, true),
    };

    public void updateQuestionNumber()
    {
        int question = QuestionBank[Index].getmQuestion();
        currentQuestion.setText(question);
    }


    private void updateUserScore() {
        TextView Score = (TextView)findViewById(R.id.onScreenScore);
        Score.setText(currentScoreString);
    }

    private void checkUserAnswer(boolean userPressedTrue) {
        boolean answerIsTrue = QuestionBank[Index].ismTrueQuestion();
        Index = Index + 1;

        if (userPressedTrue == answerIsTrue) {
            currentScore = currentScore + 1;
            currentScoreString = String.valueOf(currentScore);
        }

        if (Index < 16) {
            updateQuestionNumber();
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

        currentQuestion = (TextView)findViewById(R.id.question_text_view);

        TrueButton = (Button)findViewById(R.id.true_button);
        TrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkUserAnswer(true);
                updateUserScore();
            }
        });

        FalseButton = (Button)findViewById(R.id.false_button);
        FalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkUserAnswer(false);
                updateUserScore();
            }
        });

        SkipButton = (Button)findViewById(R.id.skip_button);
        SkipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Index = Index + 1;
                if (Index < 16) {
                    updateQuestionNumber();
                } else {
                    Intent toFinalScorePage = new Intent(QuizActivity.this, FinalScoreActivity.class);
                    toFinalScorePage.putExtra("score", currentScoreString);
                    startActivity(toFinalScorePage);
                }
            }
        });

        CheatButton = (Button)findViewById(R.id.cheat_button);
        CheatButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int messageCheat = 0;
                    AnswerIsTrue = QuestionBank[Index].ismTrueQuestion();

                    if (AnswerIsTrue) {
                        messageCheat = R.string.answer_true;
                    } else {
                        messageCheat = R.string.answer_false;
                    }

                    Toast.makeText(getApplicationContext(), messageCheat, Toast.LENGTH_LONG)
                            .show();

                    Index = Index + 1;

                    if (Index < 16) {
                        updateQuestionNumber();
                    } else {
                        Intent toFinalScorePage = new Intent(QuizActivity.this, FinalScoreActivity.class);
                        toFinalScorePage.putExtra("score", currentScoreString);
                        startActivity(toFinalScorePage);
                    }

                }
        });

        updateQuestionNumber();

    }

}
