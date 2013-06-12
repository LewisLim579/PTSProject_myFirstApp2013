package com.example.ptsapp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.app.AlertDialog;
import android.app.TabActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TabHost;
import android.widget.Toast;

public class schel extends TabActivity {
    /** Called when the activity is first created. */
	//DB�ű��
	public SQLiteDatabase db;
	
	
	private final String ROOT_DIR = "/data/data/com.example.PtsApp/databases/";
	private final String D_N="ch2.db";
	public void setDB() {
		  File folder = new File(ROOT_DIR+"databases");
		  if(folder.exists()) {
			 
		  }
		  else {
		   folder.mkdirs();
		   //Toast.makeText(this, "��������", Toast.LENGTH_LONG).show();
		  }

		  
		   File outfile = new File(ROOT_DIR+"databases/"+D_N); //--���� ��ġ�� ���
		   if (outfile.length() <= 0) {
			   AssetManager assetManager = getResources().getAssets();
			   try {
				    // --asset ���� �� ������ DB ����
				   InputStream is = assetManager.open(D_N, AssetManager.ACCESS_BUFFER);  
				  long  filesize = is.available();
				  byte[] tempdata = new byte[(int) filesize];
				     is.read(tempdata); 
				     is.close(); 
		     
				     outfile.createNewFile();
				     
		   FileOutputStream fo = new FileOutputStream(outfile);
		   fo.write(tempdata);
		     fo.close();    
		   
			   } catch (IOException e) { 
					  Toast.makeText(this, "db�̵�����", Toast.LENGTH_LONG).show();
				   }     
		  		     
		   //--������ ����
		     
		    // ������ ���ų� ��Ű�� ������ ��ġ�� DB������ ���Ե� DB���� ���� ũ�Ⱑ �������� ��� DB������ ���� ����.
		   
		   	}
		   }
}