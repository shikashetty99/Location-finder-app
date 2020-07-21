package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeptLabsnext extends AppCompatActivity {
    EditText e1;
    Button b;
    Main1 mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dept_labsnext);
        mydb = new Main1(this);
        e1 = (EditText) findViewById(R.id.editText12);
        b = (Button) findViewById(R.id.button14);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder;
                builder = new AlertDialog.Builder(DeptLabsnext.this);
                builder.setTitle("change?")
                        .setMessage("Are you sure you want to delete?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String lab = e1.getText().toString();
                                int deletedrows = mydb.deletedata2(lab);
                                if (deletedrows != 0)
                                    Toast.makeText(getApplicationContext(), "deleted", Toast.LENGTH_SHORT).show();
                                else
                                    Toast.makeText(getApplicationContext(), "no records", Toast.LENGTH_SHORT).show();


                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();


            }
        });
    }
}
