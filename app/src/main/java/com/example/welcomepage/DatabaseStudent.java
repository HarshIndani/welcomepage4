package com.example.welcomepage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class DatabaseStudent extends SQLiteOpenHelper {

    public static final String databasename = "Student";

    public static final String Student_table = "Student_table";

    public static final String Student_name = "Name";
    public static final String Student_rollnumber = "RollNumber";
    public static final String Student_College = "College";
    public static final String Student_Branch = "Branch";
    public static final String Student_Year = "Year";
    public static final String Parent_name = "ParentName";
    public static final String Parent_address = "ParentAddress";
    public static final String Parent_Phone_number = "Phone";
    public static final String Student_Email_ID = "Email";
    public static final String Student_Password = "Password";
    public static final int versioncode = 1;

    public DatabaseStudent(Context context) {
        super(
                context,
                databasename,
                null,
                versioncode);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        String student_query;
        student_query = "CREATE TABLE IF NOT EXISTS " + Student_table + "(Name TEXT,RollNumber NUMBER PRIMARY KEY,College TEXT,Branch TEXT,Year TEXT,ParentName TEXT,ParentAddress TEXT,Phone NUMBER, Email Text, Password TEXT)";
        database.execSQL(student_query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {

        String student_query;
        student_query = "DROP TABLE IF EXISTS " + Student_table;
        database.execSQL(student_query);


    }

    public boolean Student_Data(String name, String rollnumber, String college, String branch, String year, String parentname, String parentaddress, String phone, String email, String password) {
        SQLiteDatabase db1 = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(Student_name, name);
        cv.put(Student_rollnumber, rollnumber);
        cv.put(Student_College, college);
        cv.put(Student_Branch, branch);
        cv.put(Student_Year, year);
        cv.put(Parent_name, parentname);
        cv.put(Parent_address, parentaddress);
        cv.put(Parent_Phone_number, phone);
        cv.put(Student_Email_ID, email);
        cv.put(Student_Password, password);

        long result = db1.insert(Student_table, null, cv);
        if (result == -1)
            return false;
        else
            return true;
    }

    public Cursor StudentData() {
        SQLiteDatabase db1 = this.getWritableDatabase();
        Cursor res = db1.rawQuery("select * from " + Student_table, null);
        return res;
    }
}