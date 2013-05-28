package com.example.ptsapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Sa3 extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sa3);
		ImageButton s3 = (ImageButton) findViewById(R.id.imageButton1);
		s3.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(Sa3.this, How8.class);
				startActivity(intent);
			}
		});
		ImageButton s4 = (ImageButton) findViewById(R.id.imageButton2);
		s4.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(Sa3.this, How9.class);
				startActivity(intent);
			}
		});
    }
}