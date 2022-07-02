package com.example.hannan.reservationsystem;

import android.app.DatePickerDialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class details extends AppCompatActivity implements android.view.View.OnClickListener {
    EditText editsearchname,editstdname,editstdsec,editstdgrade;
    Button Add, Delete, Modify, View,search ;
    DatePickerDialog.OnDateSetListener setListener;
    Button book, update, searchbtn, home;
    SQLiteDatabase db;
    TextView listView, priceView;
    String list_choice;
    Double price_et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        db=openOrCreateDatabase("Student1DB", Context.MODE_PRIVATE, null);
        //create table Student
        db.execSQL("CREATE TABLE IF NOT EXISTS Student1(StdId INTEGER PRIMARY KEY AUTOINCREMENT,StdName VARCHAR,StdSection VARCHAR,StdGrade VARCHAR,StdDep VARCHAR);");
        editsearchname = (EditText) findViewById(R.id.editstdname);
        editstdname = (EditText) findViewById(R.id.editText);
        editstdsec = (EditText) findViewById(R.id.editText2);
        editstdgrade = (EditText) findViewById(R.id.editText3);

        Add = (Button) findViewById(R.id.btnsave);
        Modify= (Button) findViewById(R.id.btnupdate);
        search=(Button) findViewById(R.id. btnselectperticular);
        home=(Button) findViewById(R.id. button2);
        Add.setOnClickListener(this);
        Modify.setOnClickListener(this);
        search.setOnClickListener(this);

        listView = (TextView) findViewById(R.id.listView);
        priceView = (TextView) findViewById(R.id.priceView);


        Bundle bundle = getIntent().getExtras();
        list_choice = bundle.getString("choices");
        price_et = bundle.getDouble("price");

        listView.setText(list_choice);
        priceView.setText(price_et.toString() + "birr");


        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(details.this, MainActivity.class);
                startActivity(i);
            }
        });
    }

    public void msg(Context context,String str)
    {
        Toast.makeText(this,str, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(android.view.View v) {
        if(v.getId()==R.id.btnsave)
        {
            // code for save data
            if(editstdname.getText().toString().trim().length()==0||
                    editstdsec.getText().toString().trim().length()==0||
                    editstdgrade.getText().toString().trim().length()==0)
            {
                msg(this, "Please insert valid info");
                return;
            }
            db.execSQL("INSERT INTO Student1(StdName,StdSection,StdGrade)VALUES('" + editstdname.getText() + "','" + editstdsec.getText() + "','" + editstdgrade.getText() + "');");
            msg(this, "you have booked your room succesfully");

            long[] vv ={500,1000};
            Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                    .setSmallIcon(R.drawable.smallbtn)
                    .setContentTitle("WEllcome thank you for booking in our hotel")
                    .setContentText("You have Booked a room that is pending to be payed in 24hrs.")
                    .setAutoCancel(true)
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .setVibrate(vv)
                    .setSound(uri)
                    .setLights(5009, 5500, 2500);

            Intent notificationIntent = new Intent(this, MainActivity.class);
            notificationIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            notificationIntent.putExtra("message", "hello");

            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
            builder.setContentIntent(pendingIntent);

            NotificationManager manager =(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
            manager.notify(0, builder.build());
            Toast.makeText(getApplicationContext(), "Saved to database Succesfully", Toast.LENGTH_SHORT).show();
        }

        else if(v.getId()==R.id.btnupdate)
        {
            //code for update data
            if(editsearchname.getText().toString().trim().length()==0)
            {
                msg(this, "Enter a Name you have enterd last time");
                return;
            }
            Cursor c=db.rawQuery("SELECT * FROM Student1 WHERE StdName='"+ editsearchname.getText()+"'", null);
            if(c.moveToFirst()) {
                db.execSQL("UPDATE Student1  SET StdName ='"+ editstdname.getText()+"', StdSection='"+ editstdsec.getText()+"',StdGrade='"+      editstdgrade.getText()+"' WHERE StdName ='"+editsearchname.getText()+"'");
                msg(this, "info updated");
            }
            else
            {
                msg(this, "INcorrect Value");
            }
        }
        else if(v.getId()==R.id.btnselectperticular)
        {
            //code for select particular data
            if(editsearchname.getText().toString().trim().length()==0)
            {
                msg(this, "Enter your Name");
                return;
            }
            Cursor c=db.rawQuery("SELECT * FROM Student1 WHERE StdName='"+editsearchname.getText()+"'", null);
            if(c.moveToFirst())
            {
                editstdname.setText(c.getString(1));
                editstdsec.setText(c.getString(2));
                editstdgrade.setText(c.getString(3));
            }
            else
            {
                msg(this, "information incorect you can book again");
            }
        }
    }
}
