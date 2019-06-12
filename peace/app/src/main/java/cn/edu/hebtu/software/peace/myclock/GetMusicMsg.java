package cn.edu.hebtu.software.peace.myclock;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.MediaStore;

public class GetMusicMsg {
	private Cursor cursor;
	private ContentResolver c;
	public GetMusicMsg(ContentResolver cr){
		c = cr;
		cursor = c.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, 
						null, 
						null,
						null, 
						MediaStore.Audio.Media.DEFAULT_SORT_ORDER);
	}
	
	public String getTitle(){
		return cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.TITLE));
		
		
	}
}
