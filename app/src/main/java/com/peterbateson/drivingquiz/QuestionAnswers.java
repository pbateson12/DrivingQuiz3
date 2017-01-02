package com.peterbateson.drivingquiz;

public class QuestionAnswers {
    private int mQuestion;

    private boolean mTrueQuestion;

    public QuestionAnswers(int question, boolean trueQuestion) {
        mQuestion = question;
        mTrueQuestion = trueQuestion;
    }

    public int getmQuestion() {
        return mQuestion;
    }

    public void setmQuestion(int question) {
        mQuestion = question;
    }

    public boolean ismTrueQuestion() {
        return mTrueQuestion;
    }

    public void setTrueQuestion(boolean trueQuestion) {
        mTrueQuestion = trueQuestion;
    }

}
