package com.learn.palette.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.learn.palette.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SecondFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SecondFragment extends BaseFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String Tag = "tag";
    private static int mType;




    public static SecondFragment newInstance(int type) {
        SecondFragment fragment = new SecondFragment();
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
        return R.layout.fragment_second;
    }

    public static int getmType() {
        return mType;
    }
}
