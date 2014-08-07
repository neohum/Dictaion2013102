package com.honeyv.dictation2013102;

import java.util.Calendar;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.honeyv.dictation2013102.R;

public class DBHelper extends SQLiteOpenHelper {
	private static final String DATABASE_NAME = "dictation.db";
	private static final String Q_CREATE_TABLE = "CREATE TABLE dictation (_id INTEGER PRIMARY KEY AUTOINCREMENT, level TEXT, date TEXT, time TEXT);";
	private static final String Q_DROP_TABLE = "DROP TABLE IF EXISTS dictation";
	public static final String LEVEL = "level";
	public static final String DATE = "date";
	public static final String TIME = "time";

	public DBHelper(Context context) {
		super(context, DATABASE_NAME, null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(Q_CREATE_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL(Q_DROP_TABLE);
	}
}

class Date {
	static Calendar mCalendar;
	static int curYear, curMonth, curDay, curHour, curMinute, curNoon,
			curSecond, curDays;
	static String s_date;
	static String dateString;
	static String timeString;
	static String m_week;

	static public String getDateNow() {
		mCalendar = Calendar.getInstance();
		curYear = mCalendar.get(Calendar.YEAR);
		curMonth = mCalendar.get(Calendar.MONTH) + 1;
		curDay = mCalendar.get(Calendar.DAY_OF_MONTH);
		curHour = mCalendar.get(Calendar.HOUR_OF_DAY);
		curMinute = mCalendar.get(Calendar.MINUTE);
		curSecond = mCalendar.get(Calendar.SECOND);
		curDays = mCalendar.get(Calendar.DAY_OF_WEEK);

		if (curDays == 1)
			m_week = "일요일";
		else if (curDays == 2)
			m_week = "월요일";
		else if (curDays == 3)
			m_week = "화요일";
		else if (curDays == 4)
			m_week = "수요일";
		else if (curDays == 5)
			m_week = "목요일";
		else if (curDays == 6)
			m_week = "금요일";
		else if (curDays == 7)
			m_week = "토요일";

		s_date = curYear + "-" + curMonth + "-" + curDay + " " + m_week;

		return s_date;

	}

	public static String onlyNum(String str) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < str.length(); i++) {
			if (Character.isDefined(str.charAt(i))) {
				sb.append(str.charAt(i));
			}
		}
		return sb.toString();
	}
}
