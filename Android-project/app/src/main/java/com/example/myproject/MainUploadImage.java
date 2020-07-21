package com.example.myproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainUploadImage extends AppCompatActivity {
EditText e1;
ImageView i1;
private Uri imageFilepath;
private Bitmap imageTostore;
private static final int PICK_IMAGE=100;
DataBaseHelper d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_upload_image);
        try {
            e1 = (EditText) findViewById(R.id.imageNameET);
            i1=(ImageView)findViewById(R.id.image);

            d=new DataBaseHelper(this);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void chooseImage(View v)
    {
        try{
            Intent i=new Intent();
            i.setType("image/*");
            i.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(i,PICK_IMAGE);
        }

        catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void onActivityResult(int requestcode, int resultcode, @Nullable Intent data)
    {
        try{
            super.onActivityResult(requestcode,resultcode,data);
            if(requestcode==PICK_IMAGE && resultcode==RESULT_OK && data!=null && data.getData()!=null)
            {
                imageFilepath=data.getData();
                imageTostore= MediaStore.Images.Media.getBitmap(getContentResolver(),imageFilepath);
                i1.setImageBitmap(imageTostore);
            }


        }
        catch (Exception e) {
            e.printStackTrace();
        }



    }

    public void storeImage(View v)
    {
        try{
            if(!e1.getText().toString().isEmpty() && i1.getDrawable()!=null && imageTostore!=null) {
                d.storeImage(new ModelClass(e1.getText().toString(),imageTostore));
            }
            else
            {
                Toast.makeText(getApplicationContext(),"please select image and name",Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void moveToShowActivity(View view)
    {
        startActivity(new Intent(this,ShowImagesActivity.class));
    }


}
