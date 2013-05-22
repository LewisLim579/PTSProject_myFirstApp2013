package com.example.ptsapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Distinguish extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.distinguish);
        ImageButton c1 = (ImageButton) findViewById(R.id.bbt1);

		c1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(Distinguish.this, Bmi.class);
				startActivity(intent);
			}
		});
				
		ImageButton c2 = (ImageButton) findViewById(R.id.bbt2);
        c2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(Distinguish.this, Starc.class);
				startActivity(intent);
			}
        });
    }
}
