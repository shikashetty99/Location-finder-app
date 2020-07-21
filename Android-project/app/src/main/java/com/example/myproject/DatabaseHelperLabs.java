package com.example.myproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelperLabs extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="college1.db";
    public static final String TABLE3="DeptLabs1";
    public static final String COL_1="lab_no";
    public static final String COL_2="dpt1_id";
    public static final String COL_3="floor_no";
    public static final String COL_4="lab_name";
    public static final String COL_5="lab_address";

    public DatabaseHelperLabs(@Nullable Context context) {
        super(context,DATABASE_NAME,null,1);
        SQLiteDatabase db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+TABLE3+"(lab_no TEXT primary key,dpt1_id TEXT,floor_no TEXT,lab_name TEXT,lab_address TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+TABLE3);
        onCreate(db);

    }

    public boolean insertdata5(String lab_no,String dpt1_id,String floor_no,String lab_name,String lab_address)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_1,lab_no);
        contentValues.put(COL_2,dpt1_id);
        contentValues.put(COL_3,floor_no);
        contentValues.put(COL_4,lab_name);
        contentValues.put(COL_5,lab_address);
       long i= db.insert(TABLE3,null,contentValues);
        if(i!=0)
            return true;
        else
            return false;


    }

    public Cursor getAllData5(String s)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res4=db.rawQuery("select * from DeptLabs1 where lab_no='"+s+"'",null);
        return res4;

    }



    public boolean updatedata5(String lab_no,String dpt1_id,String floor_no,String lab_name,String lab_address)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_1,lab_no);
        contentValues.put(COL_2,dpt1_id);
        contentValues.put(COL_3,floor_no);
        contentValues.put(COL_4,lab_name);
        contentValues.put(COL_5,lab_address);
        db.update(TABLE3,contentValues,"lab_no=?",new String[]{lab_no});
        return true;


    }

    public Integer deletedata5(String id){
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(TABLE3,"lab_no = ?",new String[] {id});
    }



}
