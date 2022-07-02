package com.example.hannan.reservationsystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class room extends AppCompatActivity {
    //    String choice =" ";
    Button btn1, btn2, btn3, btn4, btn5, btn6;
    Double price = 0.00;
    String choice =" ";
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        btn1 = (Button) findViewById(R.id.book1);
        btn2 = (Button) findViewById(R.id.book2);
        btn3 = (Button) findViewById(R.id.book3);
        btn4 = (Button) findViewById(R.id.book4);
        btn5 = (Button) findViewById(R.id.book5);
        btn6 = (Button) findViewById(R.id.book6);

        back=(ImageView)findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(room.this, MainActivity.class);
                startActivity(i);
            }
        });


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                details();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                details1();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                details2();
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                details3();
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                details4();
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                details5();
            }
        });
    }
    public void details(){
            choice = choice+"single bed";
            price = price + 3000;
            Intent i = new Intent(room.this, details.class);
            Bundle bundle = new Bundle();
            bundle.putString("choices", choice);
            bundle.putDouble("price", price);
            i.putExtras(bundle);
            startActivity(i);
    }
    public void details1(){
        choice = choice+"Double Bed with teras";
        price = price + 3500;
        Intent i = new Intent(room.this, details.class);
        Bundle bundle = new Bundle();
        bundle.putString("choices",choice);
        bundle.putDouble("price",price);
        i.putExtras(bundle);
        startActivity(i);
    }
    public void details2(){
        choice = choice+"Double bed with dinnig table";
        price = price + 4000;
        Intent i = new Intent(room.this, details.class);
        Bundle bundle = new Bundle();
        bundle.putString("choices",choice);
        bundle.putDouble("price",price);
        i.putExtras(bundle);
        startActivity(i);
    } public void details3(){
        choice = choice+"single bed";
        price = price + 3000;
        Intent i = new Intent(room.this, details.class);
        Bundle bundle = new Bundle();
        bundle.putString("choices",choice);
        bundle.putDouble("price",price);
        i.putExtras(bundle);
        startActivity(i);
    }
    public void details4(){
        choice = choice+"Bed with Jakuzi";
        price = price + 3500;
        Intent i = new Intent(room.this, details.class);
        Bundle bundle = new Bundle();
        bundle.putString("choices",choice);
        bundle.putDouble("price",price);
        i.putExtras(bundle);
        startActivity(i);
    }
    public void details5(){
        choice = choice+"Master bed";
        price = price + 10000;
        Intent i = new Intent(room.this, details.class);
        Bundle bundle = new Bundle();
        bundle.putString("choices",choice);
        bundle.putDouble("price",price);
        i.putExtras(bundle);
        startActivity(i);
    }

}



//
//    public void add_to_list(View view){
//        if (view == findViewById(R.id.book1)){
//            choice = choice + "single bed"+"\n";
//            price = price +3000;
//            Intent i = new Intent(room.this, details.class);
//            Bundle bundle = new Bundle();
//            bundle.putString("choices",choice);
//            bundle.putDouble("price",price);
//            i.putExtras(bundle);
//            startActivity(i);
//        }
//        else if (view == findViewById(R.id.book2)) {
//            choice = choice + "Torta"+"\n";
//            price = price +3500;
//
//        }
//        else if (view == findViewById(R.id.book3))
//         {
//            choice = choice + "Cake"+"\n";
//            price = price +767;
//
//        }
//        else if (view == findViewById(R.id.book4))
//                 {
//            choice = choice + "Cake"+"\n";
//            price = price +90;
//        }
//        else if (view == findViewById(R.id.book5))
//        {
//            choice = choice + "Cake"+"\n";
//            price = price +90;
//        } else if (view == findViewById(R.id.book6) ){
//            choice = choice + "Cake"+"\n";
//            price = price +90;
//        }
//
//    }
//    public void placeOrder(View view){
//        Intent i = new Intent(room.this, details.class);
//        Bundle bundle = new Bundle();
//        bundle.putString("choices",choice);
//        bundle.putDouble("price",price);
//        i.putExtras(bundle);
//        startActivity(i);
//
//    }



