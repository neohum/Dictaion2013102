package com.honeyv.dictation2013102;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;


public class MainActivity extends Activity {
	ImageButton ib_check;
	
	ImageButton imgbtn1;
	ImageButton imgbtn2;
	ImageButton imgbtn3;
	ImageButton imgbtn4;
	ImageButton imgbtn5;
	ImageButton imgbtn6;
	ImageButton imgbtn7;
	ImageButton imgbtn8;
	ImageButton imgbtn9;
	ImageButton imgbtn10;
	ImageButton imgbtn11;
	ImageButton imgbtn12;
	ImageButton imgbtn13;
	ImageButton imgbtn14;
	ImageButton imgbtn15;
	ImageButton imgbtn16;
	ImageButton imgbtn17;
	ImageButton imgbtn18;
	ImageButton imgbtn19;
	
	private String encoding = "UTF-8";
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        
        init();

    }
    
    public void init(){
    	ib_check = (ImageButton) findViewById(R.id.ib_timer);
		imgbtn1 = (ImageButton) findViewById(R.id.imageButton1);
		imgbtn2 = (ImageButton) findViewById(R.id.imageButton2);
		imgbtn3 = (ImageButton) findViewById(R.id.imageButton3);
		imgbtn4 = (ImageButton) findViewById(R.id.imageButton4);
		imgbtn5 = (ImageButton) findViewById(R.id.imageButton5);
		imgbtn6 = (ImageButton) findViewById(R.id.imageButton6);
		imgbtn7 = (ImageButton) findViewById(R.id.imageButton7);
		imgbtn8 = (ImageButton) findViewById(R.id.imageButton8);
		imgbtn9 = (ImageButton) findViewById(R.id.imageButton9);
		imgbtn10 = (ImageButton) findViewById(R.id.imageButton10);
		imgbtn11 = (ImageButton) findViewById(R.id.imageButton11);
		imgbtn12 = (ImageButton) findViewById(R.id.imageButton12);
		imgbtn13 = (ImageButton) findViewById(R.id.imageButton13);
		imgbtn14 = (ImageButton) findViewById(R.id.imageButton14);   
		imgbtn15 = (ImageButton) findViewById(R.id.imageButton15);
		imgbtn16 = (ImageButton) findViewById(R.id.imageButton16);
		imgbtn17 = (ImageButton) findViewById(R.id.imageButton17);
		imgbtn18 = (ImageButton) findViewById(R.id.imageButton18);
		imgbtn19 = (ImageButton) findViewById(R.id.imageButton19);
    }
    
    public void mOnClick(View v){
    	switch (v.getId()){
    	case R.id.imageButton1:
			Intent intent = new Intent(MainActivity.this, SubActivity.class);
			intent.putExtra("test", "1");
			startActivity(intent);
			break;

    	case R.id.imageButton2:
			Intent intent2 = new Intent(MainActivity.this, SubActivity.class);
			intent2.putExtra("test", "2");
			startActivity(intent2);
			break;
    	
    	case R.id.imageButton3:
			Intent intent3 = new Intent(MainActivity.this, SubActivity.class);
			intent3.putExtra("test", "3");
			startActivity(intent3);
			break;
    	
    	case R.id.imageButton4:
			Intent intent4 = new Intent(MainActivity.this, SubActivity.class);
			intent4.putExtra("test", "4");
			startActivity(intent4);
			break;
    	
    	case R.id.imageButton5:
			Intent intent5 = new Intent(MainActivity.this, SubActivity.class);
			intent5.putExtra("test", "5");
			startActivity(intent5);
			break;
    	
    	case R.id.imageButton6:
			Intent intent6 = new Intent(MainActivity.this, SubActivity.class);
			intent6.putExtra("test", "6");
			startActivity(intent6);
			break;
    	
    	case R.id.imageButton7:
			Intent intent7 = new Intent(MainActivity.this, SubActivity.class);
			intent7.putExtra("test", "7");
			startActivity(intent7);
			break;
    	
    	case R.id.imageButton8:
			Intent intent8 = new Intent(MainActivity.this, SubActivity.class);
			intent8.putExtra("test", "8");
			startActivity(intent8);
			break;
    	
    	case R.id.imageButton9:
			Intent intent9 = new Intent(MainActivity.this, SubActivity.class);
			intent9.putExtra("test", "9");
			startActivity(intent9);
			break;
    	
    	case R.id.imageButton10:
			Intent intent10 = new Intent(MainActivity.this, SubActivity.class);
			intent10.putExtra("test", "10");
			startActivity(intent10);
			break;
    	
    	case R.id.imageButton11:
			Intent intent11 = new Intent(MainActivity.this, SubActivity.class);
			intent11.putExtra("test", "11");
			startActivity(intent11);
			break;
    	
    	case R.id.imageButton12:
			Intent intent12 = new Intent(MainActivity.this, SubActivity.class);
			intent12.putExtra("test", "12");
			startActivity(intent12);
			break;
    	
    	case R.id.imageButton13:
			Intent intent13 = new Intent(MainActivity.this, SubActivity.class);
			intent13.putExtra("test", "13");
			startActivity(intent13);
			break;
    	
    	case R.id.imageButton14:
			Intent intent14 = new Intent(MainActivity.this, SubActivity.class);
			intent14.putExtra("test", "14");
			startActivity(intent14);
			break;
			
    	case R.id.imageButton15:
			Intent intent15 = new Intent(MainActivity.this, SubActivity.class);
			intent15.putExtra("test", "15");
			startActivity(intent15);
			break;
			
    	case R.id.imageButton16:
			Intent intent16 = new Intent(MainActivity.this, SubActivity.class);
			intent16.putExtra("test", "16");
			startActivity(intent16);
			break;
			
    	case R.id.imageButton17:
			Intent intent17 = new Intent(MainActivity.this, SubActivity.class);
			intent17.putExtra("test", "17");
			startActivity(intent17);
			break;
			
    	case R.id.imageButton18:
			Intent intent18 = new Intent(MainActivity.this, SubActivity.class);
			intent18.putExtra("test", "18");
			startActivity(intent18);
			break;
			
    	case R.id.imageButton19:
			Intent intent19 = new Intent(MainActivity.this, SubActivity.class);
			intent19.putExtra("test", "19");
			startActivity(intent19);
			break;
			
    	case R.id.ib_timer:
    		Intent intent20 = new Intent(MainActivity.this, ResultActivity.class);
    		startActivity(intent20);
    		break;
    	}
    }
    
    /**
   	 * Send App data - 카카오톡을 통한 앱 공유 소스 시작
   	 */
   	public void sendAppData(View v) throws NameNotFoundException {
   		ArrayList<Map<String, String>> metaInfoArray = new ArrayList<Map<String, String>>();

   		// If application is support Android platform.
   		Map<String, String> metaInfoAndroid = new Hashtable<String, String>(1);
   		metaInfoAndroid.put("os", "android");
   		metaInfoAndroid.put("devicetype", "phone");
   		metaInfoAndroid.put("installurl", "market://details?id=com.honeyv.dictation2013102");
   		metaInfoAndroid.put("executeurl", "dictation2013102://IntroActivity");
   		
   		// If application is support ios platform.
   		Map<String, String> metaInfoIOS = new Hashtable<String, String>(1);
   		metaInfoIOS.put("os", "ios");
   		metaInfoIOS.put("devicetype", "phone");
   		metaInfoIOS.put("installurl", "your iOS app install url");
   		metaInfoIOS.put("executeurl", "kakaoLinkTest://starActivity");
   		
   		// add to array
   		metaInfoArray.add(metaInfoAndroid);
   		metaInfoArray.add(metaInfoIOS);
   		
   		// Recommended: Use application context for parameter. 
   		KakaoLink kakaoLink = KakaoLink.getLink(getApplicationContext());
   		
   		// check, intent is available.
   		if(!kakaoLink.isAvailableIntent()) {
   			alert("Not installed KakaoTalk.");			
   			return;
   		}
   		
   		/**
   		 * @param activity
   		 * @param url
   		 * @param message
   		 * @param appId
   		 * @param appVer
   		 * @param appName
   		 * @param encoding
   		 * @param metaInfoArray
   		 */
   		kakaoLink.openKakaoAppLink(
   				this, 
   				"http://link.kakao.com/?test-android-app", 
   				"학교에서 쓰는 급수표와 연계된 받아쓰기 앱을 소개합니다.",  
   				getPackageName(), 
   				getPackageManager().getPackageInfo(getPackageName(), 0).versionName,
   				"만점 받아쓰기 1학년 2학기",
   				encoding, 
   				metaInfoArray);
   	}
   	
   	private void alert(String message) {
   		new AlertDialog.Builder(this)
   			.setIcon(android.R.drawable.ic_dialog_alert)
   			.setTitle(R.string.app_name)
   			.setMessage(message)
   			.setPositiveButton(android.R.string.ok, null)
   			.create().show();
   	}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
