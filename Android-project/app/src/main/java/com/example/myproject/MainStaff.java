package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainStaff extends AppCompatActivity {
    EditText e1, e2, e3, e4, e5;
    Button b, b1, b2, b3;
    Main1 mydb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_staff);
        mydb2 = new Main1(this);
        e1 = (EditText) findViewById(R.id.editText13);
        e2 = (EditText) findViewById(R.id.editText18);
        e3 = (EditText) findViewById(R.id.editText19);
        e4 = (EditText) findViewById(R.id.editText20);
        e5 = (EditText) findViewById(R.id.editText21);
        b = (Button) findViewById(R.id.button15);
        // b1 = (Button) findViewById(R.id.button16);
        b2 = (Button) findViewById(R.id.button17);
        //b3=(Button)findViewById(R.id.button18);
       /* b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),MainStaffnext.class);
                startActivity(i);
            }
        });*/
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder;
                builder = new AlertDialog.Builder(MainStaff.this);
                builder.setTitle("change?")
                        .setMessage("Are you sure you want to update?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                String staffname = e1.getText().toString();
                                String dpt_id = e2.getText().toString();
                                String floor_no = e3.getText().toString();
                                String staff_address = e4.getText().toString();
                                String design = e5.getText().toString();

                                Boolean isupdated = mydb2.updatedata4(staffname, dpt_id, floor_no, staff_address, design);
                                if (isupdated)
                                    Toast.makeText(getApplicationContext(), "updated", Toast.LENGTH_SHORT).show();
                                else
                                    Toast.makeText(getApplicationContext(), "not updated", Toast.LENGTH_SHORT).show();


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
                String staff_name = e1.getText().toString();
                String dpt_id = e2.getText().toString();
                String block_name = e3.getText().toString();
                String staff_add = e4.getText().toString();
                String design = e5.getText().toString();
                if (staff_name.equals(" ") || dpt_id.equals(" ") || block_name.equals(" ") || staff_add.equals(" ") || design.equals(""))
                    Toast.makeText(getApplicationContext(), "please enter detailes", Toast.LENGTH_SHORT).show();
                else {
                    Boolean i = mydb2.insertdata4(staff_name, dpt_id, block_name, staff_add, design);
                    if (i)
                        Toast.makeText(getApplicationContext(), "inserted", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(getApplicationContext(), "not inserted", Toast.LENGTH_SHORT).show();


                }
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
                String staff_name = e1.getText().toString();
                Cursor res = mydb2.getAllData4(staff_name);
                if (res.getCount() == 0) {
                    // Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_SHORT).show();
                    showMessage("error", "Nothing found");
                    return;
                }

                StringBuffer buffer = new StringBuffer();
                if (res.moveToNext()) {
                    buffer.append("Staff name:" + res.getString(0) + "\n");
                    buffer.append("Dept id:" + res.getString(1) + "\n");
                    buffer.append("Block name:" + res.getString(2) + "\n");
                    buffer.append("Staff address:" + res.getString(3) + "\n");
                    buffer.append("Staff designation:"+res.getString(4));
                }


                showMessage("Data", buffer.toString());
            }
        });

    }

    public void showMessage(String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainStaff.this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();

    }*/
    }
}
