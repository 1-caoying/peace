package cn.edu.hebtu.software.peace;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class RingReceived extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if ("cn.edu.hebtu.software.peace.RING".equals(intent.getAction())){
            Log.i("test","闹钟响了");
            //跳转到Activity
            Intent intent1=new Intent(context,RingActivity.class);
            //广播跳转到activity.必须给intent设置标志位flags

            intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent1);

        }
    }
}
