package cn.edu.hebtu.software.peacetest;

import java.util.ArrayList;
import java.util.List;
//import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
//import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.AppCompatActivity;


public class CalenderActivity extends AppCompatActivity{

    private ViewPager viewPager;
    private List<Fragment> list;
    private FragmentPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar);
        InitView();




// 设置菜单栏的点击事件
//        tv_item_one.setOnClickListener(this);
//        tv_item_two.setOnClickListener(this);
//        tv_item_three.setOnClickListener(this);
//        viewPager.setOnPageChangeListener(new MyPagerChangeListener());

//把Fragment添加到List集合里面
        list = new ArrayList<>();
        list.add(new CalendarFragment3());
        list.add(new CalendarFragment2());
        list.add(new CalendarFragment1());

        adapter = new CalendarFragmentAdapter(getSupportFragmentManager(), list);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(2);  //初始化显示第一个页面
    }

    /**
     * 初始化控件
     */
    private void InitView() {
        viewPager= (ViewPager) findViewById(R.id.viewpager);
    }


    /**
     * 设置一个ViewPager的侦听事件，当左右滑动ViewPager时菜单栏被选中状态跟着改变
     *
     */
//    public class MyPagerChangeListener implements ViewPager.OnPageChangeListener {
//            int currentPosition=0;
//        @Override
//        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//            if (position>currentPosition) {
//                //右滑
//                currentPosition=position;
//            }else if (position<currentPosition){
//                //左滑
//                currentPosition=position;
//            }
//        }
//
//        @Override
//        public void onPageSelected(int position) {
//        }
//
//        @Override
//        public void onPageScrollStateChanged(int state) {
//
//        }
//    }

}
