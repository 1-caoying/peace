package cn.edu.hebtu.software.peacetest.util;

import android.content.Context;
import android.util.Log;

import java.util.Calendar;
import java.util.List;

import cn.edu.hebtu.software.peacetest.bean.WeekBean;
import cn.edu.hebtu.software.peacetest.service.MyService;


public class Util {
		static public String [] getWeek(){
				return new String []{"星期一","星期二",
						"星期三", "星期四", "星期五", "星期六", "星期日"};
		}
		//显示选择的星期
		static public String getSelectWeekToString(boolean [] check){
			String str = null ;
			String str2 = null;
			for(int i = 0; i < check.length; i++){
				if(check[i]){
					str += getWeek()[i];
				}
			}
			str2 = str.substring(4, str.length() - 1);
			return str2;
		}
		
		static public boolean [] getSelectWeekToBoolean(Context context){
			MyService ms = new MyService(context);
			List<WeekBean> list = ms.getWeek();
			boolean [] checked = new boolean []{false,false,false,false,false,false,false};
			
			for(int i = 0; i < list.size(); i++){
					if(list.get(i).getSelect() == 1){
						checked[i] = true;
					}else{
						checked[i] = false;
					}
				}
				ms.close();
				return checked;
		}
		
		//设置时间
		static public Calendar setCalendar(int hour, int minute,int day) {
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.HOUR_OF_DAY, hour);//设置小时
			cal.set(Calendar.MINUTE, minute);// 设置分钟
			cal.set(Calendar.SECOND, 0);//设置秒
			cal.set(Calendar.MILLISECOND, 0);// 设置毫秒
			cal.set(Calendar.DAY_OF_MONTH,
					cal.get(Calendar.DAY_OF_MONTH) + day);
			Log.i("now",""+ cal.get(Calendar.DAY_OF_MONTH));
			return cal;
		}
		
		static public int getToDayToNextDay(Context context){
			
			int day = 0;
			
			boolean [] check = getSelectWeekToBoolean(context);
			
			Calendar cal = Calendar.getInstance();
			cal.setTimeInMillis(System.currentTimeMillis());
			
			int toDay = cal.get(Calendar.DAY_OF_WEEK);
			int hour = cal.get(Calendar.HOUR_OF_DAY);
			int minute = cal.get(Calendar.MINUTE);
			//星期日是第一天  1,星期六是最后一天  7.
			
			//判断下一天是否重复
			if(check[toDay - 1]){
				day = 1;
			//	Log.i("next", ""+day);
			}else{
				
				for(int i = toDay; i < check.length; i++ ){
					if(check[i]){
						day = i;
						break;
					}
				}
				if(day == 0){
					for(int i = 0; i < check.length; i++ ){
						if(check[i]){
							day = i;
							break;
						}
					}
				}
				//Log.i("toDay",""+day);
			}
			return day;
		}
		
		static public int getMinuteOfDay(int day){
			return day*24*60;
		}
}
