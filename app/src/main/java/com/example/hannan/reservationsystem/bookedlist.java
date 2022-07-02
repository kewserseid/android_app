package com.example.hannan.reservationsystem;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class bookedlist extends AppCompatActivity {
    Button idd;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookedlist);
        idd = (Button)findViewById(R.id.list);
        idd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "there is no data wright now check later", Toast.LENGTH_LONG).show();
            }
        });

    }
}