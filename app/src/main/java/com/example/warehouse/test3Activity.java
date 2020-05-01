package com.example.warehouse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class test3Activity extends AppCompatActivity {

    private TextView tname;
    private TextView tnum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test3);

        tname = findViewById(R.id.textView39);
        String ename=getIntent().getStringExtra("ENAME");
        tname.setText(ename);

        tnum = findViewById(R.id.textView40);
        String enumber=getIntent().getStringExtra("ENUMBER");
        tnum.setText(enumber);
    }
}
