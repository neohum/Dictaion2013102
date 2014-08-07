package com.honeyv.dictation2013102;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

import com.honeyv.dictation2013102.R;

public class SubActivity extends Activity {	
	TextView tv;
	String text;

	ImageButton imgbtn1;
	ImageButton imgbtn2;
	ImageButton imgbtn3;
	ImageButton imgbtn4;
	ImageButton imgbtn5;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		setContentView(R.layout.activity_sub);

		// TODO Auto-generated method stub

        this.init();
	}
	
	public void init(){
		imgbtn1 = (ImageButton) findViewById(R.id.imageButton1);
		imgbtn2 = (ImageButton) findViewById(R.id.imageButton2);
		imgbtn3 = (ImageButton) findViewById(R.id.imageButton3);
		imgbtn4 = (ImageButton) findViewById(R.id.imageButton4);
		imgbtn5 = (ImageButton) findViewById(R.id.imageButton5);
		
        tv = (TextView)findViewById(R.id.textTitle);
        Intent intent =getIntent();
        text = intent.getStringExtra("test");
        
        tv.setText(text);		
	}
		
	@Override
	protected void onDestroy(){
		super.onDestroy();
	}

	public void mOnClick(View v){
		switch(v.getId()){
		case R.id.ib_reading:
			Intent intentReading = new Intent(SubActivity.this, ReadingActivity.class);
			intentReading.putExtra("test", text);
			intentReading.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
			startActivity(intentReading);
			break;
			
		case R.id.ib_first_writing:
			Intent intentFirstWriting = new Intent(SubActivity.this, FirstWritingActivity.class);
			intentFirstWriting.putExtra("test", text);
			intentFirstWriting.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
			startActivity(intentFirstWriting);
			break;
			
		case R.id.ib_second_writing:
			Intent intentSecondWriting = new Intent(SubActivity.this, SecondWritingActivity.class);
			intentSecondWriting.putExtra("test", text);
			intentSecondWriting.putExtra("test2", "h");
			intentSecondWriting.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
			startActivity(intentSecondWriting);
			break;
			
		case R.id.ib_third_writing:
			Intent intentThirdWriting = new Intent(SubActivity.this, ThirdWritingActivity.class);
			intentThirdWriting.putExtra("test", text);
			intentThirdWriting.putExtra("test2", "k");
			intentThirdWriting.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
			startActivity(intentThirdWriting);
			break;
			
		case R.id.ib_check:
			Intent intentCheck = new Intent(SubActivity.this, CheckActivity.class);
			intentCheck.putExtra("test", text);
			intentCheck.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
			startActivity(intentCheck);
			break;
		}
	}

}
