package com.example.hannan.reservationsystem;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class group extends AppCompatActivity {
    ListView l;
    String[] members={"Elsabet Mulugeta    uu69856R","Sifen Yitagesu   UU69396R","Kewser Seid    UU72680R"};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);
        l=(ListView)findViewById(R.id.list);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,members);
        l.setAdapter(adapter);
    }
}
