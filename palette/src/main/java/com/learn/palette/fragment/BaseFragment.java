package com.learn.palette.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.learn.palette.R;

import butterknife.ButterKnife;



public abstract class BaseFragment extends Fragment {


    public static final int[] drawables = {R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four, R
            .drawable.five};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(getLayoutResId(), container, false);
        ButterKnife.inject(this, view);
        return view;
    }

    protected abstract int getLayoutResId();

    protected void initView(View v, Bundle savedInstanceState) {

    }

    public static int getBackgroundBitmapPosition(int selectViewPagerItem) {
        return drawables[selectViewPagerItem];
    }
}
