package com.example.mytest.flow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mytest.R;

import static com.example.mytest.R.drawable.popup_corner;

public class FlowActivity extends AppCompatActivity {

    FlowLayout mFlowLayout;
    String[] names = {"戏命师.晋", "卡密尔", "黛安娜",  "霞", "@小马快跑", "_德玛西亚之力_", "奥瑞利安", "狄仁杰", "典韦", "韩信",
            "老夫子", "刘邦", "刘禅", "鲁班七号", "墨子", "孙膑", "孙尚香", "孙悟空", "项羽", "亚瑟",
            "周瑜", "庄周", "蔡文姬", "甄姬", "廉颇", "程咬金", "后羿", "扁鹊", "钟无艳", "小乔", "王昭君", "虞姬",
            "李元芳", "张飞", "刘备", "牛魔", "张良", "兰陵王", "露娜", "貂蝉", "达摩", "曹操", "芈月", "荆轲", "高渐离",
            "钟馗", "花木兰", "关羽", "李白", "宫本武藏", "白起","吕布", "嬴政", "娜可露露", "武则天", "赵云", "姜子牙",

            "蔡文姬", "甄姬", "廉颇", "程咬金", "后羿", "扁鹊", "钟无艳", "小乔", "王昭君", "虞姬",
            "李元芳", "张飞", "刘备", "牛魔", "张良", "兰陵王", "露娜", "貂蝉", "达摩", "曹操", "芈月", "荆轲", "高渐离",
            "钟馗", "花木兰", "关羽", "李白", "宫本武藏", "白起","吕布", "嬴政", "娜可露露", "武则天", "赵云", "姜子牙",
            "蔡文姬", "甄姬", "廉颇", "程咬金", "后羿", "扁鹊", "钟无艳", "小乔", "王昭君", "虞姬",
            "李元芳", "张飞", "刘备", "牛魔", "张良", "兰陵王", "露娜", "貂蝉", "达摩", "曹操", "芈月", "荆轲", "高渐离",
            "钟馗", "花木兰", "关羽", "李白", "宫本武藏", "白起","吕布", "嬴政", "娜可露露", "武则天", "赵云", "姜子牙"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flow);

        mFlowLayout = (FlowLayout) findViewById(R.id.flowLayout);
        for(String name : names){
            TextView tv = (TextView) LayoutInflater.from(this).inflate(R.layout.item_flow_layout,mFlowLayout,false);
            tv.setBackgroundResource(popup_corner);
            tv.setText(name);
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(FlowActivity.this, ""+((TextView)view).getText(), Toast.LENGTH_SHORT).show();
                }
            });
            mFlowLayout.addView(tv);
        }

    }
}
