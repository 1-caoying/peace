//package cn.edu.hebtu.software.peacetest.test;
//
//
//import android.test.AndroidTestCase;
//import android.util.Log;
//
//import java.util.List;
//
//import cn.edu.hebtu.software.peace.bean.WeekBean;
//import cn.edu.hebtu.software.peace.service.MyService;
//import cn.edu.hebtu.software.peacetest.bean.WeekBean;
//import cn.edu.hebtu.software.peacetest.service.MyService;
//
//public class test extends AndroidTestCase {
//		public void add(){
//			MyService ws = new MyService(this.getContext());
//			//ws.add();
//		}
//		public void query(){
//			MyService ws = new MyService(this.getContext());
//
//			List<WeekBean> list = ws.getWeek();
//
//			for(int i = 0; i < list.size(); i++){
//				Log.i("ID","ID:" + list.get(i).getId()+",boolean:"+list.get(i).getSelect());
//			}
//
//		}
//		public void update(){
//			MyService ws = new MyService(this.getContext());
//			ws.updateWeek(1, 7);
//		}
//}
