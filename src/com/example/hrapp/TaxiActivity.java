package com.example.hrapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TaxiActivity extends Activity {
	Button b,b1;
	EditText et1,et2,et3,et4;
	//TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_taxi);
		et1=(EditText) findViewById(R.id.editText1);
		et2=(EditText) findViewById(R.id.editText2);
		et3=(EditText) findViewById(R.id.editText3);
		et4=(EditText) findViewById(R.id.editText4);
		b=(Button) findViewById(R.id.button1);
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String date,time,from,to;
				date=et1.getText().toString();
				time=et2.getText().toString();
				from=et3.getText().toString();
				to=et4.getText().toString();
				
				/* SQLiteDatabase mydatabase = openOrCreateDatabase("mydb.dat",MODE_PRIVATE,null);
				 mydatabase.execSQL("CREATE TABLE IF NOT EXISTS Taxi( Date VARCHAR, Time VARCHAR ,From VARCHAR,To VARCHAR );");
				 mydatabase.execSQL("INSERT INTO Taxi VALUES('"+date+"','"+time+"','"+from+"','"+to+"');");*/
				 Toast.makeText(getApplicationContext(), "booked", Toast.LENGTH_LONG).show();
					
			}
		});
		b1=(Button) findViewById(R.id.button2);
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getApplicationContext(),ServicesActivity.class));
				
			}
		});
		/*tv=(TextView) findViewById(R.id.textView3);
		tv.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getApplicationContext(),FeedTActivity.class));
				
			}
		});*/
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.taxi, menu);
		return true;
	}

}
