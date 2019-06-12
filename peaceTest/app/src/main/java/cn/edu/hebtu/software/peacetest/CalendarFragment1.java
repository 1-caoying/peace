package cn.edu.hebtu.software.peacetest;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class CalendarFragment1 extends Fragment {
    private LetterSpacingTextView calendar_sentence;
    private String s;
    private int length;
    int n=0;
    private int nn;
    private TextUtil textUtil;

    private ThumbUpView zan;
    private TextView zan_num;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.calendar1, null);
        calendar_sentence=view.findViewById(R.id.calendar_sentence);
        s = "信念是鸟，它在黎明仍然黑\n暗之际，感觉到了光明。";
        textUtil = new TextUtil(calendar_sentence, s, 150);//调用构造方法，直接开启
        calendar_sentence.setSpacing(15);
        calendar_sentence.setText(s);
//        zan = view.findViewById(R.id.zan);
//        zan.setUnLikeType(ThumbUpView.LikeType.broken);
//        zan.setCracksColor(Color.WHITE);
//        zan.setFillColor(Color.rgb(255, 106, 106));
//        zan.setEdgeColor(Color.rgb(205, 201, 201));
//        zan_num = view.findViewById(R.id.zan_num);
//
//        zan.setOnThumbUp(new ThumbUpView.OnThumbUp() {
//            @Override
//            public void like(boolean like) {
//                if (like) {
//                    zan_num.setText(String.valueOf(Integer.valueOf(zan_num.getText().toString()) + 1));
//
//                } else {
//                    zan_num.setText(String.valueOf(Integer.valueOf(zan_num.getText().toString()) - 1));
//                }
//            }
//        });
//
        return view;
//    }
//    public void like(View v) {
//        zan.Like();
//
//    }
//
//    public void unlike(View v) {
//        zan.UnLike();
    }

}