package com.example.mytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mytest.flow.FlowActivity;
import com.example.mytest.layout.LayoutActivity;
import com.example.mytest.recycler.RecyclerActivity;
import com.example.mytest.scroll.ScrollActivity;
import com.example.mytest.viewgroup.OverFrameLayoutActivity;
import com.example.mytest.viewgroup.OverRelativeActivity;
import com.example.mytest.waterfall.WaterFallActivity;

public class MainActivity extends AppCompatActivity {

    Button btnLayout,btnScroll;
    Button btnViewgroupFrame;
    Button btnViewGroupRelative;
    Button btnFlow;
    Button btnWater;
    Button btnRecycler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initView();
        setListener();
    }

    /**
     * 设置点击事件
     */
    private void setListener() {
        //布局
        btnLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,LayoutActivity.class));
            }
        });
        //ScrollView重构ListView优化
        btnScroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,ScrollActivity.class));
            }
        });
        //重构FrameLayout
        btnViewgroupFrame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,OverFrameLayoutActivity.class));
            }
        });
        //重构RelativeLayout
        btnViewGroupRelative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,OverRelativeActivity.class));
            }
        });
        //流式布局
        btnFlow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,FlowActivity.class));
            }
        });
        //瀑布流
        btnWater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,WaterFallActivity.class));
            }
        });
        btnRecycler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,RecyclerActivity.class));
            }
        });
    }


    /**
     * 初始化View
     */
    private void initView() {
        btnLayout = (Button) findViewById(R.id.btn_Layout);
        btnScroll = (Button) findViewById(R.id.btn_Scroll);
        btnViewgroupFrame = (Button) findViewById(R.id.btn_viewgroup_frame);
        btnFlow = (Button) findViewById(R.id.btn_Flow);
        btnWater = (Button) findViewById(R.id.btn_Water);
        btnRecycler = (Button) findViewById(R.id.btn_Recycler);
        btnViewGroupRelative = (Button) findViewById(R.id.btn_viewgroup_relative);
    }

}
