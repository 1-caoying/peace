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


public class MyAdapter extends BaseAdapter {
	private LayoutInflater mInflater;
	private List<Map<String, Object>> data;
	private Context context;
	public final class ViewHolder {
		public ImageView img;
		public TextView title,other;
		
	}
	public MyAdapter(Context context,List<Map<String, Object>> data) {
		this.mInflater = LayoutInflater.from(context);
		this.data = data;
		this.context = context;
	}

	public int getCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		//Log.i("position","" + position);
		//添加组件
		ViewHolder vh = new ViewHolder();
		//添加布局文件
		
		if(convertView == null){
			convertView = mInflater.inflate(R.layout.clocklayout, null);
			vh.title = (TextView)convertView.findViewById(R.id.title);
			vh.other = (TextView)convertView.findViewById(R.id.other);
			//设置显示样式
			
			convertView.setTag(vh);
			
		}else{
			vh = (ViewHolder)convertView.getTag();
		}
		
		vh.img.setBackgroundResource((Integer)data.get(position).get("img"));          
		vh.title.setText((String)data.get(position).get("title"));
		vh.other.setText((String)data.get(position).get("other"));
		return convertView;
	}

}