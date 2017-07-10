package com.example.pratiksha.lifecare_20;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.StrictMode;
import android.widget.Toast;
//class to implement sessions with help of local database sqllite

public class DBHelper extends SQLiteOpenHelper {

    SQLiteDatabase db;
    Cursor cursor;
    public static String  identify;


    public DBHelper(Context context)
    {
        super(context, "food.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
            db.execSQL("create table user(sr varchar,id varchar,status varchar)");//,name varchar,contact varchar,email varchar,address varchar);");
    }

    public int insertData() {

        try
        {
            db = this.getWritableDatabase();
            ContentValues c = new ContentValues();
            c.put("sr", "1");
            c.put("id", "");
            c.put("status", "0");

            long ll = db.insert("user", null, c);
            if (ll == -1)
                return (0);
            else
                return 1;
        }
        catch (Exception e)
        {
            return 0;
        }
    }

    public Cursor retrieveData(){

        try
        {
            db = this.getWritableDatabase();
            cursor = db.rawQuery("select * from user", null);
            return cursor;
        }
        catch (Exception e)
        {
            return null;
        }
    }

    public boolean updateData(String i, int st) {

        try{
            db = this.getWritableDatabase();
            ContentValues c = new ContentValues();
            c.put("id",i);
            c.put("status",String.valueOf(st));
          return  db.update("user", c, "sr="+1,null)>0;

        }
        catch (Exception e)
        {
            return false;
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
