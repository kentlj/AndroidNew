package com.learn.tablayout.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseFragment extends Fragment {



//创建不同的fragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(getLayoutResId(), container, false);
        ButterKnife.bind(this,view);
        return view;

    }
    //
    protected abstract int getLayoutResId();

    //不同fragment的展示逻辑
    protected void initView(View v, Bundle savedInstanceState){

    }

}
