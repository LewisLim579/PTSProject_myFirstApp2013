package com.example.ptsapp;





import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;

public class Ex07_12Activity extends Activity {
	ListView listView;
	MySQLiteHandler handler;
	ProductDBHelper mHelper;
	 Cursor c;
	 Cursor d;
	 SimpleCursorAdapter adapter;
	// SQLiteDatabase db;
	 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sun);
        
        listView = (ListView)findViewById(R.id.listView7);
        
        handler = MySQLiteHandler.open(getApplicationContext());
       
        c = handler.selectAll();
        int x=1;
        String sql="SELECT * FROM name WHERE week="+x+" AND Day='�Ͽ���'";
		d = handler.db.rawQuery(sql, null);
       // db=mHelper.getWritableDatabase();
        //d=db.rawQuery("SELECT * FROM name WHERE ������",null);
        startManagingCursor(c);
        adapter =        new SimpleCursorAdapter(
        				 getApplicationContext(),
        				 R.layout.list_row,
        				 d,
        				 new String[]{"name","Day","sets"},
        				 
        				 new int[]{  R.id.txtName, R.id.txtsets, R.id.txtDay },
        				 CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
       
        listView.setAdapter(adapter);
        
        
        // �л����� �ڼ��� ���� 
      // listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

		//@Override
		/*public void onItemClick(AdapterView<?> parent, View v, int position,
				long id) {
			TextView tv = (TextView)v.findViewById(R.id.txtId);
			
			Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
			intent.putExtra("_id", tv.getText().toString());
			startActivity(intent);
			
		}
	   });
*/
    }

	@Override
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
			
			AlertDialog.Builder builder = new AlertDialog.Builder(Ex07_12Activity.this);
			builder.setTitle("� ���� ���");
			builder.setIcon(android.R.drawable.stat_sys_warning);
			builder.setView(convertView);
			builder.setPositiveButton("�������",  new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {

					String name = editName.getText().toString();
					String Day = editDay.getText().toString();
					String sets =editsets.getText().toString();
					
					handler.insert(name,  Integer.parseInt(sets) ,Day );
					
					//�߰� ���� �ٽ� ��������
					c.requery();
					adapter.notifyDataSetChanged();
					
				}
			});
			builder.setNegativeButton("���",  null);
			builder.show();
			
			break;
			
		
			
		case R.id.preferMenu:
			Intent intent = new Intent(Ex07_12Activity.this, ShowWeek.class);
			startActivity(intent);
		
		}//end 
	   return super.onOptionsItemSelected(item);
	}
    
    
    
    
	}
    
    
    
    
    