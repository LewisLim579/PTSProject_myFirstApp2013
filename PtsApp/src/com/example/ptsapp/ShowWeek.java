package com.example.ptsapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ShowWeek extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showweek);
        ImageButton b1 = (ImageButton) findViewById(R.id.monday);
        ImageButton b2 = (ImageButton) findViewById(R.id.tuesday);
        ImageButton b3 = (ImageButton) findViewById(R.id.wednesday);
        ImageButton b4 = (ImageButton) findViewById(R.id.thursday);
        ImageButton b5 = (ImageButton) findViewById(R.id.friday);
        ImageButton b6 = (ImageButton) findViewById(R.id.saturday);
        ImageButton b7 = (ImageButton) findViewById(R.id.sunday);
        
		b1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(ShowWeek.this, Mon.class);
				startActivity(intent);
			}
		});
		b2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(ShowWeek.this, Tues.class);
				startActivity(intent);
			}
		});
		b3.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(ShowWeek.this, Wednes.class);
				startActivity(intent);
			}
		});
		b4.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(ShowWeek.this, Thurs.class);
				startActivity(intent);
			}
		});
		b5.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(ShowWeek.this, Fri.class);
				startActivity(intent);
			}
		});
		b6.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(ShowWeek.this, Satur.class);
				startActivity(intent);
			}
		});
		b7.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(ShowWeek.this, Sun.class);
				startActivity(intent);
			}
		});
    }
}