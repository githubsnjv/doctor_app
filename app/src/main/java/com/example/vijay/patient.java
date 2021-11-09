package com.example.vijay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class patient extends AppCompatActivity {

    TextView tt1,tt2,tt3,tt4;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);

        tt1=findViewById(R.id.t1);
        tt2=findViewById(R.id.t2);
        tt3=findViewById(R.id.t3);
        tt4=findViewById(R.id.t4);
         sp = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        tt1.setText(" Patient Name : "+sp.getString("name","no value"));
        tt2.setText("          Age : "+sp.getString("age", "no"));
        tt3.setText("Max Threshold : "+sp.getString("max", "no"));
        tt4.setText("Min Threshold : "+sp.getString("min","no"));

    }
}