package com.example.hannan.reservationsystem;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class adminlogin extends AppCompatActivity {
    EditText eton , etpass;
    Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlogin);

        login();
    }

    public void login(){
        eton=(EditText)findViewById(R.id.eton);
        etpass=(EditText)findViewById(R.id.etpars);
        btn1=(Button)findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (eton.getText().toString().equals("Admin") && etpass.getText().toString().equals("Admin")) {
                    Intent i = new Intent(adminlogin.this, bookedlist.class);
                    startActivity(i);
                    Toast.makeText(getApplicationContext(), "Welcome", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Wrong Username or Password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
