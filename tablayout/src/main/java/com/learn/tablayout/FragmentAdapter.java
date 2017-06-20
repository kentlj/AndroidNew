package com.learn.tablayout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.learn.tablayout.fragment.BaseFragment;
import com.learn.tablayout.fragment.FirstFragment;
import com.learn.tablayout.fragment.ThirdFragment;
import com.learn.tablayout.fragment.SecondFragment;

/**
 * Created by yui on 2016/12/9.
 */

public class FragmentAdapter extends FragmentPagerAdapter {
    private BaseFragment fragment;

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
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "广场";
            case 1:
                return "好友";
            case 2:
                return "我";
            default:
                return "微博";
        }
    }
}
