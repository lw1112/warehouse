package com.example.warehouse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class Shelf_adjustActivity extends AppCompatActivity {

    private Spinner shelfspin;
    private Spinner goodspin;
    private Button sbtn7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shelf_adjust);

//        shelfspin = findViewById(R.id.spinner1);
//        goodspin = findViewById(R.id.spinner2);
//        String[] ctype = new String[]{"1", "2", "3", "4", "5"};
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ctype);  //创建一个数组适配器
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);     //设置下拉列表框的下拉选项样式
//        shelfspin.setAdapter(adapter);

        sbtn7 = findViewById(R.id.button7);
        sbtn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Shelf_adjustActivity.this,sa_extend.class);
                startActivity(intent);
            }
        });


    }
}
