package com.learn.tablayout.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.learn.tablayout.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends BaseFragment {
    private static final String FRAGMENT_TYPE = "TYPE";
    private static int mType;

    public static FirstFragment newInstance(int type) {

        Bundle args = new Bundle();
        args.putInt(FRAGMENT_TYPE,type);
        FirstFragment fragment = new FirstFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       mType =  this.getArguments().getInt(FRAGMENT_TYPE);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_first;
    }

    public static int getmType() {
        return mType;
    }
}
