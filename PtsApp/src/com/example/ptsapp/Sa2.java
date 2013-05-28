package com.example.ptsapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Sa2 extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sa2);
        ImageButton s1 = (ImageButton) findViewById(R.id.imageButton1);
		s1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(Sa2.this, How4.class);
				startActivity(intent);
			}
		});
		ImageButton s2 = (ImageButton) findViewById(R.id.imageButton2);
		s2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(Sa2.this, How5.class);
				startActivity(intent);
			}
		});
		ImageButton s3 = (ImageButton) findViewById(R.id.imageButton3);
		s3.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(Sa2.this, How6.class);
				startActivity(intent);
			}
		});
		ImageButton s4 = (ImageButton) findViewById(R.id.imageButton4);
		s4.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(Sa2.this, How7.class);
				startActivity(intent);
			}
		});
    }
}