package com.example.warehouse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class test3Activity extends AppCompatActivity {

    private TextView tname;
    private TextView tnum;
    private TextView tin;
    private TextView tout;

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

        tin = findViewById(R.id.textView42);
        String ein = getIntent().getStringExtra("EIN");
        tin.setText(ein);

        tout = findViewById(R.id.textView41);
        String eout = getIntent().getStringExtra("EOUT");
        tout.setText(eout);
    }
}
