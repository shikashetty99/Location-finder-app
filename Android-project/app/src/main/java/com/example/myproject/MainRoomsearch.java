package com.example.myproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainRoomsearch extends AppCompatActivity {
    EditText e1,e2;
    Button b,b1;
    Main1 mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_roomsearch);
        mydb = new Main1(this);
        e1 = (EditText) findViewById(R.id.editText30);
        b = (Button) findViewById(R.id.button8);
        e2 = (EditText) findViewById(R.id.editText31);
        b1 = (Button) findViewById(R.id.button18);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String floor=e2.getText().toString();
                Toast.makeText(getApplicationContext(),floor,Toast.LENGTH_SHORT).show();
                Cursor res = mydb.getF(floor);
                if (res.getCount() == 0) {
                    // Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_SHORT).show();
                    showMessage("error", "Nothing found");
                    return;
                }

                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("Room no:" + res.getString(0) + "\n");
                }


                showMessage("Data", buffer.toString());



            }
        });



        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = e1.getText().toString();
                Cursor res = mydb.getAllData5(s);
                if (res.getCount() == 0) {
                    // Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_SHORT).show();
                    showMessage("error", "Nothing found");
                    return;
                }

                StringBuffer buffer = new StringBuffer();
                if (res.moveToNext()) {
                    buffer.append("Room No:" + res.getString(0) + "\n");
                    buffer.append("Dept id:" + res.getString(1) + "\n");
                    buffer.append("Block name:" + res.getString(2) + "\n");
                    buffer.append("Room address:" + res.getString(3) + "\n");
                    buffer.append("Present branch:" + res.getString(4) + "\n");
                }


                showMessage("Data", buffer.toString());
            }
        });

    }

    public void showMessage(String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainRoomsearch.this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();


    }
}