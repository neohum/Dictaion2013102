package com.honeyv.dictation2013102;

import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Window;
import android.widget.ListAdapter;
import android.widget.SimpleCursorAdapter;

import com.honeyv.dictation2013102.R;

public class ResultActivity extends ListActivity {
	private DBHelper helper = null;
	private Cursor cursor = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_result);
		helper = new DBHelper(this);
		cursor = helper
				.getWritableDatabase()
				.rawQuery(
						"SELECT _ID, level, date, time FROM dictation ORDER BY level DESC limit 50",
						null);

		ListAdapter adapter = new SimpleCursorAdapter(this, R.layout.row,
				cursor, new String[] { DBHelper.LEVEL, DBHelper.DATE,
						DBHelper.TIME }, new int[] { R.id.level, R.id.date,
						R.id.time });
		setListAdapter(adapter);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		cursor.close();
		helper.close();
	}
}