package cn.edu.hebtu.software.peacetest.myclock;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.SimpleAdapter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.hebtu.software.peacetest.R;
import cn.edu.hebtu.software.peacetest.bean.WeekBean;
import cn.edu.hebtu.software.peacetest.service.MyService;
import cn.edu.hebtu.software.peacetest.util.Util;

public class SetWeek {
	
	private boolean [] checked = new boolean[]{true,true,true,true,false,false,false};
	private boolean [] checked2 = new boolean[]{false,false,false,false,false,false,false};
	private AlertDialog.Builder builder;
	private Context context ;
	private MyService ms ;
	private SimpleAdapter sAdapter;
	private int posi;
	
	public SetWeek(Context context){ 
		builder = new AlertDialog.Builder(context); 
		ms = new MyService(context);
		this.context = context;
	}
	
	public boolean [] week(){
		
		List<WeekBean> list = ms.getWeek();
		
		for(int i = 0; i < list.size(); i++){
		//	Log.i("ID","ID:" + list.get(i).getId()+",boolean:"+list.get(i).getSelect());
			if(list.get(i).getSelect() == 1){
				checked[i] = true;
			}else{
				checked[i] = false;
			}
			checked2[i] = checked[i];
		}
		return checked;
	}

	
	public AlertDialog.Builder show(SimpleAdapter adapter,int position){
		Util.getToDayToNextDay(context);
		week();
		posi = position;
		sAdapter = adapter;
		
		builder.setIcon(R.drawable.ic_launcher);
		builder.setTitle("重复");
		builder.setMultiChoiceItems(new String[] { "星期一", "星期二", "星期三",
						"星期四", "星期五", "星期六", "星期日" },
				checked2, 
				new DialogInterface.OnMultiChoiceClickListener() {
				public void onClick(DialogInterface dialog, int whichButton,boolean isChecked) {
					
					checked2[whichButton] = isChecked;
					
					//Toast.makeText(context, "ID:"+whichButton + "," +checked2[whichButton] , Toast.LENGTH_LONG).show();
				} 
		});
		builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
					
					for(int i = 0; i < checked.length; i++){
						if(checked2[i] != checked[i]){
							//果如选项发生改变，存入数据库
							int b = 1;
							if(!checked2[i]){
								b = 0;
							}
							ms.updateWeek(b, i);
						}
					}
					ChangeList(posi,sAdapter);
			}
		});
		builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) { 
			} 
		});
		return builder;
	}
	private void ChangeList(int position,SimpleAdapter sAdapter){
		boolean [] check = Util.getSelectWeekToBoolean(context);
		String week = Util.getSelectWeekToString(check);
		
		SimpleAdapter sa = sAdapter;
		Map<String,Object> map = (HashMap<String, Object>) sa.getItem(position);
		map.put("other",week);
		
		sa.notifyDataSetChanged();
	}
}
