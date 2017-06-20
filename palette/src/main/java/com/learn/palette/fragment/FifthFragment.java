package com.learn.palette.fragment;

import android.os.Bundle;

import com.learn.palette.R;

public class FifthFragment extends BaseFragment {
    private static final String Tag = "tag";
    private static int mType;


    public static FifthFragment newInstance(int type) {
        FifthFragment fragment = new FifthFragment();
        Bundle args = new Bundle();
        args.putInt(Tag, type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mType = getArguments().getInt(Tag);
        }
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_fifth;
    }

    public static int getmType() {
        return mType;
    }
}
