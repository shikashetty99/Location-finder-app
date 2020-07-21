package com.example.myproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelperRoom extends SQLiteOpenHelper {
    public static final String DATABASE="college.db";
    public static final String TABLE2="DeptRooms";

    public static final String COL_1="room_no";
    public static final String COL_2="dpt_id";
    public static final String COL_3="block_name";
    public static final String COL_4="room_add";
    public static final String COL_5="present_branch";

    public DatabaseHelperRoom(@Nullable Context context) {
        super(context,DATABASE,null,1);
        SQLiteDatabase db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE2 + "(room_no TEXT primary key,dpt_id TEXT, block_name TEXT,room_add,TEXT,present_branch TEXT,FOREIGN KEY(dpt_id) REFERENCES Dept(dept_id))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+TABLE2);
        onCreate(db);

    }
    public boolean insertdata1(String room_no,String dpt_id,String block_name,String room_add,String present_branch)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_1,room_no);
        contentValues.put(COL_2,dpt_id);
        contentValues.put(COL_3,block_name);
        contentValues.put(COL_4,room_add);
        contentValues.put(COL_5,present_branch);
        long i=db.insert(TABLE2,null,contentValues);
        if(i!=0)
            return true;
        else
            return false;

    }
    public Cursor getAllData1(String s)
    {
        SQLiteDatabase db=this.getWritableDatabase();
       //Cursor res2=db.rawQuery("select * from "+TABLE2+" where room_no='"+room_no+"'",null);
       // Cursor res2=db.rawQuery("select * from DeptRooms",null);
        Cursor res2=db.rawQuery("select * from DeptRooms where room_no='"+s+"'" ,null);
        return res2;

    }



    public boolean updatedata(String room_no,String dept_id,String block_name,String room_add,String present_branch)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_1,room_no);
        contentValues.put(COL_2,dept_id);
        contentValues.put(COL_3,block_name);
        contentValues.put(COL_4,room_add);
        contentValues.put(COL_5,present_branch);
        db.update(TABLE2,contentValues,"room_no=?",new String[]{room_no});
        return true;


    }



}
