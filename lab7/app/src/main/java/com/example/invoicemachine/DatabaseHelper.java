package com.example.invoicemachine;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import static android.content.ContentValues.TAG;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DB_NAME="invoice.db";
    public static final String TBL_NAME="product_table";
    public static final String COL_1="ID";
    public static final String COL_2="PRODUCT_NAME";
    public static final String COL_3="DESCRIPTION";
    public static final String COL_4="PRICE";
    public static final String COl_5= "QUANTITY";
    private Context loda;

    public  DatabaseHelper(Context context){
        super(context,DB_NAME,null,1);
        loda = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TBL_NAME+"(ID INTEGER PRIMARY KEY AUTOINCREMENT, PRODUCT_NAME TEXT,DESCRIPTION TEXT,PRICE INTEGER,QUANTITY INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +TBL_NAME);
        onCreate(db);
    }

    public boolean insertproduct(String p_name,String description,String price,String quantity){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_2,p_name);
        contentValues.put(COL_3,description);
        contentValues.put(COL_4,price);
        contentValues.put(COl_5,quantity);
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
    public Cursor getMax(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM "+TBL_NAME+" order by price desc",null);

        c.moveToFirst();
        while (c.getString(3).length()<=0){
            c.moveToNext();
        }

        int max=c.getInt(3);
        Toast.makeText(loda,"yoolo"+c.getCount()+" "+c.getString(1)+c.getString(2)+c.getString(3),Toast.LENGTH_LONG).show();
        Cursor data = db.query(TBL_NAME,null," price =? ",new String[]{""+max},null,null,null);


        return data;
    }
    public Cursor getMin(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM "+TBL_NAME+" WHERE PRICE =(Select min(price) from "+TBL_NAME+")",null);


        c.moveToFirst();
        String min=c.getString(3);
        Cursor data = db.query(TBL_NAME,null," price =? ",new String[]{""+min},null,null,null);
//        data.moveToFirst();
//        Toast.makeText(loda,"yoolo"+data.getString(2),Toast.LENGTH_LONG).show();

        return data;
    }
}
