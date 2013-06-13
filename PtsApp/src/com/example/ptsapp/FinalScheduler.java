package com.example.ptsapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class FinalScheduler extends Activity {
	static int weekk=1;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fschedule);
		ImageButton b1 = (ImageButton) findViewById(R.id.todayexercise);
		ImageButton b2 = (ImageButton) findViewById(R.id.showweek);
		ImageButton b3 = (ImageButton) findViewById(R.id.selectweek);
		registerForContextMenu(b3);
		 

	 
		
		b1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(FinalScheduler.this, Ex07_06Activity.class);
				startActivity(intent);
			}
		});
		b2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(FinalScheduler.this, ShowWeek.class);
				startActivity(intent);
			}
		});

    }
    
    public boolean onCreateOptionsMenu(Menu menu) {
    	
		   MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mymenu, menu); 
        return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
switch( item.getItemId() ){
		
		case R.id.addMenu:
			
			LayoutInflater inf = getLayoutInflater();
			View convertView = inf.inflate(R.layout.studentadd, null);
			
		final	EditText  editName = (EditText)convertView.findViewById(R.id.editName);
		final	EditText editDay = (EditText)convertView.findViewById(R.id.editDay);
		final	EditText editsets = (EditText)convertView.findViewById(R.id.editsets);
			
			AlertDialog.Builder builder = new AlertDialog.Builder(FinalScheduler.this);
			builder.setTitle("운동 일정 등록");
			builder.setIcon(android.R.drawable.stat_sys_warning);
			builder.setView(convertView);
			builder.setPositiveButton("일정등록",  new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {

					String name = editName.getText().toString();
					String Day = editDay.getText().toString();
					String sets =editsets.getText().toString();
					
					
				}
			});
			builder.setNegativeButton("취소",  null);
			builder.show();
			
			break;
			
		
			
		case R.id.preferMenu:
			Intent intent = new Intent(FinalScheduler.this, MainMenu.class);
			startActivity(intent);
		
		}//end 
	   return super.onOptionsItemSelected(item);
	}
    public boolean onContextItemSelected(MenuItem item) {
    	// TODO Auto-generated method stub
    	switch(item.getItemId()){
    	case 1:
    		weekk = 1;
    		return true;
    	case 2:
    		weekk = 2;
    		return true;
    	case 3:
    		weekk = 3;
    		return true;
    	case 4:
    		weekk = 4;
    		return true;
    	}
    	return false;
    }
    public void onCreateContextMenu(ContextMenu menu, View v,
            ContextMenu.ContextMenuInfo menuInfo)
 {
		// TODO Auto-generated method stub
		
		menu.setHeaderTitle("주차선택");
		menu.add(0, 1, 0, "1");
		menu.add(0, 2, 0, "2");
		menu.add(0, 3, 0, "3");
		menu.add(0, 4, 0, "4");
	}
 
}