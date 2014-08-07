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
	
	long endTime; // ����ð�
	int k;
	int result1, result2;

	ContentValues values;
	
	ImageButton play1, play2, play3, play4, play5, play6, play7, play8, play9,
			play10;
	int i = 0;
	int intArray[] = { 11, 1, 21, 11, 1, 21, 12, 2, 21, 12, 2, 21, 13, 3, 21,
			13, 3, 21, // 18��
			14, 4, 21, 14, 4, 21, 15, 5, 21, 15, 5, 21, 16, 6, 21, 16, 6, 21, // 18��
			17, 7, 21, 17, 7, 21, 18, 8, 21, 18, 8, 21, 19, 9, 21, 19, 9, 21, // 18��
			20, 10, 21, 20, 10 // ��� ��� �迭 ����, 5��
	// 11, 12~~: ��ȣ ����, 21: ���� 5��
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
		mediaPlayer.stop();
		super.onPause();

	}
}