package com.honeyv.dictation2013102;

import java.io.IOException;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.honeyv.dictation2013102.R;

public class CheckActivity extends Activity {	
	public DBHelper helper = null;
	public Cursor cursor = null;
	public TextView tvLevel;
	public String text, text2, str;
	
	public MediaPlayer mediaPlayer;
	
	Button btnTotalSound, btnCheck, btnPause;
	ImageView number;
	
	ImageView answer1;
	ImageView answer2;
	ImageView answer3;
	ImageView answer4;
	ImageView answer5;
	ImageView answer6;
	ImageView answer7;
	ImageView answer8;
	ImageView answer9;
	ImageView answer10;
	
	long endTime; // 종료시간
	int k;
	int result1, result2;

	ContentValues values;
	
	ImageButton play1, play2, play3, play4, play5, play6, play7, play8, play9,
			play10;
	int i = 0;
	int intArray[] = { 11, 1, 21, 11, 1, 21, 12, 2, 21, 12, 2, 21, 13, 3, 21,
			13, 3, 21, // 18개
			14, 4, 21, 14, 4, 21, 15, 5, 21, 15, 5, 21, 16, 6, 21, 16, 6, 21, // 18개
			17, 7, 21, 17, 7, 21, 18, 8, 21, 18, 8, 21, 19, 9, 21, 19, 9, 21, // 18개
			20, 10, 21, 20, 10 // 재생 목록 배열 생성, 5개
	// 11, 12~~: 번호 음성, 21: 무음 5초
	};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		setContentView(R.layout.activity_check);
		setVolumeControlStream(AudioManager.STREAM_MUSIC);
		this.init();
		
		helper = new DBHelper(this);
		endTime = System.currentTimeMillis();
	}

	public void init() {
		tvLevel = (TextView) findViewById(R.id.textTitle);
		btnTotalSound = (Button) findViewById(R.id.btnTotalSound);
		btnCheck = (Button) findViewById(R.id.btnCheck);
		btnPause = (Button) findViewById(R.id.btnPause);
		answer1 = (ImageView) findViewById(R.id.anwer1);
		answer2 = (ImageView) findViewById(R.id.anwer2);
		answer3 = (ImageView) findViewById(R.id.anwer3);
		answer4 = (ImageView) findViewById(R.id.anwer4);
		answer5 = (ImageView) findViewById(R.id.anwer5);
		answer6 = (ImageView) findViewById(R.id.anwer6);
		answer7 = (ImageView) findViewById(R.id.anwer7);
		answer8 = (ImageView) findViewById(R.id.anwer8);
		answer9 = (ImageView) findViewById(R.id.anwer9);
		answer10 = (ImageView) findViewById(R.id.anwer10);

		play1 = (ImageButton) findViewById(R.id.play1);
		play2 = (ImageButton) findViewById(R.id.play2);
		play3 = (ImageButton) findViewById(R.id.play3);
		play4 = (ImageButton) findViewById(R.id.play4);
		play5 = (ImageButton) findViewById(R.id.play5);
		play6 = (ImageButton) findViewById(R.id.play6);
		play7 = (ImageButton) findViewById(R.id.play7);
		play8 = (ImageButton) findViewById(R.id.play8);
		play9 = (ImageButton) findViewById(R.id.play9);
		play10 = (ImageButton) findViewById(R.id.play10);
		
		Intent intent = getIntent();
		text = intent.getStringExtra("test");
		tvLevel.setText(text);

		mediaPlayer = new MediaPlayer();

	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

	private void playAudio() {
		if (i < 59) {
			mediaPlayer.reset();
			int sound = getResources().getIdentifier(
					"i" + text + "_" + intArray[i], "raw", getPackageName());
			mediaPlayer = MediaPlayer.create(getBaseContext(), sound);
			try {
				mediaPlayer.prepare();
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			mediaPlayer.start();
			mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
				public void onCompletion(MediaPlayer mp) {
					nextSong();
				}
			});
		} else {
			i = 0;
		}
	}

	private void nextSong() {
		i++;
		playAudio();
	}

	@Override
	protected void onStop() {
		mediaPlayer.stop();
		super.onStop();
	}


	public void mOnClick(View v) {
		switch (v.getId()) {
		case R.id.btnTotalSound:
			playAudio();
			break;
			
		case R.id.btnPause:
			mediaPlayer.pause();
			break;
			
		case R.id.btnCheck:
	        final int res1 = getResources().getIdentifier("i" + text + "_" + 1, "drawable", this.getPackageName());
	        final int res2 = getResources().getIdentifier("i" + text + "_" + 2, "drawable", this.getPackageName());
	        final int res3 = getResources().getIdentifier("i" + text + "_" + 3, "drawable", this.getPackageName());
	        final int res4 = getResources().getIdentifier("i" + text + "_" + 4, "drawable", this.getPackageName());
	        final int res5 = getResources().getIdentifier("i" + text + "_" + 5, "drawable", this.getPackageName());
	        final int res6 = getResources().getIdentifier("i" + text + "_" + 6, "drawable", this.getPackageName());
	        final int res7 = getResources().getIdentifier("i" + text + "_" + 7, "drawable", this.getPackageName());
	        final int res8 = getResources().getIdentifier("i" + text + "_" + 8, "drawable", this.getPackageName());
	        final int res9 = getResources().getIdentifier("i" + text + "_" + 9, "drawable", this.getPackageName());
	        final int res10 = getResources().getIdentifier("i" + text + "_" + 10, "drawable", this.getPackageName());
			answer1.setImageResource(res1);
			answer2.setImageResource(res2);
			answer3.setImageResource(res3);
			answer4.setImageResource(res4);
			answer5.setImageResource(res5);
			answer6.setImageResource(res6);
			answer7.setImageResource(res7);
			answer8.setImageResource(res8);
			answer9.setImageResource(res9);
			answer10.setImageResource(res10);
			break;
			
		case R.id.play1:
			mediaPlayer.reset();
			int sound1 = getResources().getIdentifier("i" + text+"_"+1, "raw", getPackageName());
	        mediaPlayer = MediaPlayer.create(getBaseContext(), sound1);
			try {
				mediaPlayer.prepare();
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			mediaPlayer.start();
			break;
			
		case R.id.play2:
			mediaPlayer.reset();
			int sound2 = getResources().getIdentifier("i" + text+"_"+2, "raw", getPackageName());
	        mediaPlayer = MediaPlayer.create(getBaseContext(), sound2);
			try {
				mediaPlayer.prepare();
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			mediaPlayer.start();
			break;

		case R.id.play3:
			mediaPlayer.reset();
			int sound3 = getResources().getIdentifier("i" + text+"_"+3, "raw", getPackageName());
	        mediaPlayer = MediaPlayer.create(getBaseContext(), sound3);
			try {
				mediaPlayer.prepare();
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			mediaPlayer.start();

			break;

		case R.id.play4:
			mediaPlayer.reset();
			int sound4 = getResources().getIdentifier("i" + text+"_"+4, "raw", getPackageName());
	        mediaPlayer = MediaPlayer.create(getBaseContext(), sound4);
			try {
				mediaPlayer.prepare();
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			mediaPlayer.start();

			break;
			
		case R.id.play5:
			mediaPlayer.reset();
			int sound5 = getResources().getIdentifier("i" + text+"_"+5, "raw", getPackageName());
	        mediaPlayer = MediaPlayer.create(getBaseContext(), sound5);
			try {
				mediaPlayer.prepare();
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			mediaPlayer.start();

			break;

		case R.id.play6:
			mediaPlayer.reset();
			int sound6 = getResources().getIdentifier("i" + text+"_"+6, "raw", getPackageName());
	        mediaPlayer = MediaPlayer.create(getBaseContext(), sound6);
			try {
				mediaPlayer.prepare();
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			mediaPlayer.start();

			break;

		case R.id.play7:
			mediaPlayer.reset();
			int sound7 = getResources().getIdentifier("i" + text+"_"+7, "raw", getPackageName());
	        mediaPlayer = MediaPlayer.create(getBaseContext(), sound7);
			try {
				mediaPlayer.prepare();
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			mediaPlayer.start();

			break;
			
		case R.id.play8:
			mediaPlayer.reset();
			int sound8 = getResources().getIdentifier("i" + text+"_"+8, "raw", getPackageName());
	        mediaPlayer = MediaPlayer.create(getBaseContext(), sound8);
			try {
				mediaPlayer.prepare();
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			mediaPlayer.start();

			break;

		case R.id.play9:
			mediaPlayer.reset();
			int sound9 = getResources().getIdentifier("i" + text+"_"+9, "raw", getPackageName());
	        mediaPlayer = MediaPlayer.create(getBaseContext(), sound9);
			try {
				mediaPlayer.prepare();
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			mediaPlayer.start();

			break;

		case R.id.play10:
			mediaPlayer.reset();
			int sound10 = getResources().getIdentifier("i" + text+"_"+10, "raw", getPackageName());
	        mediaPlayer = MediaPlayer.create(getBaseContext(), sound10);
			try {
				mediaPlayer.prepare();
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			mediaPlayer.start();

			break;
		}
	}
	
	@Override
	protected void onPause() {
		int time = (int) (System.currentTimeMillis() - endTime) / 1000;
		if (time < 60) { // 활동 시간이 60초보다 작을 경우 초만 표시
			if (time < 10) {
				str = "0" + time + "초"; // 초가 10보다 작을 경우 칸을 맞추기 위해 0을 삽입하여 5초의
										// 경우 05초로 표시
			} else {
				str = "" + time + "초";
			}

		} else if (time < 3600) { // 활동시간이 60분보다 작을 경우 분, 초를 표시
			int min = time / 60; // 전체초를 분으로 환산
			int sec = time % 60; // 전체초를 나눈 나머지는 초가 됨
			if (sec == 0) { // 초가 0일경우 분만 나타나도록
				if (min < 10) {
					str = "0" + min + "분"; // 분이 10분 이하일 때 0이 표시 되도록
				} else {
					str = min + "분";
				}
			} else { // 초가 0이 아닐 경우
				if (min < 10 && sec < 10) { // 분과 초가 모두 10이하일 경우
					str = "0" + min + "분," + "0" + sec + "초"; // 분과 초 앞에 0을 넣기
				} else if (min < 10) {
					str = "0" + min + "분," + sec + "초"; // 분만 10이하일 경우 분만 앞에 0을
														// 넣기
				} else if (sec < 10) { // 초만 10이하일 경우 초만 앞에 0을 넣기
					str = min + "분," + "0" + sec + "초";
				} else {
					str = min + "분," + sec + "초";
				}
			}
		} else {
			int hour = time / 3600;
			int hour_change = time % 3600;
			int min = (time - 3600) / 60;
			int min_change = (time - 3600) % 60;
			int sec = time % 3600;
			if (hour_change == 0) {
				str = hour + "시간";
			} else if (min_change == 0) {
				if (min < 10) {
					str = hour + "시간," + "0" + min + "분";
				} else {
					str = hour + "시간," + min + "분";
				}
			} else {
				if (min < 10 && sec < 10) {
					str = hour + "시간," + "0" + min + "분," + "0" + sec + "초";
				} else if (min < 10) {
					str = hour + "시간," + "0" + min + "분," + sec + "초";
				} else if (sec < 10) {
					str = hour + "시간," + min + "분," + "0" + sec + "초";
				} else {
					str = hour + "시간," + min + "분," + sec + "초";
				}
			}
		}

		// 1. 데이터 베이스에서 급수(name), 날짜(date)를 검사해서 같은 급수, 같은 날짜일 경우
		// 2. 시간(time)을 누적하기
		// 3. 아닐 경우 새로운 컬럼을 생성하기

		cursor = helper.getWritableDatabase()
				.rawQuery(
						"SELECT time FROM dictation WHERE level='" + text
								+ "급' AND date='" + Date.getDateNow() + "' ",
						null);
		if (cursor.getCount() > 0) {
			cursor.moveToLast();
			String a = cursor.getString(0);
			a = a.replace("초", "");
			a = a.replace("분", "*60");
			try {
				if (a.matches(".*,.*")) {
					a = a.replace(",", "+");
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			// a=a.replace("00,", "");
			a = a.replace("시간", "*");
			a = a.replace(",", "3600");

			String postfixExp1;
			try {
				postfixExp1 = Calculator.postfix(a);
				result1 = Calculator.postfixCalc(postfixExp1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int i = result1;
			// int i = Integer.parseInt(a);
			String b = str;
			b = b.replace("초", "");
			b = b.replace("분", "*60");
			try {
				if (b.matches(".*,.*")) {
					b = b.replace(",", "+");
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			// b=b.replace("00,", "");
			b = b.replace("시간", "*");
			b = b.replace(",", "3600");

			String postfixExp2;
			try {
				postfixExp2 = Calculator.postfix(b);
				result2 = Calculator.postfixCalc(postfixExp2);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			int j = result2;
			k = i + j;
			if (k < 60) { // 활동 시간이 60초보다 작을 경우 초만 표시
				if (k < 10) {
					str = "0" + k + "초"; // 초가 10보다 작을 경우 칸을 맞추기 위해 0을 삽입하여 5초의
											// 경우 05초로 표시
				} else {
					str = "" + k + "초";
				}

			} else if (k < 3600) { // 활동시간이 60분보다 작을 경우 분, 초를 표시
				int min = k / 60; // 전체초를 분으로 환산
				int sec = k % 60; // 전체초를 나눈 나머지는 초가 됨
				if (sec == 0) { // 초가 0일경우 분만 나타나도록
					if (min < 10) {
						str = "0" + min + "분"; // 분이 10분 이하일 때 0이 표시 되도록
					} else {
						str = min + "분";
					}
				} else { // 초가 0이 아닐 경우
					if (min < 10 && sec < 10) { // 분과 초가 모두 10이하일 경우
						str = "0" + min + "분," + "0" + sec + "초"; // 분과 초 앞에 0을
																	// 넣기
					} else if (min < 10) {
						str = "0" + min + "분," + sec + "초"; // 분만 10이하일 경우 분만 앞에
															// 0을 넣기
					} else if (sec < 10) { // 초만 10이하일 경우 초만 앞에 0을 넣기
						str = min + "분," + "0" + sec + "초";
					} else {
						str = min + "분," + sec + "초";
					}
				}
			} else {
				int hour = k / 3600;
				int hour_change = k % 3600;
				int min = (k - 3600) / 60;
				int min_change = (k - 3600) % 60;
				int sec = k % 3600;
				if (hour_change == 0) {
					str = hour + "시간";
				} else if (min_change == 0) {
					if (min < 10) {
						str = hour + "시간," + "0" + min + "분";
					} else {
						str = hour + "시간," + min + "분";
					}
				} else {
					if (min < 10 && sec < 10) {
						str = hour + "시간," + "0" + min + "분," + "0" + sec + "초";
					} else if (min < 10) {
						str = hour + "시간," + "0" + min + "분," + sec + "초";
					} else if (sec < 10) {
						str = hour + "시간," + min + "분," + "0" + sec + "초";
					} else {
						str = hour + "시간," + min + "분," + sec + "초";
					}

				}
			}
			values = new ContentValues(1);
			values.put(DBHelper.TIME, str);
			helper.getWritableDatabase().update(
					"dictation",
					values,
					"level ='" + text + "급' and date='" + Date.getDateNow()
							+ "'", null);
		} else {
			values = new ContentValues(3);

			values.put(DBHelper.LEVEL, text + "급");
			values.put(DBHelper.DATE, Date.getDateNow());
			values.put(DBHelper.TIME, str);
			helper.getWritableDatabase().insert("dictation", DBHelper.LEVEL,
					values);
		}

		cursor.close();
		helper.close();
		mediaPlayer.stop();
		super.onPause();

	}
}