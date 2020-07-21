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

public class MainDeptRooms extends AppCompatActivity {
    EditText e1, e2, e3, e4, e5;
    Button b, b1, b2, b3;
    Main1 Mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dept_rooms);
        Mydb = new Main1(this);
        e1 = (EditText) findViewById(R.id.editText11);
        e2 = (EditText) findViewById(R.id.editText7);
        e3 = (EditText) findViewById(R.id.editText8);
        e4 = (EditText) findViewById(R.id.editText9);
        e5 = (EditText) findViewById(R.id.editText10);
        b = (Button) findViewById(R.id.button6);
        //b1 = (Button) findViewById(R.id.button8);
        b2 = (Button) findViewById(R.id.button9);
        //b3=(Button)findViewById(R.id.button20);
       /* b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Main3ActivityRoomnext.class);
                startActivity(i);
            }
        });*/


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder;
                builder = new AlertDialog.Builder(MainDeptRooms.this);
                builder.setTitle("change?")
                        .setMessage("Are you sure you want to update?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                String room_no = e1.getText().toString();
                                String dpt_id = e2.getText().toString();
                                String floor_no = e3.getText().toString();
                                String room_add = e4.getText().toString();
                                String present_branch = e5.getText().toString();

                                Boolean isupdated = Mydb.updatedata5(room_no, dpt_id, floor_no, room_add, present_branch);
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
                String room_no = e1.getText().toString();
                String dpt_id = e2.getText().toString();
                String floor_no = e3.getText().toString();
                String room_add = e4.getText().toString();
                String present_branch = e5.getText().toString();
                if (room_no.equals(" ") || dpt_id.equals(" ") || floor_no.equals(" ") || present_branch.equals(" "))
                    Toast.makeText(getApplicationContext(), "please enter detailes", Toast.LENGTH_SHORT).show();
                else {
                    Boolean i = Mydb.insertdata5(room_no, dpt_id, floor_no, room_add, present_branch);
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




   /*     b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=e1.getText().toString();
                Cursor res=Mydb.getAllData5(s1);
                if(res.getCount()==0){
                    showMessage("error","Nothing found");
                    return;
                }

                StringBuffer buffer=new StringBuffer();
                if(res.moveToNext()){
                    buffer.append("Room no:"+res.getString(0)+"\n");
                    buffer.append("Dept id:"+res.getString(1)+"\n");
                    buffer.append("Block name:"+res.getString(2)+"\n");
                    buffer.append("Room address:"+res.getString(3)+"\n");
                    buffer.append("Present branch:"+res.getString(4)+"\n");
                                  }
                showMessage("Data",buffer.toString());


            }



        });




    }

    public void showMessage(String title,String Message)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(MainDeptRooms.this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }*/

    }
}
