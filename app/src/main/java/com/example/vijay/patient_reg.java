package com.example.vijay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class patient_reg extends AppCompatActivity {

    Button sub;
    EditText etname, etage, etmax, etmin;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_reg);
        sub = findViewById(R.id.btnlog);
        etname = findViewById(R.id.t1);
        etage = findViewById(R.id.t2);
        etmax = findViewById(R.id.t3);
        etmin = findViewById(R.id.t4);

        sp = getSharedPreferences("MySharedPref", MODE_PRIVATE);

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etname.getText().toString();
                String age = etage.getText().toString();
                String max = etmax.getText().toString();
                String min = etmin.getText().toString();



// Creating an Editor object to edit(write to the file)
                SharedPreferences.Editor myEdit = sp.edit();

// Storing the key and its value as the data fetched from edittext
                myEdit.putString("name", name);
                myEdit.putString("age",age);
                myEdit.putString("max",max);
                myEdit.putString("min", min);
                myEdit.commit();
            }

        });

    }
}