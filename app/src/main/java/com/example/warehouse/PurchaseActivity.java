package com.example.warehouse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class PurchaseActivity extends AppCompatActivity {

    private Button pur_btn1;
    private Button pur_btn2;
    private Button pur_btn3;
    private Button pur_btn4;
    private Button pur_btn5;
    private EditText good_name;
    private EditText good_num ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);

        pur_btn2 = findViewById(R.id.pur_button2);
        pur_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PurchaseActivity.this,pc_extendA.class);
                startActivity(intent);
            }
        });

        pur_btn3 = findViewById(R.id.pur_button3);
        pur_btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PurchaseActivity.this,pc_extendb.class);
                startActivity(intent);
            }
        });

    }

}









