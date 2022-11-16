package com.example.mycoffeeapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static  final  String dbname = "Login.db";
    public DBHelper(@Nullable Context context) {
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDatabase) {
        MyDatabase.execSQL("create Table users (username Text primary key, password Text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDatabase, int i, int i1) {
        MyDatabase.execSQL("drop Table if exists users");
    }

    public Boolean insertData(String username, String password){

        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",username);
        contentValues.put("password",password);
        long result = MyDatabase.insert("users",null,contentValues);

        if(result <=0 )
            return false;
        else return true;
    }



    public  Boolean checkusername(String username){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("select * from users where username = ?", new String[] {username});
         if(cursor.getCount()>0)
             return true;
         else return false;
    }
    public Boolean checkusernamePassword( String username, String password ){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("select * from users where username = ? and password = ?",new String[] {username,password});

        if(cursor.getCount()>0)
            return true;
            else
                return false;
    }


}
