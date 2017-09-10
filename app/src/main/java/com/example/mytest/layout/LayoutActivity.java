package com.example.mytest.layout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mytest.R;

public class LayoutActivity extends AppCompatActivity {

    Button btnLinear,btnRelative,btnFrame,btnGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);

        btnLinear = (Button) findViewById(R.id.btnLinear);
        btnRelative = (Button) findViewById(R.id.btnRe);
        btnFrame = (Button) findViewById(R.id.btnFrame);
        btnGrid = (Button) findViewById(R.id.btnGrid);

        setListener();

    }

    private void setListener() {
        /**
         * 线性布局
         */
        btnLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LayoutActivity.this,LinearActivity.class));
            }
        });
        /**
         * 相对布局
         */
        btnRelative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LayoutActivity.this,RelativeActivity.class));
            }
        });

        /**
         * 帧布局
         */
        btnFrame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LayoutActivity.this,FrameActivity.class));
            }
        });
        /**
         * 网格布局
         */
        btnGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LayoutActivity.this,GridLayoutActivity.class));
            }
        });
    }


}
