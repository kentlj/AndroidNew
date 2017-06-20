package com.learn.palette;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.learn.palette.fragment.BaseFragment;
import com.learn.palette.fragment.FifthFragment;
import com.learn.palette.fragment.FirstFragment;
import com.learn.palette.fragment.ForthFragment;
import com.learn.palette.fragment.SecondFragment;
import com.learn.palette.fragment.ThirdFragment;

/**
 * Created by yui on 2016/12/4.
 */

public class FragmentAdapter extends FragmentStatePagerAdapter {
    private BaseFragment fragment;
    private String tabTitles[] = new String[]{"主页", "分享", "收藏", "关注", "关注者"};

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        int type;
        switch (position) {
            case 0:
                type = FirstFragment.getmType();
                fragment = FirstFragment.newInstance(type);
                break;
            case 1:
                type = SecondFragment.getmType();
                fragment = SecondFragment.newInstance(type);
                break;
            case 2:
                type = ThirdFragment.getmType();
                fragment = ThirdFragment.newInstance(type);
                break;
            case 3:
                type = ForthFragment.getmType();
                fragment = ForthFragment.newInstance(type);
                break;
            case 4:
                type = FifthFragment.getmType();
                fragment = FifthFragment.newInstance(type);
                break;
        }

        return fragment;

    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
