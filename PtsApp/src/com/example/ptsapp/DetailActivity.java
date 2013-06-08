package com.example.ptsapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DetailActivity extends Activity {

	MySQLiteHandler handler;

	EditText editId;
	EditText editName;
	EditText editAddress;
	EditText editAge;

	Button btnUpdate;
	Button btnDelete;
	Button btnSelect;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detail);

		editId = (EditText) findViewById(R.id.editId);
		editName = (EditText) findViewById(R.id.editName);

		editAddress = (EditText) findViewById(R.id.editAddress);
		editAge = (EditText) findViewById(R.id.editAge);

		btnUpdate = (Button) findViewById(R.id.btnUpdate);
		btnDelete = (Button) findViewById(R.id.btnDelete);
		btnSelect = (Button) findViewById(R.id.btnSelect);

		Intent intent = getIntent();
		String _id = intent.getStringExtra("_id");

		handler = MySQLiteHandler.open(getApplicationContext());
		Cursor c = handler.selectById(_id);
		startManagingCursor(c);
		if (c.moveToNext()) {

			editId.setText(c.getString(c.getColumnIndex("_id")));
			editName.setText(c.getString(c.getColumnIndex("name")));
			editAddress.setText(c.getString(c.getColumnIndex("address")));
			editAge.setText(c.getString(c.getColumnIndex("age")));
		}//

		// 버튼 이벤트처리
		btnUpdate.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				showDialog(1); // update
			}
		});

		btnDelete.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				showDialog(2); // delete

			}
		});

		btnSelect.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}// end onCreate

	@Override
	protected void onPrepareDialog(int id, Dialog dialog) {

		switch (id) {

		case 2: // delete

			AlertDialog d = (AlertDialog) dialog;
			d.setTitle("삭제 작업");
			d.setMessage("정말로 삭제 합니까 ?");
			break;
		}

		super.onPrepareDialog(id, dialog);
	}

	@Override
	protected Dialog onCreateDialog(final int id) {

		AlertDialog.Builder builder = new AlertDialog.Builder(
				DetailActivity.this);
		builder.setTitle("수정 작업");
		builder.setMessage("정말로 수정합니까 ?");
		builder.setIcon(android.R.drawable.stat_sys_warning);
		builder.setPositiveButton("일정등록", new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {

				switch (id) {

				case 1: // update
					String _id = editId.getText().toString();
					String name = editName.getText().toString();
					String address = editAddress.getText().toString();
					String age = editAge.getText().toString();

					handler.update(_id, name, address, age);
					break;
				case 2: // delete

					String _id2 = editId.getText().toString();
					handler.delete(_id2);

					break;
				}// end
				finish();
			}
		});
		builder.setNegativeButton("취소", new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.dismiss();
			}
		});

		return builder.show();
	}// end onCreateDialog

}// end class