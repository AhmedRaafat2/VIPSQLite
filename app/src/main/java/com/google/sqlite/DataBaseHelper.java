package com.google.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DataBaseHelper extends SQLiteOpenHelper {

    private  static final String TABLE_EMPLOYEE = "employees_table";
    private  static final String KEY_ID = "id";
    private  static final String KEY_NAME = "name";
    private  static final String KEY_ADDRESS = "address";
    private  static final String KEY_SALARY = "salary";
    private  static final String KEY_JOB = "job";



    public DataBaseHelper(Context context) {
        super(context, "Employees", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createStatement = "CREATE TABLE "+TABLE_EMPLOYEE+"("+KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT ,"+KEY_NAME+" VARCHAR(50),"+KEY_ADDRESS+" VARXHAR(255),"+KEY_SALARY+" DOUBLE,"+KEY_JOB+" VARCHAR(255))";
        db.execSQL(createStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addEmployee(Employee employee){

        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ID,employee.getId());
        values.put(KEY_NAME,employee.getName());
        values.put(KEY_ADDRESS,employee.getAddress());
        values.put(KEY_SALARY,employee.getSalary());
        values.put(KEY_JOB,employee.getJob());
        db.insert(TABLE_EMPLOYEE,null,values);
        db.close();

    }

    public ArrayList<Employee> getAllEmployess()
    {
        ArrayList<Employee> allEmployess = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        db.rawQuery("SELECT * FROM "+TABLE_EMPLOYEE,null);




        
        return  allEmployess;
    }
}
