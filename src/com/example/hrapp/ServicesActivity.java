package com.example.hrapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class ServicesActivity extends Activity {
ImageView i1,i2,i3,i4,i5,i6;
//utton b;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_services);
		i6=(ImageView) findViewById(R.id.imageButton5);
		i5=(ImageView) findViewById(R.id.imageButton4);
		i4=(ImageView) findViewById(R.id.imageButton3);
		i3=(ImageView) findViewById(R.id.imageView1);
		i2=(ImageView) findViewById(R.id.imageButton2);
		i1=(ImageView) findViewById(R.id.imageButton1);
		i1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getApplicationContext(),BeautyActivity.class));
	        	
			}
		});
		i2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getApplicationContext(),TaxiActivity.class));
	        	
			}
		}) ;
		i3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getApplicationContext(),PlumbingActivity.class));
	        	
			}
		});
		i4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getApplicationContext(),PestActivity.class));
	        	
			}
		});
		i5.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getApplicationContext(),CleaningActivity.class));
	        	
			}
		});
		i6.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getApplicationContext(),ElectricityActivity.class));
	        		
			}
		});
		/*b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getApplicationContext(),WelcomeActivity.class));
	        	
			}
		});*/
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.services, menu);
		return true;
	}

}
