package com.example.ptsapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Sa1 extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sa1);
        ImageButton s1 = (ImageButton) findViewById(R.id.sa11);
		s1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(Sa1.this, How1.class);
				startActivity(intent);
			}
		});
		ImageButton s2 = (ImageButton) findViewById(R.id.sa22);
		s2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(Sa1.this, How2.class);
				startActivity(intent);
			}
		});
		ImageButton s3 = (ImageButton) findViewById(R.id.sa33);
		s3.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(Sa1.this, How3.class);
				startActivity(intent);
			}
		});
    }
}