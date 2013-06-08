package com.example.ptsapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class MySQLiteHandler {
	
	MySQLiteOpenHelper helper;
	SQLiteDatabase db;
	
	public MySQLiteHandler(Context ctx){
		
		helper = new MySQLiteOpenHelper(ctx, "student1.sqlite", null, 1);
	}
	// �����ͺ��̽� open
	public static MySQLiteHandler open(Context ctx){
		return new MySQLiteHandler(ctx);
	}
	//�����ͺ��̽� close
	public  void close(){
		helper.close();
	}
	
	//������ ����
	public void insert( String name, int age, String address){
		
		db = helper.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("name", name);
		values.put("age", age);
		values.put("address", address);
		db.insert("student", null, values);
	}
   
   //������ ����
	public void update(String id, String name , String address , String age ){
		
		db = helper.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("name", name);
		values.put("address", address);
		values.put("age", age);
		db.update("student", values, "_id = ?", new String[]{ id });
		
	}
	//������ ����
	public void delete(String id){
		db = helper.getWritableDatabase();
		db.delete("student", " _id = ? ",  new String[]{ id } );
	}
	
	//������ ��ȸ
	public Cursor selectAll(){
		
		db = helper.getReadableDatabase();
		Cursor c = db.query("student", null, null, null, null, null, null);
	    return c;
	}
	
	//_id ��ġ ������ ���
	public Cursor  selectById(String _id){
			
			db = helper.getReadableDatabase();
			Cursor c = db.query("student", null, "_id = ?", new String[]{ _id }, null, null, null);
	    	return c;
	}//end select
	
}





