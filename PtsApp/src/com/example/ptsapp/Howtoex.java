package com.example.ptsapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Howtoex extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.howtoex);
        ImageButton sang = (ImageButton) findViewById(R.id.sangbtn);
        ImageButton ha = (ImageButton) findViewById(R.id.habtn);
        
        sang.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(Howtoex.this, Sangche.class);
				startActivity(intent);
			}
		});
        
        ha.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(Howtoex.this, Hache.class);
				startActivity(intent);
			}
		});
    }
}