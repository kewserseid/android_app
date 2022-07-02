package com.example.hannan.reservationsystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
     Button book, admin, about;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        book=(Button)findViewById(R.id.button);
        admin=(Button)findViewById(R.id.admin);
        about=(Button)findViewById(R.id.about);

        book.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                bookbtn();
            }
        });

        admin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                adminbtn();
            }
        });

        about.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                aboutbtn();
            }
        });
    }

    public void bookbtn(){
        Intent i=new Intent(MainActivity.this, room.class);
        startActivity(i);
    }


    public void adminbtn(){
        Intent i=new Intent(MainActivity.this, adminlogin.class);
        startActivity(i);
    }


    public void aboutbtn(){
        Intent i=new Intent(MainActivity.this, aboutus.class);
        startActivity(i);
    }
}
