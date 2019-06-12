package cn.edu.hebtu.software.peace.sqlite;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper{
	
	public static final String NAME = "clockweek_db";
	public static final String MUSIC_URL = "musicurl_db";
	private static final int version = 1;//版本号不能为0
	/**
	 *
	 * @param context:代表应用的上下文
	 * @param name:代表数据库的名称。
	 * @param factory:代表记录集游标工厂，是专门用来生成记录集游标，
	 * 记录集游标是对查询结果进行迭代的
	 * @param version:代表数据库的版本，如果以后升级软件的时候，需要更改Version 版本号，那么
	onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)方法会被调
	用，在这个方法中比较适合实现软件更新时修改数据库表结构的工作。
	 */
	public DataBaseHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
	}
	public DataBaseHelper(Context context){
		super(context,NAME,null,version);
	}
	/**
	 * 该方法在getReadableDatabase()或getWritableDatabase()时执行，
	 * 只执行一次
	 */
	public void onCreate(SQLiteDatabase db) {
			String sql = "create table " + NAME +" (id int,week tinyint)";
			db.execSQL(sql);
			sql = "create table " + MUSIC_URL + " (id int ,time Time, url string)";
			db.execSQL(sql);
			for(int i = 0; i < 7; i++){
				if(i < 5){
					db.execSQL("insert into clockweek_db values(?,?) ",new Object[]{i,true});
				}else{
					db.execSQL("insert into clockweek_db values(?,?) ",new Object[]{i,false});
				}
			}
	}
	/**
	 * 更换版本是调用此方法
	 */
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		/*String sql = "drop table if exists "+ NAME;
		db.execSQL(sql);*/
	}
		
}
