package com.honeyv.dictation2013102;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

import com.honeyv.dictation2013102.R;
	
public class IntroActivity extends Activity {
	Handler handler;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_intro);
		handler = new Handler();
		handler.postDelayed(irun, 1000);
	}
	
	Runnable irun = new Runnable(){
		public void run(){
			Intent introIntent = new Intent(IntroActivity.this, MainActivity.class);
			startActivity(introIntent);
			finish();
			
			// fade_in으로 시작하여 fade_out으로 인트로 화면이 꺼지도록 애니메이션 추가
			overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
		}
	};
	
	// 인트로가 실행되는 중에 뒤로가기 버튼을 눌렀을 때 3초 후 메인페이지가 뜨는 것 방지
	@Override
	public void onBackPressed(){
		super.onBackPressed();
		handler.removeCallbacks(irun);
	}
}