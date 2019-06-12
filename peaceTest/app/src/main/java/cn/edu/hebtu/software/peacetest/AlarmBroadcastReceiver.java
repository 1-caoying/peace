package cn.edu.hebtu.software.peacetest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AlarmBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if ("testalarm0".equals(intent.getAction())) {
            System.out.println("第一个闹钟");
        }

        if ("testalarm1".equals(intent.getAction())) {
            System.out.println("第二个闹钟");
        }

    }
}
