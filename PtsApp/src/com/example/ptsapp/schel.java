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
	//DB옮기기
	public SQLiteDatabase db;
	
	
	private final String ROOT_DIR = "/data/data/com.example.PtsApp/databases/";
	private final String D_N="ch2.db";
	public void setDB() {
		  File folder = new File(ROOT_DIR+"databases");
		  if(folder.exists()) {
			 
		  }
		  else {
		   folder.mkdirs();
		   //Toast.makeText(this, "폴더생성", Toast.LENGTH_LONG).show();
		  }

		  
		   File outfile = new File(ROOT_DIR+"databases/"+D_N); //--폰에 위치할 경로
		   if (outfile.length() <= 0) {
			   AssetManager assetManager = getResources().getAssets();
			   try {
				    // --asset 폴더 및 복사할 DB 지정
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
					  Toast.makeText(this, "db이동실패", Toast.LENGTH_LONG).show();
				   }     
		  		     
		   //--사이즈 검증
		     
		    // 파일이 없거나 패키지 폴더에 설치된 DB파일이 포함된 DB파일 보다 크기가 같지않을 경우 DB파일을 덮어 쓴다.
		   
		   	}
		   }
}
