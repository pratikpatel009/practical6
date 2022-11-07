package com.example.practical6;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DBHandler extends SQLiteOpenHelper {
    private Context context;
    public static final String DATABASE_NAME = "Student_data.db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "Student_details";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_ENROLLMENT = "enrollment";
    public static final String COLUMN_SPI = "spi";
    public static final String COLUMN_SEM = "sem";


    public DBHandler(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_ENROLLMENT + " INTEGER, "+
                COLUMN_SPI + " INTEGER, "+
                COLUMN_SEM + " INTEGER);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
//        onCreate(db);
    }
    void addStudentData(String name, int enrollmentNumber, int spi, int sem ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NAME, name);
        cv.put(COLUMN_ENROLLMENT, enrollmentNumber);
        cv.put(COLUMN_SPI, spi);
        cv.put(COLUMN_SEM, sem);
        long result = db.insert(TABLE_NAME,null, cv );
        System.out.println("call method");
        if(result == -1 ){
            System.out.println("call method 1");
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
            System.out.println("call method 2");
        }else {
            System.out.println("call method 3");
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show();
            System.out.println("call method 4");
        }


    }

    Cursor readAllData(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null ){
          cursor =  db.rawQuery(query , null);

        }
        return  cursor;
    }
}
