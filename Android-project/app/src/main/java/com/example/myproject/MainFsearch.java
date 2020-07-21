package com.example.myproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainFsearch extends AppCompatActivity {
EditText e1;
Button b;
Main1 Mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Mydb = new Main1(this);
        setContentView(R.layout.activity_main_fsearch);
        e1=(EditText)findViewById(R.id.editText24);
        b=(Button)findViewById(R.id.button2);
             b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=e1.getText().toString();
                Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT).show();
                Cursor res = Mydb.getAlldata(s);
                if (res.getCount() == 0) {
                    // Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_SHORT).show();
                    showMessage("error", "Nothing found");
                    return;
                }

                StringBuffer buffer = new StringBuffer();
                    if(res.moveToNext()) {
                        buffer.append("DeptId:" + res.getString(0) + "\n");
                        buffer.append("Floorno:" + res.getString(1) + "\n");
                        buffer.append("No of rooms:" + res.getString(2) + "\n");
                        buffer.append("Depthead:" + res.getString(3) + "\n\n");
                    }



                showMessage("Data", buffer.toString());
            }
        });

    }

    public void showMessage(String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainFsearch.this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();


    }


    }
