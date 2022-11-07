package com.example.practical6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText name,enrollmentNumber,spi,sem;
    Button save,show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        enrollmentNumber = findViewById(R.id.enrollmentNumber);
        spi = findViewById(R.id.spi);
        sem = findViewById(R.id.sem);

        save = findViewById(R.id.saveData);
        show = findViewById(R.id.showData);
        show.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this,StudentData.class);
            startActivity(intent);
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHandler dbHandler = new DBHandler(MainActivity.this);
                dbHandler.addStudentData(name.getText().toString().trim(),Integer.valueOf(enrollmentNumber.getText().toString().trim()),Integer.valueOf(spi.getText().toString().trim()),Integer.valueOf(sem.getText().toString().trim()));
                System.out.println(name.getText().toString().trim());
                System.out.println(Integer.valueOf(enrollmentNumber.getText().toString().trim()));
                System.out.println(Integer.valueOf(spi.getText().toString().trim()));
                System.out.println(Integer.valueOf(sem.getText().toString().trim()));
                System.out.println(Integer.valueOf(enrollmentNumber.getText().toString().trim()));
            }
        });
    }
}