package com.example.vijay;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.internal.NavigationMenu;
import com.google.android.material.navigation.NavigationBarMenu;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    public DrawerLayout d;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView nv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // drawer layout instance to toggle the menu icon to open
        // drawer and back button to close drawer
        d = findViewById(R.id.d);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, d, R.string.nav_open, R.string.nav_close);

        // pass the Open and Close toggle for the drawer layout listener
        // to toggle the button
        d.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        // to make the Navigation drawer icon always appear on the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nv = (NavigationView) findViewById(R.id.drawer);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.pat) {

                    Intent i = new Intent(MainActivity.this, patient.class);
                    startActivity(i);
                    TaskStackBuilder stackBuilder = TaskStackBuilder.create(getApplicationContext());

// This uses android:parentActivityName and
// android.support.PARENT_ACTIVITY meta-data by default
                    stackBuilder.addNextIntentWithParentStack(i);
                    PendingIntent pendingIntent = stackBuilder
                            .getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

                    return true;


                }

                if (id == R.id.pat_reg) {

                    Intent i = new Intent(MainActivity.this, patient_reg.class);
                    startActivity(i);
                    TaskStackBuilder stackBuilder = TaskStackBuilder.create(getApplicationContext());

// This uses android:parentActivityName and
// android.support.PARENT_ACTIVITY meta-data by default
                    stackBuilder.addNextIntentWithParentStack(i);
                    PendingIntent pendingIntent = stackBuilder
                            .getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

                    return true;


                }

                if (id == R.id.graph) {

                    Intent i = new Intent(MainActivity.this, graoh.class);
                    startActivity(i);
                    TaskStackBuilder stackBuilder = TaskStackBuilder.create(getApplicationContext());

// This uses android:parentActivityName and
// android.support.PARENT_ACTIVITY meta-data by default
                    stackBuilder.addNextIntentWithParentStack(i);
                    PendingIntent pendingIntent = stackBuilder
                            .getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

                    return true;


                }



                return true;
            }
        });

    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}