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

public class MainActivity extends AppCompatActivity {
EditText e1,e2,e3,e4,e5;
Button b,b1,b2,b3,b4,b7;
Main1 Mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Mydb = new Main1(this);
        e1 = (EditText) findViewById(R.id.editText);
        e2 = (EditText) findViewById(R.id.editText2);
        e3 = (EditText) findViewById(R.id.editText3);
        e4 = (EditText) findViewById(R.id.editText4);

        b = (Button) findViewById(R.id.button);
        // b1=(Button)findViewById(R.id.button2);
        b2 = (Button) findViewById(R.id.button3);
        // b3=(Button)findViewById(R.id.button4);
       // b4 = (Button) findViewById(R.id.button7);
       /* b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainStaff.class);
                startActivity(i);
            }
        });*/

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dept_id = e1.getText().toString();
                String floor_no = e2.getText().toString();
                int floor_no1 = Integer.parseInt(floor_no);

                String no_of_rooms = e3.getText().toString();
                int no_of_rooms1 = Integer.parseInt(no_of_rooms);


                String dept_head = e4.getText().toString();
                if(dept_id.equals(" ")||floor_no.equals("")||no_of_rooms.equals("")||dept_head.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Please enter all fields",Toast.LENGTH_SHORT).show();
                }
                else {
                    Boolean isinserted = Mydb.insertdata(dept_id, floor_no1, no_of_rooms1, dept_head);
                    if (isinserted)
                        Toast.makeText(getApplicationContext(), "inserted", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(getApplicationContext(), "not inserted", Toast.LENGTH_LONG).show();
                }

                e1.getText().clear();
                e2.getText().clear();
                e3.getText().clear();
                e4.getText().clear();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {






                AlertDialog.Builder builder;
                builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("change?")
                        .setMessage("Are you sure you want to update?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                String dept_id = e1.getText().toString();
                                String floor_no = e2.getText().toString();
                                int floor_no1 = Integer.parseInt(floor_no);
                                String no_of_rooms = e3.getText().toString();
                                int no_of_rooms1 = Integer.parseInt(no_of_rooms);
                                String dept_head = e4.getText().toString();

                                if(dept_id.equals(" ")||floor_no.equals("")||no_of_rooms.equals("")||dept_head.equals(""))
                                {
                                    Toast.makeText(getApplicationContext(),"Please enter all fields",Toast.LENGTH_SHORT).show();
                                }
                                else {


                                    Boolean isupdated = Mydb.updatedata(dept_id, floor_no1, no_of_rooms1, dept_head);
                                    if (isupdated)
                                        Toast.makeText(getApplicationContext(), "updated", Toast.LENGTH_SHORT).show();
                                    else
                                        Toast.makeText(getApplicationContext(), "not updated", Toast.LENGTH_SHORT).show();

                                }
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


/*b3.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent i=new Intent(getApplicationContext(),Main2Activity.class);
        startActivity(i);

    }
});*/




/*        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=e1.getText().toString();
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
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();


    }*/


    }
}
