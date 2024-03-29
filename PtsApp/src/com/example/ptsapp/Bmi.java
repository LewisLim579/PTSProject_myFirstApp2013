package com.example.ptsapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class Bmi extends Activity {
    /** Called when the activity is first created. */
	
	private EditText t_height;
	private EditText t_weight;
	private ImageButton btn_result;
	static public double result_bmi;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi);
        
        t_height = (EditText)findViewById(R.id.height);
        t_weight = (EditText)findViewById(R.id.weight);
        btn_result = (ImageButton)findViewById(R.id.rbtn);
        

        btn_result.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(Bmi.this, Bmi_Result.class);
				double height=Integer.parseInt( t_height.getText().toString() );
        		double weight=Integer.parseInt( t_weight.getText().toString() );
        		double h2=(double)(height/100);
        		double result_bmi = weight/(h2*h2);
        		//String num=Double.toString(result_bmi);
        		String num=String.format("%.1f",result_bmi);
        		System.out.println("height = "+height);
        		System.out.println("weight = "+weight);
        		System.out.println("bm1 = "+result_bmi);
        		intent.putExtra("gogo", num);
   
        		
				startActivity(intent);
			
        	
			}
        });
    }
}
