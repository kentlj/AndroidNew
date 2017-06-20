package com.learn.swiperefreshlayout;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {
    private ArrayList<String> data;
    private MyAdapter myAdapter;
    private boolean isRefresh = false;

    @BindView(R.id.recycle)
    RecyclerView recycle;
    @BindView(R.id.swipe)
    SwipeRefreshLayout swipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
        swipe.setColorSchemeColors(Color.BLUE, Color.GREEN,
                Color.YELLOW,
                Color.RED);

        // 设置手指在屏幕下拉多少距离会触发下拉刷新
        swipe.setDistanceToTriggerSync(300);
        // 设定下拉圆圈的背景
        swipe.setProgressBackgroundColorSchemeColor(Color.WHITE);
        // 设置圆圈的大小
        swipe.setSize(SwipeRefreshLayout.LARGE);
        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (!isRefresh) {
                    isRefresh = true;
                    //模拟加载网络数据，这里设置4秒，正好能看到4色进度条
                    new  android.os.Handler().postDelayed(new Runnable() {
                        public void run() {

                            //显示或隐藏刷新进度条
                            swipe.setRefreshing(false);
                            //修改adapter的数据
                            data.add("这是新添加的数据");
                            myAdapter.notifyDataSetChanged();
                            isRefresh = false;
                        }
                    }, 4000);
                }

            }
        });
        recycle.setLayoutManager(new LinearLayoutManager(this));
        recycle.setHasFixedSize(true);
        myAdapter = new MyAdapter(this, data);
        recycle.setAdapter(myAdapter);
    }

    private void init() {
        data = new ArrayList<String>();
        for (int i = 1; i < 30; i++) {
            data.add("这是第" + i + "个数据");
        }
    }
}
