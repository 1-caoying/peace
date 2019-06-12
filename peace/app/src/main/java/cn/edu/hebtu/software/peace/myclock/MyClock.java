package cn.edu.hebtu.software.peace.myclock;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.app.Activity;
import android.app.AlarmManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import cn.edu.hebtu.software.peace.R;
import cn.edu.hebtu.software.peace.util.Util;

public class MyClock extends Activity {
	private List<Map<String, Object>> data;
	private AlarmManager alarmManager = null;
	final int DIALOG_TIME = 0;
	private SetClockTime sct;
	private Bundle bundle;
	private SetWeek sw ;
	private boolean [] check;
	private String week;
	private ListView listView;
	private SimpleAdapter sadapter;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		listView = (ListView)findViewById(R.id.clockListView);

		// 通過Context.getSystemService(Context.ALARM_SERVICE)實例化
		alarmManager = (AlarmManager) MyClock.this
				.getSystemService(Context.ALARM_SERVICE);

		sct = new SetClockTime(MyClock.this);
		
		bundle = this.getIntent().getExtras();
		
		sw = new SetWeek(MyClock.this);
		
		data = getData();
		
		sadapter = new SimpleAdapter(this,
				data,
				R.layout.clocklayout,
				new String[]{"title","other"},
				new int[]{R.id.title,R.id.other});
		 
		
		// 创建一个适配器
	//	adapter = new MyAdapter(this, data);

		listView.setAdapter(sadapter);
		
		listView.setOnItemClickListener(new ListViewClick());
	}
	public String week(){
		check = Util.getSelectWeekToBoolean(this);
		
		return week = Util.getSelectWeekToString(check);
	}

	public List<Map<String, Object>> getData() {
		week();
		
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("title", "设置闹钟");
		map.put("other", "");
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("title", "铃声");
		map.put("other", "");
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("title", "重复");
		map.put("other", week);
		list.add(map);
		
		return list;
	}
	// ListView中某项被点击后
	public class ListViewClick implements AdapterView.OnItemClickListener{

		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			
			switch (position) {
			case 0:
				// 显示一个对话框
				sct.onCreateDialog(DIALOG_TIME,bundle).show();
				//showDialog(DIALOG_TIME);
				break;
			case 1:
				Intent in = new Intent(MyClock.this, SetMusicActivity.class);
				startActivity(in);
				MyClock.this.finish();
				break;
			case 2:
				sw.show(sadapter,position).create().show();
				break;
			}
		}
	}
}
