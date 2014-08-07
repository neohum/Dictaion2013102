package com.honeyv.dictation2013102;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.honeyv.dictation2013102.R;

public class FirstWritingActivity extends Activity {
	public DBHelper helper = null;
	public Cursor cursor = null;
	public TextView tvLevel;
	public String text, str;

	ImageView dictationField;
	Button number_01;
	Button number_02;
	Button number_03;
	Button number_04;
	Button number_05;
	Button number_06;
	Button number_07;
	Button number_08;
	Button number_09;
	Button number_10;

	private int res = 0;

	long endTime; // 종료시간
	int k;
	int result1, result2;

	ContentValues values;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		setContentView(R.layout.activity_first_writing);
		setVolumeControlStream(AudioManager.STREAM_MUSIC);
		this.init();
	}

	public void init() {
		number_01 = (Button) findViewById(R.id.btn_num_01);
		number_02 = (Button) findViewById(R.id.btn_num_02);
		number_03 = (Button) findViewById(R.id.btn_num_03);
		number_04 = (Button) findViewById(R.id.btn_num_04);
		number_05 = (Button) findViewById(R.id.btn_num_05);
		number_06 = (Button) findViewById(R.id.btn_num_06);
		number_07 = (Button) findViewById(R.id.btn_num_07);
		number_08 = (Button) findViewById(R.id.btn_num_08);
		number_09 = (Button) findViewById(R.id.btn_num_09);
		number_10 = (Button) findViewById(R.id.btn_num_10);
		dictationField = (ImageView) findViewById(R.id.imgDictationField);
		tvLevel = (TextView) findViewById(R.id.tvLevel);

		Intent intent = getIntent();
		text = intent.getStringExtra("test");
		tvLevel.setText(text);

		helper = new DBHelper(this);
		endTime = System.currentTimeMillis();

	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

	public void mOnClick(View v) {
		switch (v.getId()) {
		case R.id.btn_num_01:
			res = getResources().getIdentifier("i" + text + "_" + 1,
					"drawable", this.getPackageName());
			dictationField.setImageResource(res);
			break;

		case R.id.btn_num_02:
			res = getResources().getIdentifier("i" + text + "_" + 2,
					"drawable", this.getPackageName());
			dictationField.setImageResource(res);
			break;

		case R.id.btn_num_03:
			res = getResources().getIdentifier("i" + text + "_" + 3,
					"drawable", this.getPackageName());
			dictationField.setImageResource(res);
			break;

		case R.id.btn_num_04:
			res = getResources().getIdentifier("i" + text + "_" + 4,
					"drawable", this.getPackageName());
			dictationField.setImageResource(res);
			break;

		case R.id.btn_num_05:
			res = getResources().getIdentifier("i" + text + "_" + 5,
					"drawable", this.getPackageName());
			dictationField.setImageResource(res);
			break;

		case R.id.btn_num_06:
			res = getResources().getIdentifier("i" + text + "_" + 6,
					"drawable", this.getPackageName());
			dictationField.setImageResource(res);
			break;

		case R.id.btn_num_07:
			res = getResources().getIdentifier("i" + text + "_" + 7,
					"drawable", this.getPackageName());
			dictationField.setImageResource(res);
			break;

		case R.id.btn_num_08:
			res = getResources().getIdentifier("i" + text + "_" + 8,
					"drawable", this.getPackageName());
			dictationField.setImageResource(res);
			break;

		case R.id.btn_num_09:
			res = getResources().getIdentifier("i" + text + "_" + 9,
					"drawable", this.getPackageName());
			dictationField.setImageResource(res);
			break;

		case R.id.btn_num_10:
			res = getResources().getIdentifier("i" + text + "_" + 10,
					"drawable", this.getPackageName());
			dictationField.setImageResource(res);
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
		super.onPause();

	}
}
