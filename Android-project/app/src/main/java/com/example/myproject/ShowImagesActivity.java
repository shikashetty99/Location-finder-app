package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

public class ShowImagesActivity extends AppCompatActivity {
private DataBaseHelper d;
private RecyclerView r;
private RVAdapter rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_images);
        try{
            r=findViewById(R.id.imagesRecycle);
            d=new DataBaseHelper(this);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void getData(View view)
    {
        try{

            rv=new RVAdapter(d.getAllImagesData());
            r.setHasFixedSize(true);
            r.setLayoutManager(new LinearLayoutManager(this));
            r.setAdapter(rv);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
