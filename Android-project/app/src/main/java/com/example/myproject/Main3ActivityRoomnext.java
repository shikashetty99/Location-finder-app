package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main3ActivityRoomnext extends AppCompatActivity {
    EditText e1;
    Button b;
    Main1 mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3_roomnext);
        mydb = new Main1(this);
        e1 = (EditText) findViewById(R.id.editText29);
        b = (Button) findViewById(R.id.button21);
       /* b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = e1.getText().toString();
                Cursor res = Mydb.getAllData5(s);
                if (res.getCount() == 0) {
                    // Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_SHORT).show();
                    showMessage("error", "Nothing found");
                    return;
                }

                StringBuffer buffer = new StringBuffer();
                if (res.moveToNext()) {
                    buffer.append("Room No:" + res.getString(0) + "\n");
                }


                showMessage("Data", buffer.toString());
            }
        });

    }

    public void showMessage(String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(Main3ActivityRoomnext.this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();


    }*/

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder;
                builder = new AlertDialog.Builder(Main3ActivityRoomnext.this);
                builder.setTitle("change?")
                        .setMessage("Are you sure you want to delete?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String room = e1.getText().toString();
                                int deletedrows = mydb.deleteroom(room);
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