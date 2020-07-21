package com.example.myproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class DataBaseHelper extends SQLiteOpenHelper {
    Context context;
    private static String DATABASEN="image";
    private static String createtable="create table imageinfo(image_name TEXT,image BLOB)";
    private ByteArrayOutputStream objectByteArrayOutputStream;
    private byte[] imageToByte;

    public DataBaseHelper(@Nullable Context context) {
        super(context,DATABASEN,null,1);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try{

            db.execSQL(createtable);
            Toast.makeText(context,"table created successfully",Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void storeImage(ModelClass objectModelClass)
    {
        try{
            SQLiteDatabase db=this.getWritableDatabase();
            Bitmap imageTostore=objectModelClass.getImage();
            objectByteArrayOutputStream=new ByteArrayOutputStream();
            imageTostore.compress(Bitmap.CompressFormat.JPEG,100,objectByteArrayOutputStream);
            imageToByte=objectByteArrayOutputStream.toByteArray();
            ContentValues contentValues=new ContentValues();
            contentValues.put("image_name",objectModelClass.getImageName());
            contentValues.put("image",imageToByte);
            long i=db.insert("imageinfo",null,contentValues);
            if(i!=-1) {
                Toast.makeText(context, "Image added", Toast.LENGTH_SHORT).show();
                db.close();
            }
            else
                Toast.makeText(context,"image not added",Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<ModelClass> getAllImagesData()
    {
        try{

           SQLiteDatabase db=this.getReadableDatabase();
           ArrayList<ModelClass> objectModelClassList=new ArrayList<>();
           Cursor cursor=db.rawQuery("select * from imageinfo",null);
           if(cursor.getCount()!=0)
           {
               while(cursor.moveToNext())
               {
                   String name=cursor.getString(0);
                   byte[] imageBytes=cursor.getBlob(1);
                   Bitmap objectBitmap= BitmapFactory.decodeByteArray(imageBytes,0,imageBytes.length);
                   objectModelClassList.add(new ModelClass(name,objectBitmap));
               }
               return objectModelClassList;
           }
           else

               Toast.makeText(context,"no records",Toast.LENGTH_SHORT).show();
               return null;

        } catch (Exception e) {

            return null;
        }

    }
}
