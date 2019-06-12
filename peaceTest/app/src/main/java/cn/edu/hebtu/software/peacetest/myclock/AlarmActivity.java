package cn.edu.hebtu.software.peacetest.myclock;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class AlarmActivity extends Activity {
    private String url;
   
    private Bundle bundle;
    
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        bundle = this.getIntent().getExtras();
        
        url = bundle.getString("URL");
        
        Toast.makeText(this, "URL="+url, Toast.LENGTH_LONG).show();
        
        startService(new Intent("com.service.test.Music").putExtras(bundle));
        
        //显示对话框
        new AlertDialog.Builder(AlarmActivity.this).
            setTitle("闹钟").//设置标题
            setMessage("时间到了").setPositiveButton("停止", new OnClickListener(){//设置按钮
                public void onClick(DialogInterface dialog, int which) {
                    AlarmActivity.this.finish();//关闭Activity
                   
                    stopService(new Intent("cn.edu.hebtu.software.peacetest.myclock.Music"));
                }
            }).create().show();
    }
    
    
}