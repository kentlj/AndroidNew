package com.learn.palette;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.view.WindowManager;
import com.learn.palette.fragment.BaseFragment;
import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.tab)
    TabLayout tab;
    @InjectView(R.id.viewPager)
    ViewPager viewPager;
    @InjectView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.inject(this);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        FragmentManager fm = getSupportFragmentManager();
        viewPager.setAdapter(new FragmentAdapter(fm));
        tab.setupWithViewPager(viewPager);
        tab.setTabMode(TabLayout.MODE_SCROLLABLE);

        palette1(0);

        //viewpager滑动监听
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                palette1(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void palette1(int position) {

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), BaseFragment.getBackgroundBitmapPosition
                (position));
        Palette.Builder builder = Palette.from(bitmap);
        builder.generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                Palette.Swatch swatch = palette.getVibrantSwatch();
                tab.setBackgroundColor(swatch.getRgb());
                tab.setSelectedTabIndicatorColor(Color.RED);
                toolbar.setBackgroundColor(swatch.getRgb());
            }
        });
    }


}
