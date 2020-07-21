package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
EditText e5;
Button b5;
Main1 mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mydb = new Main1(this);
        e5=(EditText)findViewById(R.id.editText5);
        b5=(Button)findViewById(R.id.button5);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id=e5.getText().toString();
                int deletedrows=mydb.deletedata(id);
                if(deletedrows!=0)
                Toast.makeText(getApplicationContext(),"deleted",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(),"no records",Toast.LENGTH_SHORT).show();

            }
        });
    }
}
