package com.example.hrapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class BeautyActivity extends Activity {
	ArrayAdapter<String> aa;
	Button b,b1;
	EditText et1,et2;
	Spinner sp;
	String be[];
	String data;
	//TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_beauty);
		et1=(EditText) findViewById(R.id.editText1);
		et2=(EditText) findViewById(R.id.editText2);
		//et3=(EditText) findViewById(R.id.editText3);
		b=(Button) findViewById(R.id.button1);
		
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String date,time;
				date=et1.getText().toString();
				time=et2.getText().toString();
				 SQLiteDatabase mydatabase = openOrCreateDatabase("mydb.dat",MODE_PRIVATE,null);
				 mydatabase.execSQL("CREATE TABLE IF NOT EXISTS Beauty( Date VARCHAR, Time VARCHAR  );");
				 mydatabase.execSQL("INSERT INTO Beauty VALUES('"+date+"','"+time+"');");
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
				startActivity(new Intent(getApplicationContext(),FeedbackActivity.class));
				
			}
		});*/
		sp=(Spinner) findViewById(R.id.spinner1);
		be=getResources().getStringArray(R.array.Beauty);
		aa= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,be);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(aa);
        sp.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				int ind=arg0.getSelectedItemPosition();
				data=be[ind];
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.beauty, menu);
		return true;
	}

}
