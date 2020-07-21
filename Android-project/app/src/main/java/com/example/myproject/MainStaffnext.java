package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainStaffnext extends AppCompatActivity {
    EditText e1, e2;
    Button b, b2;
    Main1 mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_staffnext);
        mydb = new Main1(this);
        e1 = (EditText) findViewById(R.id.editText22);
        e2=(EditText)findViewById(R.id.editText23);
        b2 = (Button) findViewById(R.id.button23);
        b = (Button) findViewById(R.id.button19);


       b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder;
                builder = new AlertDialog.Builder(MainStaffnext.this);
                builder.setTitle("change?")
                        .setMessage("Are you sure you want to delete?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String staff = e1.getText().toString();
                                int deletedrows = mydb.deletedata4(staff);
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


       b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s = e2.getText().toString();

                  //  Toast.makeText(getApplicationContext(),"bt",Toast.LENGTH_SHORT).show();
                    Cursor res = mydb.getAll(s);

                    if (res.getCount() == 0) {
                        // Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_SHORT).show();
                        showMessage("error", "Nothing found");
                        return;
                    }

                    StringBuffer buffer = new StringBuffer();
                    while (res.moveToNext()) {
                        buffer.append("Staff name:" + res.getString(0) + "\n");

                    }


                    showMessage("Data", buffer.toString());

            }
        });

    }


    public void showMessage(String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainStaffnext.this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();


    }

}