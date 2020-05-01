package com.example.warehouse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class test1Activity extends AppCompatActivity {
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);
        btn = findViewById(R.id.bnt0);
        btn.setOnClickListener(new View.OnClickListener(){
          public void onClick(View view){
              Intent intent = new Intent(com.example.warehouse.test1Activity.this,QueryActivity.class);
              startActivity(intent);
          }
        });
    }



}
