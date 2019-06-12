package cn.edu.hebtu.software.peacetest.service;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import cn.edu.hebtu.software.peacetest.bean.WeekBean;
import cn.edu.hebtu.software.peacetest.sqlite.DataBaseHelper;

public class MyService {
	private DataBaseHelper dh;
	private SQLiteDatabase db;
	private Cursor cursor;
	
	public MyService(Context context){
		dh = new DataBaseHelper(context);
	}
	
	
	public List<WeekBean> getWeek(){
		
		List<WeekBean> list = new ArrayList<WeekBean>();
	//	List list = new ArrayList();
		
		WeekBean week;
		//getReadableDatabase()并不是以只读方式打开数据库，
		//而是先执行getWritableDatabase()，失败的情况下才调用
		SQLiteDatabase db = dh.getReadableDatabase();
		
		cursor = db.query(dh.NAME, null, null, null, null, null, null);
		
		while(cursor.moveToNext()){
			week = new WeekBean();
			week.setId(cursor.getInt(0));
			week.setSelect(cursor.getInt(1));
			
			list.add(week);
		}
		cursor.close();
		db.close();
		return list;
	}
	public void close(){
		dh.close();
	}
	/**
	 * 更新重复的星期
	 * @param select:  更新星期，0为false,1为true
	 * @param id： ID
	 */
	public void updateWeek(int select,int id){
		//getWritableDatabase() 方法以读写方式打开数据库，
		//一旦数据库的磁盘空间满了，数据库就只能读而不能写
		SQLiteDatabase db = dh.getWritableDatabase();
		db.execSQL("update "+dh.NAME+" set week=? where id=?",new Object[]{select,id});
		cursor.requery();
	}
	
	public void saveMusicURL(String url){
		
	}
}
