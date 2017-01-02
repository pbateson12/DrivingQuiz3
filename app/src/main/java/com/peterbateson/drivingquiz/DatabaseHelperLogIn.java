package com.peterbateson.drivingquiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseHelperLogIn
{

    private DataBaseHelper dataBaseHelper;
    static final int DATABASE_VERSION = 1;
    static final String DATABASE_NAME = "userAccounts.db";
    static final String DATABASE_CREATE = "create table " + "LOGIN" + "( " +"ID"+" integer primary key autoincrement,"+ "USERNAME text, PASSWORD text); ";
    public SQLiteDatabase database;
    private final Context key;


    public DatabaseHelperLogIn open() throws SQLException
    {
        database = dataBaseHelper.getWritableDatabase();
        return this;
    }


    public void close()
    {
        database.close();
    }


    public DatabaseHelperLogIn(Context userKey)
    {
        key = userKey;
        dataBaseHelper = new DataBaseHelper(key, DATABASE_NAME, null, DATABASE_VERSION);
    }


    public void insertUserDetails (String userName, String password)
    {
        ContentValues newUserDetails = new ContentValues();
        newUserDetails.put("USERNAME", userName);
        newUserDetails.put("PASSWORD",password);
        database.insert("LOGIN", null, newUserDetails);
    }


    public String getUserDetails(String userName)
    {
        Cursor cursor = database.query("LOGIN", null, " USERNAME = ?", new String[]{userName}, null, null, null);

        if(cursor.getCount() < 1)
        {
            cursor.close();
            return "NOT EXIST";
        }

        cursor.moveToFirst();
        String password= cursor.getString(cursor.getColumnIndex("PASSWORD"));
        cursor.close();
        return password;
    }

}

