package com.example.warehouse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class QueryActivity extends AppCompatActivity {
    private Button qnt1;
    private Button qnt2;
    private Button qnt3;
    private Button qnt4;
    private TextView view5;
    private TextView view4;
    private TextView view3;
    public  String[] m={"货物1","货物2","货物3"};
    private static final String[] m5={"A","B","C"};
    private static final String[] m4={"1月","2月","3月","4月","5月","6月","7月","8月","9月","10月","11月","12月"};
    private static final String[] m3={"货物1","货物2","货物3"};
    private static final String[] m2={"货物4","货物5","货物6"};
    private static final String[] m1={"货物7","货物8","货物9"};
    private static final String[] m0={"货物1","货物2","货物3","货物4","货物5","货物6","货物7","货物8","货物9"};
    private Spinner spin3;
    private Spinner spin4;
    private Spinner spin5;
    private ArrayAdapter<String> adapter3;
    private ArrayAdapter<String> adapter4;
    private ArrayAdapter<String> adapter5;
    private EditText qet1;
    private EditText qet2;
    private String ename;
    private String eid;
    private String enumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);
        final shujucunchuqi shujucunchuqi1 = new shujucunchuqi(0);

        //统计
        qnt1 = findViewById(R.id.b_tong);
        ((View) qnt1).setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(QueryActivity.this,test1Activity.class);
                startActivity(intent);
            }
        });

        //确定
        qnt2 = findViewById(R.id.b_in);
        qnt2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(QueryActivity.this,test2Activity.class);
                startActivity(intent);
            }
        });
        //name确定
        qnt3 = findViewById(R.id.b_name);
        qnt3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Thread t1 = new loginservlet(ename, shujucunchuqi1);
                t1.start();
                enumber = String.valueOf(shujucunchuqi1.i);
                Intent intent = new Intent(QueryActivity.this,test3Activity.class);
                intent.putExtra("ENAME",ename);
                intent.putExtra("ENUMBER",enumber);
                startActivity(intent);
            }
        });

        //编号确定
        qnt4 = findViewById(R.id.b_num);
        qnt4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Thread t1 = new loginservlet(eid, shujucunchuqi1);
                t1.start();
            }
        });

        qet1 =findViewById(R.id.e_name);
        qet1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                ename = s.toString();
            }
        });
        qet2 =findViewById(R.id.e_num);
        qet2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                eid = s.toString();
            }
        });

        view3 = findViewById(R.id.textView3);
        spin3 = findViewById(R.id.spinner3);
        //将可选内容与ArrayAdapter连接起来
        adapter3 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,m);
        //设置下拉列表的风格
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //将adapter 添加到spinner中
        spin3.setAdapter(adapter3);
        //添加事件Spinner事件监听
        spin3.setOnItemSelectedListener(new SpinnerSelectedListener3());
        //设置默认值
        spin3.setVisibility(View.VISIBLE);

        view4 = findViewById(R.id.textView4);
        spin4 = findViewById(R.id.spinner4);
        //将可选内容与ArrayAdapter连接起来
        adapter4 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,m4);
        //设置下拉列表的风格
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //将adapter 添加到spinner中
        spin4.setAdapter(adapter4);
        //添加事件Spinner事件监听
        spin4.setOnItemSelectedListener(new SpinnerSelectedListener4());
        //设置默认值
        spin4.setVisibility(View.VISIBLE);

        view5 = findViewById(R.id.textView5);
        spin5 = findViewById(R.id.spinner5);
        //将可选内容与ArrayAdapter连接起来
        adapter5 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,m5);
        //设置下拉列表的风格
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //将adapter 添加到spinner中
        spin5.setAdapter(adapter5);
        //添加事件Spinner事件监听
        spin5.setOnItemSelectedListener(new SpinnerSelectedListener5());
        //设置默认值
        spin5.setVisibility(View.VISIBLE);
    }

    class SpinnerSelectedListener3 implements AdapterView.OnItemSelectedListener {
        public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
                                   long arg3) {
            view3.setText("货别: " + m[arg2]);
        }

        public void onNothingSelected(AdapterView<?> arg0) {
        }
    }

    class SpinnerSelectedListener4 implements AdapterView.OnItemSelectedListener {
        public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
                                   long arg3) {
            view4.setText("时间: " + m4[arg2]);
        }

        public void onNothingSelected(AdapterView<?> arg0) {
        }
    }

    class SpinnerSelectedListener5 implements AdapterView.OnItemSelectedListener {
        public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
                                   long arg3) {
            view5.setText("类别：" + m5[arg2]);
            switch (arg2){
                case 0:
                    m[0]=m3[0];
                    m[1]=m3[1];
                    m[2]=m3[2];
                    break;
                case 1:
                    m[0]=m2[0];
                    m[1]=m2[1];
                    m[2]=m2[2];
                    break;
                case 2:
                    m[0]=m1[0];
                    m[1]=m1[1];
                    m[2]=m1[2];
                    break;
                default:
                    m[0]=m3[0];
                    m[1]=m3[1];
                    m[2]=m3[2];
                    break;
            }
        }

        public void onNothingSelected(AdapterView<?> arg0) {
        }
    }
}

class loginservlet extends Thread {
    String ename = null;
    Socket socket;
    BufferedReader br = null;
    PrintWriter pw = null;
    shujucunchuqi shujucunchuqi1 = null;

    public void run() {
        try {
            Socket updateSocket = new Socket("192.168.0.103",8888);
            DataInputStream in = new DataInputStream(updateSocket.getInputStream());
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            String JsonStr = null;
            byte[] by = new byte[2048];
            int n;
            while ((n = in.read(by)) != -1)
            {
                baos.write(by, 0, n);
            }
            JsonStr = new String(baos.toByteArray(),"GB2312");
            JSONObject polListJsonObj = new JSONObject(JsonStr);
            JSONArray polArray = polListJsonObj.getJSONArray("res");
            JSONObject jsonObj = polArray.getJSONObject(1);

            updateSocket.close();
            System.out.println(polArray);
//            socket = new Socket("10.180.55.98", 11000);
//            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
//            pw.println("query&"+ename);
//            System.out.println("向服务器发送：" + ename);
//            pw.flush();
//            while (true) {
//                String a = br.readLine();
//                System.out.println(a);
//                if (a.split("&")[0].equals("OK")) {
//                    System.out.println("验证通过");
//                    shujucunchuqi1.i = Integer.valueOf(a.split("&")[1]);
//                    System.out.println(shujucunchuqi1.i);
//                }
//            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    loginservlet(String ename, shujucunchuqi shujucunchuqi1) {
        this.ename = ename;
        this.shujucunchuqi1 = shujucunchuqi1;
    }
}