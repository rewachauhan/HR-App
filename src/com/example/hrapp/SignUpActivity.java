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
import android.widget.Toast;



public class SignUpActivity extends Activity {
	EditText et1,et2,et3,et4,et5;
	Button b;
	ArrayAdapter<String> aa, aa1;
	Spinner sp,sp1;
	String c1[];
	String hos[];
	String data, data1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sign_up);
		et1=(EditText) findViewById(R.id.editText1);
		
        et2=(EditText) findViewById(R.id.editText2);
        
        et3=(EditText) findViewById(R.id.editText3);
        
        et4=(EditText) findViewById(R.id.editText4);
      
        et5=(EditText) findViewById(R.id.editText5);
        
    
        //PhoneNumberUtils.formatNumber(et2.getText().toString());
      /* ph=et3.getText().toString();
        reg=et3.getText().toString();
        p=et4.getText().toString();
        r=et5.getText().toString();*/
        b=(Button) findViewById(R.id.button1);
        b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String n,p,r,ph,reg;
			    n=et1.getText().toString();	
			    ph=et3.getText().toString();
			    reg=et3.getText().toString();
			    p=et4.getText().toString();
		        r=et5.getText().toString();
		        if(n.length()==0||ph.length()==0||reg.length()==0||p.length()==0||r.length()==0)
				{
					Toast.makeText(getApplicationContext(), "please fill all fields", Toast.LENGTH_LONG).show();
					return;
				}
			   /* if(ph.length()!= 10)
		        {
		        	Toast.makeText(getApplicationContext(),"enter a valid phone no" , Toast.LENGTH_LONG).show();
		        }
		        
			    else if(reg.length()!=9)
		        {
		        	Toast.makeText(getApplicationContext(),"this reg no isn't valid" , Toast.LENGTH_LONG).show();
		        }
		        
			    else if(r.length()!=3)
		        {
		        	Toast.makeText(getApplicationContext(),"this room no isn't valid" , Toast.LENGTH_LONG).show();
		        }
			    else{*/
		        SQLiteDatabase mydatabase = openOrCreateDatabase("mydb.dat",MODE_PRIVATE,null);
				mydatabase.execSQL("CREATE TABLE IF NOT EXISTS HR(Username VARCHAR ,Phone_no VARCHAR, Reg_no VARCHAR Primary Key, Password VARCHAR,Department VARCHAR,Hostel VARCHAR, Room_no VARCHAR);");
				mydatabase.execSQL("INSERT INTO HR VALUES('"+n+"','"+ph+"','"+reg+"','"+p+"','"+data+"','"+data1+"','"+r+"');");
				Toast.makeText(getApplicationContext(),"registered successfully" , Toast.LENGTH_LONG).show();
				startActivity(new Intent(getApplicationContext(),ServicesActivity.class));
				finish();//}
			}
			
		});
        sp=(Spinner) findViewById(R.id.spinner1);
        sp1=(Spinner) findViewById(R.id.spinner2);
        c1=getResources().getStringArray(R.array.Dept);
        aa= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,c1);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(aa);
        sp.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				int ind=arg0.getSelectedItemPosition();
				data=c1[ind];
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
        
        hos=getResources().getStringArray(R.array.Hostel);
        aa1= new ArrayAdapter<String>(this,  android.R.layout.simple_spinner_item, hos);
        aa1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp1.setAdapter(aa1);
        sp1.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				int ind=arg0.getSelectedItemPosition();
				data1=hos[ind];
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
		getMenuInflater().inflate(R.menu.sign_up, menu);
		return true;
	}

}
