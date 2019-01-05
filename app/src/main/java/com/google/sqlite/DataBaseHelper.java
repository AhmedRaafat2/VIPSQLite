package com.google.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
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

    //هنا انا عملت ميثود بتاخد اوبجيكت من Employee
    //بعد ما هى اخدت الاوبجت
    //عملنا db = getWritableDatabase
    //ده وظيفته يدينى قلم اكتب بيه جوا الداتا بيز
    //بس حيكون فاضل الكونتينر اللى اكتب جواه
    //وعلشان كده عملنا
    //ContentValues values = new ContentValues();
    //وده كده كونتينر اعبيه بالداتا
    //اديله اسم الكولم والفايليو اللى انا جايبها من الاوبجيكت Employee اللى انا مديهوله اصلا
    //بعد ما عبينا الداتا جوا الكونتينر
    //حددى الكونتينر للقلم
    // db.insert(TABLE_EMPLOYEE,null,values);
    //ثم ضرورى اقفل الاتصال مع الداتا بيز بعد ما خلصت
    // db.close();
    public void addEmployee(Employee employee){

        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        //values.put(KEY_ID,employee.getId());
        values.put(KEY_NAME,employee.getName());
        values.put(KEY_ADDRESS,employee.getAddress());
        values.put(KEY_SALARY,employee.getSalary());
        values.put(KEY_JOB,employee.getJob());
        db.insert(TABLE_EMPLOYEE,null,values);
        db.close();

    }


    //هنا دى ميثود وظيفتها تفتح اتصال مع الداتا بيز
    //وتروح تجيبلى كل Employees اللى موجودة جوا الداتا بيز
    //بس السؤال هنا حعبيهم فى ايه؟؟؟؟
    //ArrayList<Employee> allEmployess = new ArrayList<>();
    //حعمل اوبجت يمكننى انى اقرأ من الداتا بيز
    //SQLiteDatabase db = getReadableDatabase();
    //ولازم اعمل اوبجت من كيرسور اللى بمثابة المؤشر
    //Cursor cursor = db.rawQuery("SELECT * FROM "+TABLE_EMPLOYEE,null);
    //وكمان حضطر اعمل loop علشان اقدر الف جوا الداتا بيز واعبى Employee Array بالداتا
    //وبعد ما نلف جوا ونخلص لازم نقفل الكيرسور والاتصال مع الداتابيز
    // ومتنساش تبعت الليسته فى الاخر
    //return  allEmployess;

    public ArrayList<Employee> getAllEmployess()
    {
        ArrayList<Employee> allEmployess = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+TABLE_EMPLOYEE,null);
        //for looping on all emps @dB
        while (cursor.moveToNext()){
            Employee employee = new Employee(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getDouble(3),cursor.getString(4));
            allEmployess.add(employee);
        }

        cursor.close();
        db.close();

        return  allEmployess;
    }

    public void updateEmployee(Employee employee){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_ID,employee.getId());
        values.put(KEY_NAME,employee.getName());
        values.put(KEY_ADDRESS,employee.getAddress());
        values.put(KEY_SALARY,employee.getSalary());
        values.put(KEY_JOB,employee.getJob());

        db.update(TABLE_EMPLOYEE,values,KEY_ID+"=?",new String[]{String.valueOf(employee.getId())});
        db.close();

    }

    public void deleteEmployee(int id){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_EMPLOYEE,KEY_ID+"=?",new String[]{String.valueOf(id)});

    }
}
