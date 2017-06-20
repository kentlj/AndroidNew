package com.learn.palette.fragment;

import android.os.Bundle;

import com.learn.palette.R;

public class ThirdFragment extends BaseFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String Tag = "tag";
    private static int mType;




    public static ThirdFragment newInstance(int type) {
        ThirdFragment fragment = new ThirdFragment();
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
        return R.layout.fragment_third;
    }

    public static int getmType() {
        return mType;
    }
}
