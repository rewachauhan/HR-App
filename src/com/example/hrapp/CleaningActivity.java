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

public class CleaningActivity extends Activity {
	Button b,b1;
	EditText et1,et2;
	//TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cleaning);
		et1=(EditText) findViewById(R.id.editText1);
		et2=(EditText) findViewById(R.id.editText2);
		b=(Button) findViewById(R.id.button1);
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String date,time;
				date=et1.getText().toString();
				time=et2.getText().toString();
				SQLiteDatabase mydatabase = openOrCreateDatabase("mydb.dat",MODE_PRIVATE,null);
				 mydatabase.execSQL("CREATE TABLE IF NOT EXISTS Clean( Date VARCHAR, Time VARCHAR );");
				 mydatabase.execSQL("INSERT INTO Clean VALUES('"+date+"','"+time+"');");
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
				startActivity(new Intent(getApplicationContext(),FeedCActivity.class));
				
			}
		});*/
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cleaning, menu);
		return true;
	}

}
