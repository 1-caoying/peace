package cn.edu.hebtu.software.peacetest;

import android.app.AlarmManager;
import android.app.PendingIntent;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;


import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private AlarmManager alarmManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取AlarmManager对象
        alarmManager= (AlarmManager) getSystemService(ALARM_SERVICE);

    }

    public void btn(View view) {
        final Calendar c = Calendar.getInstance();
        TimePickerDialog dialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    //延迟意图（即闹钟的意图）

                    PendingIntent paIntent = PendingIntent.getActivity(MainActivity.this,
                            1, new Intent(MainActivity.this,RingActivity.class),
                            PendingIntent.FLAG_UPDATE_CURRENT);
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        //设置你所选择的时间
                        c.set(Calendar.HOUR_OF_DAY, hourOfDay);
                        c.set(Calendar.MINUTE, minute);
                        //第一个参数指定闹钟服务的类型
                        //第二个参数指定闹钟间隔的时间
                        //第三个参数指跳转闹钟的延迟意图
                        alarmManager.set(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), paIntent);
                    }
                },
                //闹钟的初始值（时和分）
                c.get(Calendar.HOUR_OF_DAY),
                c.get(Calendar.MINUTE),
                true);
        dialog.show();
    }




}
