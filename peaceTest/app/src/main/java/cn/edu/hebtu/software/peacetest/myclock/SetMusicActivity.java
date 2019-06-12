package cn.edu.hebtu.software.peacetest.myclock;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.hebtu.software.peacetest.R;
import cn.edu.hebtu.software.peacetest.bean.GetMusicBean;

public class SetMusicActivity extends Activity {
	private GetMusicMsg msg;
	private ListView listView;
	private List<Map<String, Object>> data;
	private Button selectBtn,cancelBtn;
	private GetMusicBean gmb = new GetMusicBean();
	private SimpleAdapter adapter;
	private int index = 0;
	private boolean isSelect = false;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.setmusic);
		selectBtn = (Button)findViewById(R.id.selectbtn);
		cancelBtn = (Button)findViewById(R.id.cancelbtn);
		listView = (ListView) findViewById(R.id.setMusicView);
		
		
		
		adapter = new SimpleAdapter(this,
				data(),
				R.layout.musiclist,
				new String[]{"image","title","album","singer","time","id","url"},
				new int[]{R.id.list_radioImg,R.id.musictitle,R.id.musicalbum,R.id.musicsinger,R.id.musictime,R.id.musicid,R.id.musicurl});
		
	//	MusicAdapter adapter = new MusicAdapter(this,data());
		listView.setAdapter(adapter);
		
		cancelBtn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(SetMusicActivity.this,MyClock.class);
				startActivity(intent);
				SetMusicActivity.this.finish();
			}
		});
		selectBtn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				
				if(isSelect){
					
					Toast.makeText(SetMusicActivity.this, gmb.getTitle().toString(), Toast.LENGTH_LONG).show();
					Intent intent = new Intent(SetMusicActivity.this,MyClock.class);
					Bundle bundle = new Bundle();
					bundle.putString("URL", gmb.getUrl().toString());
					intent.putExtras(bundle);
					startActivity(intent);
					SetMusicActivity.this.finish();
				}
			}
		});
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				isSelect = true;
				
				gmb.setUrl(data().get(position).get("url").toString());
				gmb.setTitle(data().get(position).get("title").toString());
				
				ChangeRadioImage(index,false);
				ChangeRadioImage(position,true);
				index = position;
			}
		});
	}

	/**
	 * 判断按下按键
	 */
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(keyCode==KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0){
			Intent intent = new Intent(SetMusicActivity.this,MyClock.class);
			startActivity(intent);
			SetMusicActivity.this.finish();
		}
		return false;
	}



	public List<Map<String,Object>> data(){
		List<Map<String,Object>> list = new ArrayList<Map<String, Object>>();

		// listView数据来源：一个指向系统通讯录的数据库的指针
		Cursor cursor = getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, 
				null,null, null, MediaStore.Audio.Media.DEFAULT_SORT_ORDER);
		startManagingCursor(cursor);
		
		while(cursor.moveToNext()){
			//歌曲ID
			int id = cursor.getInt(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media._ID));
			//歌曲名称
			String title = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.TITLE));
			//歌手
			String singer = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST));
			//歌曲时长
			int time = cursor.getInt(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DURATION));
			//路径
			String url = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA));
			//专辑
			String album = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ALBUM));
			
			Map<String,Object> map = new HashMap<String, Object>();
			map = new HashMap<String, Object>();
			map.put("image", R.drawable.btn_radio_off);
			map.put("title", ""+title);
			map.put("album", album);
			map.put("singer", ""+singer);
			map.put("time", ""+time);
			map.put("id", ""+id);
			map.put("url", url);
			
			list.add(map);
		}
		return list;
	}
	
	private void ChangeRadioImage(int selectedItem, boolean b){
		SimpleAdapter sa = adapter;
		Map<String,Object> map = (HashMap<String, Object>) sa.getItem(selectedItem);
		if(b){
			map.put("image", R.drawable.btn_radio_on);
		}else{
			map.put("image", R.drawable.btn_radio_off);
		}
		sa.notifyDataSetChanged();
	}
}
