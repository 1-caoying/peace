package cn.edu.hebtu.software.peace.myclock;

import java.util.Calendar;

import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TimePicker;
import android.widget.Toast;

public class SetClockTime {
	private Context context;
	private Calendar c = Calendar.getInstance();// 获取日历对象
	private Bundle b;
	private SetAlarmManager setAlarmManager;
	
	public SetClockTime(Context context) {
		this.context = context;
	}

	public Dialog onCreateDialog(int id,Bundle bundle) {
		Dialog dialog = null;
		b = bundle;
		switch (id) {
		case 0:
			// 创建显示的时钟对话框
			dialog = new TimePickerDialog(context,
					new TimePickerDialog.OnTimeSetListener() {
						public void onTimeSet(TimePicker view, int hourOfDay,
								int minute) {
							// c.setTimeInMillis(System.currentTimeMillis());//
							// 设置Calendar对象
							// HOUR_OF_DAY24小时 ,HOUR 12小时
							Calendar cal = Calendar.getInstance();
							cal.set(Calendar.HOUR_OF_DAY, hourOfDay);// 设置小时
							cal.set(Calendar.MINUTE, minute);// 设置分钟
							cal.set(Calendar.SECOND, 0);// 设置秒
							cal.set(Calendar.MILLISECOND, 0);//设置毫秒

							c.set(Calendar.HOUR_OF_DAY, hourOfDay);// 设置小时
							c.set(Calendar.MINUTE, minute);
							
							Intent intent = new Intent(context,
									AlarmReceiver.class);
							b.putInt("hour", c.get(Calendar.HOUR_OF_DAY));
							b.putInt("minute", c.get(Calendar.MINUTE));
							
							intent.putExtras(b);
							
							setAlarmManager = new SetAlarmManager(context, cal, intent);
							setAlarmManager.setAlarmManager();
							
							
							Toast.makeText(context, "设置成功", Toast.LENGTH_LONG)
									.show();
						}
					}, c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE),
					// false为12小时制，true为24小时制
					true);
			break;
		}
		return dialog;
	}
}
