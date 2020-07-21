package com.example.myproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class Main1 extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "college18";
    public static final String TABLE_NAME1 = "Dept";

    public static final String TABLE3="DeptLabs1";
    public static final String TABLE4="Staffroom1";


    public static final String TABLE2="DeptRooms";

    public static final String COL_61="room_no";
    public static final String COL_62="dpt_id";
    public static final String COL_63="floor_no";
    public static final String COL_64="room_add";
    public static final String COL_65="present_branch";







    public static final String COL_11="lab_no";
    public static final String COL_21="dpt1_id";
    public static final String COL_31="floor_no";
    public static final String COL_41="lab_name";
    public static final String COL_51="lab_address";



    public static final String COL_1 = "dept_id";
    public static final String COL_2 = "floor_no";
    public static final String COL_3 = "no_of_rooms";
    public static final String COL_4 = "dept_head";




    public static final String COL_42="staff_name";
    public static final String COL_43="dpt_id";
    public static final String COL_44="block_name";
    public static final String COL_45="staff_address";
    public static final String COL_46="design";






    public Main1(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME1 + "(dept_id TEXT primary key,floor_no INTEGER,no_of_rooms INTEGER,dept_head TEXT)");
        db.execSQL("create table "+TABLE3+"(lab_no TEXT primary key,dpt1_id TEXT,floor_no TEXT,lab_name TEXT,lab_address TEXT)");
        db.execSQL("create table "+TABLE4+"(staff_name TEXT primary key,dpt_id TEXT,block_name TEXT,staff_address TEXT,design TEXT)");
        db.execSQL("create table " + TABLE2 + "(room_no TEXT primary key,dpt_id TEXT, floor_no TEXT,room_add TEXT,present_branch TEXT)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME1);
       // onCreate(db);
    }

    public boolean insertdata(String dept_id, int floor_no,int no_of_rooms, String dept_head) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, dept_id);
        contentValues.put(COL_2, floor_no);
        contentValues.put(COL_3, no_of_rooms);
        contentValues.put(COL_4, dept_head);
        long result = db.insert(TABLE_NAME1, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAlldata(String s)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res1=db.rawQuery("select * from Dept where dept_id LIKE '%"+s+"%'" ,null);
        return res1;



    }


    public boolean updatedata(String deptid,int floorno,int noofrooms,String depthead)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_1,deptid);
        contentValues.put(COL_2,floorno);
        contentValues.put(COL_3,noofrooms);
        contentValues.put(COL_4,depthead);
        db.update(TABLE_NAME1,contentValues,"dept_id=?",new String[]{deptid});
        return true;


    }

    public Integer deletedata(String id){
        SQLiteDatabase db=this.getWritableDatabase();
       return db.delete(TABLE_NAME1,"dept_id = ?",new String[] {id});
    }


    public boolean insertdata2(String lab_no,String dpt1_id,String floor_no,String lab_name,String lab_address)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_11,lab_no);
        contentValues.put(COL_21,dpt1_id);
        contentValues.put(COL_31,floor_no);
        contentValues.put(COL_41,lab_name);
        contentValues.put(COL_51,lab_address);
        long i= db.insert(TABLE3,null,contentValues);
        if(i!=0)
            return true;
        else
            return false;


    }

    public Cursor getAllData2(String s)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res4=db.rawQuery("select * from DeptLabs1 where lab_no like '%"+s+"%'",null);
        return res4;

    }


    public Cursor getFloor(String s)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res4=db.rawQuery("select * from DeptLabs1 where floor_no='"+s+"'",null);
        return res4;

    }



    public boolean updatedata2(String lab_no,String dpt1_id,String floor_no,String lab_name,String lab_address)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_11,lab_no);
        contentValues.put(COL_21,dpt1_id);
        contentValues.put(COL_31,floor_no);
        contentValues.put(COL_41,lab_name);
        contentValues.put(COL_51,lab_address);
        db.update(TABLE3,contentValues,"lab_no=?",new String[]{lab_no});
        return true;


    }

    public Integer deletedata2(String id){
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(TABLE3,"lab_no = ?",new String[] {id});
    }



    public boolean insertdata4(String staff_name,String dpt_id,String block_name,String staff_address,String design)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_42,staff_name);
        contentValues.put(COL_43,dpt_id);
        contentValues.put(COL_44,block_name);
        contentValues.put(COL_45,staff_address);
        contentValues.put(COL_46,design);
        long i= db.insert(TABLE4,null,contentValues);
        if(i==-1)
            return false;
        else
            return true;


    }



    public Cursor getAllData4(String s)
    {
        SQLiteDatabase db=this.getWritableDatabase();
       // Cursor res=db.rawQuery("select * from Staffroom1 where staff_name='"+s+"'",null);

      Cursor res=db.rawQuery("SELECT * FROM STAFFROOM1 WHERE staff_name like '%"+s+"%'",null);
        return res;

    }


    public Cursor getFloor4(String s)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res4=db.rawQuery("select * from Staffroom1 where block_name='"+s+"'",null);
        return res4;

    }

    public boolean updatedata4(String staff_name,String dpt_id,String floor_no,String staff_address,String design)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_42,staff_name);
        contentValues.put(COL_43,dpt_id);
        contentValues.put(COL_44,floor_no);
        contentValues.put(COL_45,staff_address);
        contentValues.put(COL_46,design);
        db.update(TABLE3,contentValues,"staff_name=?",new String[]{staff_name});
        return true;


    }


    public Integer deletedata4(String id){
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(TABLE4,"staff_name = ?",new String[] {id});
    }



    public boolean insertdata5(String room_no,String dpt_id,String floor_no,String room_add,String present_branch)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_61,room_no);
        contentValues.put(COL_62,dpt_id);
        contentValues.put(COL_63,floor_no);
        contentValues.put(COL_64,room_add);
        contentValues.put(COL_65,present_branch);
        long i=db.insert(TABLE2,null,contentValues);
        if(i==-1)
            return false;
        else
            return true;

    }


    public Cursor getAllData5(String s)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res2=db.rawQuery("select * from DeptRooms where room_no like '%"+s+"%'" ,null);
        return res2;

    }
    public Cursor getF(String s)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res2=db.rawQuery("select * from DeptRooms where floor_no='"+s+"'" ,null);
        return res2;

    }




    public boolean updatedata5(String room_no,String dept_id,String block_name,String room_add,String present_branch)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_61,room_no);
        contentValues.put(COL_62,dept_id);
        contentValues.put(COL_63,block_name);
        contentValues.put(COL_64,room_add);
        contentValues.put(COL_65,present_branch);
        db.update(TABLE2,contentValues,"room_no=?",new String[]{room_no});
        return true;


    }


    public Integer deleteroom(String id){
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(TABLE2,"room_no = ?",new String[] {id});
    }



    public Cursor getAll(String s)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor c=null;
        if(s.equals("BT"))
        c = db.rawQuery("select staff_name from Staffroom1 where dpt_id like 'BT'", null);
        if(s.equals("CS"))
            c = db.rawQuery("select staff_name from Staffroom1 where dpt_id like 'CS'", null);
        if(s.equals("IS"))
            c = db.rawQuery("select staff_name from Staffroom1 where dpt_id like 'IS'", null);
        if(s.equals("ME"))
            c = db.rawQuery("select staff_name from Staffroom1 where dpt_id like 'ME'", null);
        if(s.equals("CV"))
            c = db.rawQuery("select staff_name from Staffroom1 where dpt_id like 'CV'", null);
        if(s.equals("EC"))
            c = db.rawQuery("select staff_name from Staffroom1 where dpt_id like 'EC'", null);
        if(s.equals("EE"))
            c = db.rawQuery("select staff_name from Staffroom1 where dpt_id like 'EE'", null);
        return c;


    }




}


