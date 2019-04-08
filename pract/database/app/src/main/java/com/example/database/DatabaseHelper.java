package com.example.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DB_NAME="DATA.db";
    public static final String TBL_NAME="data_table";
    public static final String COL_1="ID";
    public static final String COL_2="DATA";
    public DatabaseHelper(Context context){
        super(context,DB_NAME,null,1);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TBL_NAME+" (ID INTEGER PRIMARY KEY AUTOINCREMENT,DATA TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TBL_NAME);
        onCreate(db);
    }

    public boolean insertData(String data){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_2, data);
        long result=db.insert(TBL_NAME, null, contentValues);
        if (result==-1){
            return  false;
        }
        else{
            return true;
        }
    }
    public Cursor getAllData(){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor res=db.rawQuery("SELECT * FROM "+TBL_NAME, null);

        return res;
    }
}
