package com.learn.palette.fragment;

import android.os.Bundle;

import com.learn.palette.R;

public class ForthFragment extends BaseFragment {
    private static final String Tag = "tag";
    private static int mType;




    public static ForthFragment newInstance(int type) {
        ForthFragment fragment = new ForthFragment();
        Bundle args = new Bundle();
        args.putInt(Tag, type);
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
        return R.layout.fragment_forth;
    }

    public static int getmType() {
        return mType;
    }
}
