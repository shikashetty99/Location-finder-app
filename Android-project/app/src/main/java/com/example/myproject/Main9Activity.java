package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class Main9Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater i=getMenuInflater();
        i.inflate(R.menu.m2,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.i1:
                Intent in1 = new Intent(Main9Activity.this, MainDashboard.class);
                startActivity(in1);
                return true;
            case R.id.i2:
                Intent in2 = new Intent(Main9Activity.this, Main2Dashboard.class);
                startActivity(in2);
                return true;
            case R.id.i3:
                Intent in3 = new Intent(Main9Activity.this, Main3Dashboard.class);
                startActivity(in3);
                return true;
            case R.id.i4:
                Intent in4 = new Intent(Main9Activity.this, Main4Dashboard.class);
                startActivity(in4);
                return true;

            default:return onOptionsItemSelected(item);


        }


    }

}
