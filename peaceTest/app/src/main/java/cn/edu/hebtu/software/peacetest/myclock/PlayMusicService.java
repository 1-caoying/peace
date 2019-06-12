package cn.edu.hebtu.software.peacetest.myclock;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.IBinder;

import java.io.File;

public class PlayMusicService extends Service {

	private MediaPlayer mPlayer;
	public static final String MUSIC_COMPLETED = "com.sharpandroid.Service_Player.completed";
	
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void onCreate() {
		super.onCreate();
	}

	@Override
	public void onDestroy() {
		mPlayer.stop();
		super.onDestroy();
	}

	@Override
	public void onStart(Intent intent, int startId) {
		Bundle bundle = intent.getExtras();
		String url = bundle.getString("URL");

		// Toast.makeText(this, "URL="+url, Toast.LENGTH_LONG).show();
		//得到当前设备SD卡目录
		Environment.getExternalStorageDirectory();
		//mPlayer = MediaPlayer.create(this, R.raw.anewhope);
		mPlayer = MediaPlayer.create(this, Uri.fromFile(new File(url)));
		mPlayer.start();
		
		super.onStart(intent, startId);
	}
}
