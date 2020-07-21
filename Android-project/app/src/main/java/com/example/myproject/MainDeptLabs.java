package com.example.myproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainDeptLabs extends AppCompatActivity {
    EditText e1, e2, e3, e4, e5;
    Button b, b1, b2, b3;
    Main1 mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dept_labs);
        mydb = new Main1(this);
        e1 = (EditText) findViewById(R.id.editText6);
        e2 = (EditText) findViewById(R.id.editText14);
        e3 = (EditText) findViewById(R.id.editText15);
        e4 = (EditText) findViewById(R.id.editText16);
        e5 = (EditText) findViewById(R.id.editText17);
        b = (Button) findViewById(R.id.button10);
       // b1 = (Button) findViewById(R.id.button11);
         b2=(Button)findViewById(R.id.button12);
       // b3 = (Button) findViewById(R.id.button13);
      /*  b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), DeptLabsnext.class);
                startActivity(i);
            }
        });*/

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.app.AlertDialog.Builder builder;
                builder=new android.app.AlertDialog.Builder(MainDeptLabs.this);
                builder.setTitle("change?")
                        .setMessage("Are you sure you want to update?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String labno=e1.getText().toString();
                                String dptid=e2.getText().toString();
                                String floorno=e3.getText().toString();
                                String labname=e4.getText().toString();
                                String labaddress=e5.getText().toString();



                                Boolean isupdated=mydb.updatedata2(labno,dptid,floorno,labname,labaddress);
                                if(isupdated)
                                    Toast.makeText(getApplicationContext(),"updated",Toast.LENGTH_SHORT).show();
                                else
                                    Toast.makeText(getApplicationContext(),"not updated",Toast.LENGTH_SHORT).show();


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

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String labno = e1.getText().toString();
                String dptid = e2.getText().toString();
                String floorno = e3.getText().toString();
                String labname = e4.getText().toString();
                String labaddress = e5.getText().toString();
                Boolean isinserted = mydb.insertdata2(labno, dptid, floorno, labname, labaddress);
                if (isinserted)
                    Toast.makeText(getApplicationContext(), "inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), "not inserted", Toast.LENGTH_SHORT).show();
                e1.getText().clear();
                e2.getText().clear();
                e3.getText().clear();
                e4.getText().clear();
                e5.getText().clear();

            }
        });


     /*   b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String lab=e1.getText().toString();
                Cursor c=mydb.getAllData2(lab);
                if(c.getCount()==0) {
                    showMessage("Error","Nothing found");
                    return;
                }

                StringBuffer buffer1=new StringBuffer();
                while (c.moveToNext())
                {
                    buffer1.append("Labno:"+c.getString(0)+"\n");
                    buffer1.append("Dept id:"+c.getString(1)+"\n");
                    buffer1.append("Floor_no:"+c.getString(2)+"\n");
                    buffer1.append("Lab name:"+c.getString(3)+"\n");
                    buffer1.append("Lab address:"+c.getString(4)+"\n\n");

                }
                showMessage("Data",buffer1.toString());
            }
        });

    }


    public void showMessage(String title,String message)
    {
        AlertDialog.Builder builder1=new AlertDialog.Builder(this);
        builder1.setCancelable(true);
        builder1.setTitle(title);
        builder1.setMessage(message);
        builder1.show();


    }*/
    }
}