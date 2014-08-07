package com.honeyv.dictation2013102;

import java.io.IOException;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.honeyv.dictation2013102.R;

public class SecondWritingActivity extends Activity {
	public DBHelper helper = null;
	public Cursor cursor = null;
	public TextView tvLevel;
	public String text, text2, str;
	public int flag = 0;
	
	ImageView dictationField;
	Button btnPlay;
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

	public MediaPlayer mediaPlayer;
	private int res = 0;

	long endTime; // ����ð�
	int k;

	int result1, result2;

	ContentValues values;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		setContentView(R.layout.activity_second_writing);
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
		btnPlay = (Button) findViewById(R.id.btnPlay);
		dictationField = (ImageView) findViewById(R.id.imgDictationField);
		tvLevel = (TextView) findViewById(R.id.tvLevel);

		Intent intent = getIntent();
		text = intent.getStringExtra("test");
		text2 = intent.getStringExtra("test2");
		tvLevel.setText(text);

		helper = new DBHelper(this);
		endTime = System.currentTimeMillis();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

	public void soundPrepare() {
		// ������� �Ҹ��غ�
		int sound = getResources().getIdentifier("i" + text + "_" + 1, "raw",
				this.getPackageName());
		mediaPlayer = MediaPlayer.create(getBaseContext(), sound);
		try {
			mediaPlayer.prepare();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		int res = getResources().getIdentifier(text2 + text + "_" + 1,
				"drawable", this.getPackageName());
		dictationField.setImageResource(res);
	}

	public void mOnClick(View v) {
		switch (v.getId()) {
		case R.id.btn_num_01:
			flag = 1;
			res = getResources().getIdentifier(text2 + text + "_" + 1,
					"drawable", this.getPackageName());
			dictationField.setImageResource(res);

			int sound = getResources().getIdentifier("i" + text + "_" + 1,
					"raw", this.getPackageName());
			mediaPlayer = MediaPlayer.create(getBaseContext(), sound);
			try {
				mediaPlayer.prepare();
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;

		case R.id.btn_num_02:
			flag = 2;
			res = getResources().getIdentifier(text2 + text + "_" + 2,
					"drawable", this.getPackageName());
			dictationField.setImageResource(res);

			int sound2 = getResources().getIdentifier("i" + text + "_" + 2,
					"raw", this.getPackageName());
			mediaPlayer = MediaPlayer.create(getBaseContext(), sound2);
			try {
				mediaPlayer.prepare();
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;

		case R.id.btn_num_03:
			flag = 3;
			res = getResources().getIdentifier(text2 + text + "_" + 3,
					"drawable", this.getPackageName());
			dictationField.setImageResource(res);

			int sound3 = getResources().getIdentifier("i" + text + "_" + 3,
					"raw", this.getPackageName());
			mediaPlayer = MediaPlayer.create(getBaseContext(), sound3);
			try {
				mediaPlayer.prepare();
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;

		case R.id.btn_num_04:
			flag = 4;
			res = getResources().getIdentifier(text2 + text + "_" + 4,
					"drawable", this.getPackageName());
			dictationField.setImageResource(res);

			int sound4 = getResources().getIdentifier("i" + text + "_" + 4,
					"raw", this.getPackageName());
			mediaPlayer = MediaPlayer.create(getBaseContext(), sound4);
			try {
				mediaPlayer.prepare();
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;

		case R.id.btn_num_05:
			flag = 5;
			res = getResources().getIdentifier(text2 + text + "_" + 5,
					"drawable", this.getPackageName());
			dictationField.setImageResource(res);

			int sound5 = getResources().getIdentifier("i" + text + "_" + 5,
					"raw", this.getPackageName());
			mediaPlayer = MediaPlayer.create(getBaseContext(), sound5);
			try {
				mediaPlayer.prepare();
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;

		case R.id.btn_num_06:
			flag = 6;
			res = getResources().getIdentifier(text2 + text + "_" + 6,
					"drawable", this.getPackageName());
			dictationField.setImageResource(res);

			int sound6 = getResources().getIdentifier("i" + text + "_" + 6,
					"raw", this.getPackageName());
			mediaPlayer = MediaPlayer.create(getBaseContext(), sound6);
			try {
				mediaPlayer.prepare();
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;

		case R.id.btn_num_07:
			flag = 7;
			res = getResources().getIdentifier(text2 + text + "_" + 7,
					"drawable", this.getPackageName());
			dictationField.setImageResource(res);

			int sound7 = getResources().getIdentifier("i" + text + "_" + 7,
					"raw", this.getPackageName());
			mediaPlayer = MediaPlayer.create(getBaseContext(), sound7);
			try {
				mediaPlayer.prepare();
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;

		case R.id.btn_num_08:
			flag = 8;
			res = getResources().getIdentifier(text2 + text + "_" + 8,
					"drawable", this.getPackageName());
			dictationField.setImageResource(res);

			int sound8 = getResources().getIdentifier("i" + text + "_" + 8,
					"raw", this.getPackageName());
			mediaPlayer = MediaPlayer.create(getBaseContext(), sound8);
			try {
				mediaPlayer.prepare();
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;

		case R.id.btn_num_09:
			flag = 9;
			res = getResources().getIdentifier(text2 + text + "_" + 9,
					"drawable", this.getPackageName());
			dictationField.setImageResource(res);

			int sound9 = getResources().getIdentifier("i" + text + "_" + 9,
					"raw", this.getPackageName());
			mediaPlayer = MediaPlayer.create(getBaseContext(), sound9);
			try {
				mediaPlayer.prepare();
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;

		case R.id.btn_num_10:
			flag = 10;
			res = getResources().getIdentifier(text2 + text + "_" + 10,
					"drawable", this.getPackageName());
			dictationField.setImageResource(res);

			int sound10 = getResources().getIdentifier("i" + text + "_" + 10,
					"raw", this.getPackageName());
			mediaPlayer = MediaPlayer.create(getBaseContext(), sound10);
			try {
				mediaPlayer.prepare();
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;

		case R.id.btnPlay:
			try {
				mediaPlayer.start();
			} catch (Exception e) {
				Toast.makeText(this, "��ȣ�� �������ּ���.", Toast.LENGTH_SHORT).show();
			}
			break;
			
		case R.id.btnCheck:
			try {
				res = getResources().getIdentifier("i" + text + "_" + flag,
						"drawable", this.getPackageName());
				dictationField.setImageResource(res);
				
			} catch (Exception e) {
				Toast.makeText(this, "��ȣ�� �������ּ���.", Toast.LENGTH_SHORT).show();
			}
			break;
		}
	}

	@Override
	protected void onPause() {
		int time = (int) (System.currentTimeMillis() - endTime) / 1000;
		if (time < 60) { // Ȱ�� �ð��� 60�ʺ��� ���� ��� �ʸ� ǥ��
			if (time < 10) {
				str = "0" + time + "��"; // �ʰ� 10���� ���� ��� ĭ�� ���߱� ���� 0�� �����Ͽ� 5����
										// ��� 05�ʷ� ǥ��
			} else {
				str = "" + time + "��";
			}

		} else if (time < 3600) { // Ȱ���ð��� 60�к��� ���� ��� ��, �ʸ� ǥ��
			int min = time / 60; // ��ü�ʸ� ������ ȯ��
			int sec = time % 60; // ��ü�ʸ� ���� �������� �ʰ� ��
			if (sec == 0) { // �ʰ� 0�ϰ�� �и� ��Ÿ������
				if (min < 10) {
					str = "0" + min + "��"; // ���� 10�� ������ �� 0�� ǥ�� �ǵ���
				} else {
					str = min + "��";
				}
			} else { // �ʰ� 0�� �ƴ� ���
				if (min < 10 && sec < 10) { // �а� �ʰ� ��� 10������ ���
					str = "0" + min + "��," + "0" + sec + "��"; // �а� �� �տ� 0�� �ֱ�
				} else if (min < 10) {
					str = "0" + min + "��," + sec + "��"; // �и� 10������ ��� �и� �տ� 0��
														// �ֱ�
				} else if (sec < 10) { // �ʸ� 10������ ��� �ʸ� �տ� 0�� �ֱ�
					str = min + "��," + "0" + sec + "��";
				} else {
					str = min + "��," + sec + "��";
				}
			}
		} else {
			int hour = time / 3600;
			int hour_change = time % 3600;
			int min = (time - 3600) / 60;
			int min_change = (time - 3600) % 60;
			int sec = time % 3600;
			if (hour_change == 0) {
				str = hour + "�ð�";
			} else if (min_change == 0) {
				if (min < 10) {
					str = hour + "�ð�," + "0" + min + "��";
				} else {
					str = hour + "�ð�," + min + "��";
				}
			} else {
				if (min < 10 && sec < 10) {
					str = hour + "�ð�," + "0" + min + "��," + "0" + sec + "��";
				} else if (min < 10) {
					str = hour + "�ð�," + "0" + min + "��," + sec + "��";
				} else if (sec < 10) {
					str = hour + "�ð�," + min + "��," + "0" + sec + "��";
				} else {
					str = hour + "�ð�," + min + "��," + sec + "��";
				}
			}
		}

		// 1. ������ ���̽����� �޼�(name), ��¥(date)�� �˻��ؼ� ���� �޼�, ���� ��¥�� ���
		// 2. �ð�(time)�� �����ϱ�
		// 3. �ƴ� ��� ���ο� �÷��� �����ϱ�

		cursor = helper.getWritableDatabase()
				.rawQuery(
						"SELECT time FROM dictation WHERE level='" + text
								+ "��' AND date='" + Date.getDateNow() + "' ",
						null);
		if (cursor.getCount() > 0) {
			cursor.moveToLast();
			String a = cursor.getString(0);
			a = a.replace("��", "");
			a = a.replace("��", "*60");
			try {
				if (a.matches(".*,.*")) {
					a = a.replace(",", "+");
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			// a=a.replace("00,", "");
			a = a.replace("�ð�", "*");
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
			b = b.replace("��", "");
			b = b.replace("��", "*60");
			try {
				if (b.matches(".*,.*")) {
					b = b.replace(",", "+");
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			// b=b.replace("00,", "");
			b = b.replace("�ð�", "*");
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
			if (k < 60) { // Ȱ�� �ð��� 60�ʺ��� ���� ��� �ʸ� ǥ��
				if (k < 10) {
					str = "0" + k + "��"; // �ʰ� 10���� ���� ��� ĭ�� ���߱� ���� 0�� �����Ͽ� 5����
											// ��� 05�ʷ� ǥ��
				} else {
					str = "" + k + "��";
				}

			} else if (k < 3600) { // Ȱ���ð��� 60�к��� ���� ��� ��, �ʸ� ǥ��
				int min = k / 60; // ��ü�ʸ� ������ ȯ��
				int sec = k % 60; // ��ü�ʸ� ���� �������� �ʰ� ��
				if (sec == 0) { // �ʰ� 0�ϰ�� �и� ��Ÿ������
					if (min < 10) {
						str = "0" + min + "��"; // ���� 10�� ������ �� 0�� ǥ�� �ǵ���
					} else {
						str = min + "��";
					}
				} else { // �ʰ� 0�� �ƴ� ���
					if (min < 10 && sec < 10) { // �а� �ʰ� ��� 10������ ���
						str = "0" + min + "��," + "0" + sec + "��"; // �а� �� �տ� 0��
																	// �ֱ�
					} else if (min < 10) {
						str = "0" + min + "��," + sec + "��"; // �и� 10������ ��� �и� �տ�
															// 0�� �ֱ�
					} else if (sec < 10) { // �ʸ� 10������ ��� �ʸ� �տ� 0�� �ֱ�
						str = min + "��," + "0" + sec + "��";
					} else {
						str = min + "��," + sec + "��";
					}
				}
			} else {
				int hour = k / 3600;
				int hour_change = k % 3600;
				int min = (k - 3600) / 60;
				int min_change = (k - 3600) % 60;
				int sec = k % 3600;
				if (hour_change == 0) {
					str = hour + "�ð�";
				} else if (min_change == 0) {
					if (min < 10) {
						str = hour + "�ð�," + "0" + min + "��";
					} else {
						str = hour + "�ð�," + min + "��";
					}
				} else {
					if (min < 10 && sec < 10) {
						str = hour + "�ð�," + "0" + min + "��," + "0" + sec + "��";
					} else if (min < 10) {
						str = hour + "�ð�," + "0" + min + "��," + sec + "��";
					} else if (sec < 10) {
						str = hour + "�ð�," + min + "��," + "0" + sec + "��";
					} else {
						str = hour + "�ð�," + min + "��," + sec + "��";
					}

				}
			}
			values = new ContentValues(1);
			values.put(DBHelper.TIME, str);
			helper.getWritableDatabase().update(
					"dictation",
					values,
					"level ='" + text + "��' and date='" + Date.getDateNow()
							+ "'", null);
		} else {
			values = new ContentValues(3);

			values.put(DBHelper.LEVEL, text + "��");
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
