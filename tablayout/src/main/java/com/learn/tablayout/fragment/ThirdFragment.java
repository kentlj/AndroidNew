package com.learn.tablayout.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.learn.tablayout.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ThirdFragment extends BaseFragment {
    private static final String FRAGMENT_TYPE = "TYPE";
    private static int mType;

    public static ThirdFragment newInstance(int type) {
        Bundle args = new Bundle();
        args.putInt(FRAGMENT_TYPE, type);
        ThirdFragment fragment = new ThirdFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mType = this.getArguments().getInt(FRAGMENT_TYPE);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_third;
    }

    public static int getmType() {
        return mType;
    }
}
