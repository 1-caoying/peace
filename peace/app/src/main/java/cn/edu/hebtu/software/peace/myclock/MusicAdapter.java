package cn.edu.hebtu.software.peace.myclock;

import java.util.List;
import java.util.Map;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import cn.edu.hebtu.software.peace.R;

public class MusicAdapter extends BaseAdapter{
	private LayoutInflater mInflater;
	private List<Map<String, Object>> data;
	private Context context;
	
	public MusicAdapter(Context context,List<Map<String, Object>> data){
		this.mInflater = LayoutInflater.from(context);
		this.data = data;
		this.context = context;
	}
	
	public final class ViewHolder {
		public TextView title;
		public TextView url;
		public TextView album;
		public TextView singer;
		public TextView time;
		public TextView id;
		public ImageView imageView;
		
	}
	
	public int getCount() {
		return data.size();
	}

	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		//添加组件
				ViewHolder vh = new ViewHolder();
				//添加布局文件
				
				if(convertView == null){
					convertView = mInflater.inflate(R.layout.musiclist, null);
					vh.title = (TextView)convertView.findViewById(R.id.musictitle);
					vh.url = (TextView)convertView.findViewById(R.id.musicurl);
					vh.album = (TextView)convertView.findViewById(R.id.musicalbum);
					vh.singer = (TextView)convertView.findViewById(R.id.musicsinger);
					vh.time = (TextView)convertView.findViewById(R.id.musictime);
					vh.id = (TextView)convertView.findViewById(R.id.musicid);
					vh.imageView = (ImageView)convertView.findViewById(R.id.list_radioImg);
					convertView.setTag(vh);
					
				}else{
					vh = (ViewHolder)convertView.getTag();
				}
				vh.title.setText((String)data.get(position).get("title"));
				vh.url.setText((String)data.get(position).get("url"));
				vh.album.setText((String)data.get(position).get("album"));
				vh.singer.setText((String)data.get(position).get("singer"));
				vh.time.setText((String)data.get(position).get("time"));
				vh.id.setText((String)data.get(position).get("id"));
		
		return convertView;
	}
		
}
