package com.example.vijay;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;

public class graoh extends AppCompatActivity {

    SharedPreferences sp;
    GraphView g;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRefx = database.getReference("x");
    DatabaseReference myRefy = database.getReference("ECG");
    TextView max,min,des;
    ArrayList l;
    float i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graoh);
        sp = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        max=findViewById(R.id.maxt);
        min=findViewById(R.id.mint);
        des=findViewById(R.id.dest);
        g = findViewById(R.id.idGraphView);
        myRefx.setValue(5);
        myRefy.setValue(1);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>();
        des.setText("Normal");
        myRefy.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                int value=snapshot.getValue(int.class);
                int imax=100;
                int imin=100;

                if(value>imax)
                {
                    imax=value;
                }

                if(imin<imin)
                {
                   imin=value;
                }

                max.setText("Maximun Value :  "+imax);
                min.setText("Minimum Value :  "+imin);




                if(Integer.parseInt(sp.getString("max", String.valueOf(1)))<value)
                {
                    des.setText("Critical");
                }
                if(Integer.parseInt(sp.getString("min", String.valueOf(4)))>value) {
                    des.setText("Critical");
                }


                if(value<100)
                {
                    Toast.makeText(getApplicationContext(),"Less value",Toast.LENGTH_LONG).show();
                }

                if (value>1000)
                {
                    Toast.makeText(getApplicationContext(),"More value",Toast.LENGTH_SHORT).show();
                }


                g.setTitle("My Graph View");
                g.setTitleColor(R.color.purple_200);
                g.setTitleTextSize(18);
                g.computeScroll();
                g.getViewport();
                g.animate();

                // on below line we are adding
                // data series to our graph view.

                // on below line we are adding
                // each point on our x and y axis.

                series.appendData(new DataPoint(i,value),true,100000);


                g.addSeries(series); // for printing,
                i= (float) (i+0.001);
                System.out.println(value);



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });




    }
}