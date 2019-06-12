package cn.edu.hebtu.software.peace.myclock;

import java.util.Calendar;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import cn.edu.hebtu.software.peace.util.Util;

public class AlarmReceiver extends BroadcastReceiver {
	private int hour;
	private int minute;
	private Bundle bundle;
	private SetAlarmManager setAlarmManager;
	private Intent setIntent;
	private Calendar calendar;
	private Context context;

	public void onReceive(Context context, Intent intent) {
		
		this.context = context;
		bundle = intent.getExtras();
		Intent i = new Intent(context, AlarmActivity.class);
		i.putExtras(bundle);
		i.addCategory(Intent.CATEGORY_HOME);
		i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		
		getBundle();
		
		setIntent = new Intent(context, AlarmReceiver.class);
		
		setAlarmManager = new SetAlarmManager(context,
				calendar, setIntent);
		setAlarmManager.setAlarmManager();
		
		context.startActivity(i);
	}

	public void getBundle() {
		hour = bundle.getInt("hour");
		minute = bundle.getInt("minute");
		int day = Util.getToDayToNextDay(context);
		calendar = Util.setCalendar(hour, minute,day);
		Log.i("day", ""+day);
	}
}
