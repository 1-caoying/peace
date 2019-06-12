package cn.edu.hebtu.software.peace;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TimePicker;

import java.util.Calendar;

public class RemindActivity extends AppCompatActivity {

    private PendingIntent pendingIntent;
    private AlarmManager alarmManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("111","23");
        setContentView(R.layout.activity_remind);

        //实例化闹钟管理
        alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);


    }

    //设置闹钟（一次）
    public void setAlarmOne(View view){
        //获取当前系统时间
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        //弹出时间对话框
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                //确定选择好的时间hourOfDay minut
                Calendar c = Calendar.getInstance();
                c.set(Calendar.HOUR_OF_DAY,hourOfDay);
                c.set(Calendar.MINUTE,minute);

                //时间一到，执行相应的操作
                Intent intent = new Intent();
                intent.setAction("cn.edu.hebtu.software.peace.RING");
                PendingIntent pendingIntent = PendingIntent.getBroadcast(RemindActivity.this,0x101,intent,0);

                //设置闹钟
                alarmManager.set(AlarmManager.RTC_WAKEUP,c.getTimeInMillis(),pendingIntent);

            }
        },hour,minute,true);
        timePickerDialog.show();
    }

    //设置闹钟（周期）
    public void setAlarmCycle(View view){
        //获取当前系统的时间
        Calendar calendar=Calendar.getInstance();
        int hour=calendar.get(Calendar.HOUR_OF_DAY);
        int minute=calendar.get(Calendar.MINUTE);


        //01.弹出时间对话框（选择时间）
        TimePickerDialog timePickerDialog=new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                //02.确定选择好的时间  i  i1
                Calendar c=Calendar.getInstance();
                c.set(Calendar.HOUR_OF_DAY,i);
                c.set(Calendar.MINUTE,i1);

                //04.时间一到，执行相对应的操作
                Intent  intent=new Intent();
                intent.setAction("cn.edu.hebtu.software.peace.RING");
                pendingIntent = PendingIntent.getBroadcast(RemindActivity.this,0x102,intent,0);

                //03.设置闹钟(周期)
                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,c.getTimeInMillis(),5000, pendingIntent);
            }
        },hour,minute,true);
        timePickerDialog.show();
    }

    //取消闹钟
    public void cancleAlarmCycle(View view){
        alarmManager.cancel(pendingIntent);
    }

}
