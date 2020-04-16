package com.example.hrapp;

import org.w3c.dom.Text;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.RatingBar.OnRatingBarChangeListener;

public class FeedPeActivity extends Activity {
	EditText et1;
	Button b,b1;
	TextView tv;
	private RatingBar ratingbar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_feed_pe);
		et1=(EditText) findViewById(R.id.editText1);
		String f;
		f=et1.getText().toString();
		ratingbar=(RatingBar) findViewById(R.id.ratingBar1);
        ratingbar.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
			
			@Override
			public void onRatingChanged(RatingBar arg0, float arg1, boolean arg2) {
				// TODO Auto-generated method stub
				dorating(ratingbar);
			}
		});
        b=(Button) findViewById(R.id.button1);
        b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "submitted", Toast.LENGTH_LONG).show();
				
			}
		});
        b1=(Button) findViewById(R.id.button2);
        b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getApplicationContext(),PestActivity.class));
				
			}
		});
        tv=(TextView) findViewById(R.id.textView4);
        tv.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent callIntent=new Intent(Intent.ACTION_CALL);
				callIntent.setData(Uri.parse("tel:+918210409877"));
				startActivity(callIntent);
			
			}
		});
	}
	public void dorating(View v){
    	float rate=ratingbar.getRating();
    	SQLiteDatabase mydatabase = openOrCreateDatabase("mydb.dat",MODE_PRIVATE,null);
		mydatabase.execSQL("CREATE TABLE IF NOT EXISTS Rate(Rating Decimal);");
		mydatabase.execSQL("INSERT INTO Rate VALUES('"+rate+"');");
    	Toast.makeText(this, String.valueOf(rate), Toast.LENGTH_SHORT).show();
    	
    }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.feed_pe, menu);
		return true;
	}

}
