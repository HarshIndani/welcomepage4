package com.example.welcomepage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class DB1Helper extends SQLiteOpenHelper {
    public static final String DBNAME = "w_Login.db";
    public DB1Helper(Context context) {
        super(context, "w_Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table worker_users(name TEXT primary key, password TEXT, phone TEXT, experience TEXT, age TEXT, address TEXT, email TEXT, gender TEXT, aadhar TEXT, jobpref TEXT, locality TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists worker_users");
    }

    public Boolean insertData(String name, String password, String phone, String experience, String age, String address, String email, String gender, String aadhar, String jobpref, String locality){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("name", name);
        contentValues.put("password", password);
        contentValues.put("phone", phone);
        contentValues.put("experience", experience);
        contentValues.put("age", age);
        contentValues.put("address", address);
        contentValues.put("email", email);
        contentValues.put("gender", gender);
        contentValues.put("aadhar", aadhar);
        contentValues.put("jobpref", jobpref);
        contentValues.put("locality", locality);
        long result = MyDB.insert("worker_users", null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }

    public Boolean checkusername(String name) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from worker_users where name = ?", new String[]{name});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean checkusernamepassword(String name, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from worker_users where name = ? and password = ?", new String[] {name,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
    public Cursor OwnerData(String locality, String jobpref) {
        SQLiteDatabase db1 = this.getWritableDatabase();
        Cursor res = db1.rawQuery("select * from   worker_users where locality = ? and jobpref = ?", new String[] {locality,jobpref});
        return res;
    }
}