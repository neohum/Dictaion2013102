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
			
			// fade_in���� �����Ͽ� fade_out���� ��Ʈ�� ȭ���� �������� �ִϸ��̼� �߰�
			overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
		}
	};
	
	// ��Ʈ�ΰ� ����Ǵ� �߿� �ڷΰ��� ��ư�� ������ �� 3�� �� ������������ �ߴ� �� ����
	@Override
	public void onBackPressed(){
		super.onBackPressed();
		handler.removeCallbacks(irun);
	}
}