package com.example.practical6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class StudentData extends AppCompatActivity {
    RecyclerView recyclerView;
    DBHandler dbHandler;
    ArrayList<String> id, name , enrollmentNumber, spi, sem;
    CustemAdapter custemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_data);


        recyclerView = findViewById(R.id.recycleView);
        dbHandler = new DBHandler(StudentData.this);
        id = new ArrayList<>();
        name = new ArrayList<>();
        enrollmentNumber = new ArrayList<>();
        spi = new ArrayList<>();
        sem = new ArrayList<>();

        storeDataInArray();
        custemAdapter = new CustemAdapter(StudentData.this,id,name,enrollmentNumber,spi,sem);
        recyclerView.setAdapter(custemAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(StudentData.this));

    }
    void storeDataInArray(){
        Cursor cursor = dbHandler.readAllData();
        if(cursor.getCount() == 0){
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }else {
            while (cursor.moveToNext()){
                id.add(cursor.getString(0));
                name.add(cursor.getString(1));
                enrollmentNumber.add(cursor.getString(2));
                spi.add(cursor.getString(3));
                sem.add(cursor.getString(4));
            }
        }
    }


}