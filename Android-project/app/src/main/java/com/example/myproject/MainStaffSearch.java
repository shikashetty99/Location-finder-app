package com.example.myproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainStaffSearch extends AppCompatActivity {
EditText e1,e2;
Button b,b1;
Main1 mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_staff_search);
        mydb=new Main1(this);
        e1=(EditText)findViewById(R.id.editText27);
        e2=(EditText)findViewById(R.id.editText28);
        b=(Button)findViewById(R.id.button13);
        b1=(Button)findViewById(R.id.button16);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String floor=e2.getText().toString();
                Toast.makeText(getApplicationContext(),floor,Toast.LENGTH_SHORT).show();
                Cursor res = mydb.getFloor4(floor);
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
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String staff = e1.getText().toString();
                Toast.makeText(getApplicationContext(), staff, Toast.LENGTH_SHORT).show();
                Cursor res = mydb.getAllData4(staff);
                if (res.getCount() == 0) {
                    // Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_SHORT).show();
                    showMessage("error", "Nothing found");
                    return;
                }

                StringBuffer buffer = new StringBuffer();
                if(res.moveToNext()) {
                    buffer.append("Staff name:" + res.getString(0) + "\n");
                    buffer.append("Dept id:" + res.getString(1) + "\n");
                    buffer.append("Floor no:" + res.getString(2) + "\n");
                    buffer.append("Staff address:" + res.getString(3) + "\n");
                    buffer.append("Staff designation:" + res.getString(4));


                   // showMessage("Data", buffer.toString());
                }
                showMessage("Data", buffer.toString());
            }
        });

    }

    public void showMessage(String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainStaffSearch.this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();

        e1.getText().clear();

    }


}

