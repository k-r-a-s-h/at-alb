package com.example.survey_q1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DB_NAME="survey.db";
    public static final String TBL_NAME="survey_table";
    public static final String COL_1="ID";
    public static final String COL_2="ANS1";
    public static final String COL_3="ANS2";
    public static final String COL_4="ANS3";
    public static final String COl_5= "ANS4";

    public  DatabaseHelper(Context context){
        super(context,DB_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TBL_NAME+"(ID INTEGER PRIMARY KEY AUTOINCREMENT, ANS1 TEXT,ANS2 TEXT,ANS3 INTEGER,ANS4 INTEGER)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +TBL_NAME);
        onCreate(db);
    }

    public boolean insertRecord(boolean ans1,boolean ans2,boolean ans3,boolean ans4){
        int answer1 = ans1 ? 1:0;
        int answer2 = ans2 ? 1:0;
        int answer3 = ans3 ? 1:0;
        int answer4 = ans4 ? 1:0;

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_2,answer1);
        contentValues.put(COL_3,answer2);
        contentValues.put(COL_4,answer3);
        contentValues.put(COl_5,answer4);
        long result = db.insert(TBL_NAME,null,contentValues);
        if(result==-1)
            return false;
        else
            return true;

    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+TBL_NAME,null);
        return res;
    }
}
