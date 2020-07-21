package com.example.myproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainLabsActivity extends AppCompatActivity {
EditText e1,e2;
Button b,b1;
Main1 mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_labs);
        mydb=new Main1(this);
        e1=(EditText)findViewById(R.id.editText25);
        e2=(EditText)findViewById(R.id.editText26);
        b=(Button)findViewById(R.id.button4);
        b1=(Button)findViewById(R.id.button11);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String floor=e2.getText().toString();
                Cursor c=mydb.getFloor(floor);
                if(c.getCount()==0) {
                    showMessage("Error","Nothing found");
                    return;
                }

                StringBuffer buffer1=new StringBuffer();
                while (c.moveToNext())
                {
                    buffer1.append("Labno:"+c.getString(0)+"\n");


                }
                showMessage("Data",buffer1.toString());





            }
        });



        b.setOnClickListener(new View.OnClickListener() {
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
                    buffer1.append("Floor no:"+c.getString(2)+"\n");
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



}


}
