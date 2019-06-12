package cn.edu.hebtu.software.peacetest;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;

public class RingActivity extends Activity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ring);

        //播放音乐
        mediaPlayer = MediaPlayer.create(this, R.raw.xishuisheng);
        mediaPlayer.start();
        //实例化通知管理器
        NotificationManager notificationManager=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        //实例化通知
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this);
        builder.setDefaults(NotificationCompat.DEFAULT_ALL);
        builder.setContentTitle("闹钟响了");
        builder.setSmallIcon(android.R.drawable.ic_lock_idle_alarm);
        builder.setContentText("记得在早上9点之前吃早餐哦");
        Notification notification=builder.build();
        //发送通知
        notificationManager.notify(0x103,notification);

    }

    public void stop(View view){
        mediaPlayer.stop();
        finish();
    }

}
