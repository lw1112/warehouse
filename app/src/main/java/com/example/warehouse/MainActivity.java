package com.example.warehouse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    private Button btn1;
    private Button btn2;
    private Button btn3;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  //页面布局

//        //创建数据库
//        DatabaseHelper helper = new DatabaseHelper(this);
//        helper.getWritableDatabase();



        btn1 = findViewById(R.id.button1);      //在布局中找到button
        btn1.setOnClickListener(new View.OnClickListener() {   //给button设置点击事件
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,QueryActivity.class);
                startActivity(intent);
            }
        });
        btn2 = findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,PurchaseActivity.class);
                startActivity(intent);
            }
        });

        btn3 = findViewById(R.id.button3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Shelf_adjustActivity.class);
                startActivity(intent);
            }
        });

    }
}
