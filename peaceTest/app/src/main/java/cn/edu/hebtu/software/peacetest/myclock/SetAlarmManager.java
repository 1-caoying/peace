package cn.edu.hebtu.software.peacetest.myclock;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.util.Calendar;
import java.util.List;

import cn.edu.hebtu.software.peacetest.bean.WeekBean;
import cn.edu.hebtu.software.peacetest.service.MyService;

public class SetAlarmManager {
	private Context context;
	private Calendar c ;
	private AlarmManager alarmManager = null;
	private Bundle b;
	private Intent intent;
	
	
	public SetAlarmManager(Context context,Calendar cal,Intent intent){
		this.c = cal;
		this.context = context;
		this.intent = intent;
	}
	
	public void gerWeek(){
		MyService ws  = new MyService(context);
		List<WeekBean> list = ws.getWeek();
	}
	public void setAlarmManager(){
		
		
		alarmManager = (AlarmManager) context
				.getSystemService(Context.ALARM_SERVICE);
		
		PendingIntent pi = PendingIntent.getBroadcast(
				context, 0, intent, 0);
		
		if (c.getTimeInMillis() <= System.currentTimeMillis()) {

			c.set(Calendar.DAY_OF_MONTH,
					c.get(Calendar.DAY_OF_MONTH) + 1);

			alarmManager.set(AlarmManager.RTC_WAKEUP,
					c.getTimeInMillis(), pi);

		} else {
			alarmManager.set(AlarmManager.RTC_WAKEUP,
					c.getTimeInMillis(), pi);

		}
	}
}
