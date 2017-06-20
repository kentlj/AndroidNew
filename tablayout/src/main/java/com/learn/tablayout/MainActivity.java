package com.learn.tablayout;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.viewpage)
    MyViewPager viewpage;
    @BindView(R.id.tablayout)
    TabLayout tablayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //        requestWindowFeature(FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        FragmentManager fm = getSupportFragmentManager();
        viewpage.setAdapter(new FragmentAdapter(fm));
        viewpage.setPagingEnabled(false);
        tablayout.setupWithViewPager(viewpage);
       //在这里添加增加图标方法
        addIcon();
        tablayout.setTabMode(TabLayout.MODE_FIXED);
    }

    private void addIcon() {
        for (int i = 0; i < tablayout.getTabCount(); i++) {
            tablayout.getTabAt(i).setIcon(R.mipmap.ic_launcher_round);
        }
    }


}
