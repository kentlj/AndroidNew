package com.learn.transition;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public abstract class BaseActivity extends AppCompatActivity {
    protected Button button;
    protected Scene scene1;
    protected Scene scene2;
    protected boolean isScene2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    abstract Transition getTransition();

    protected void switchScene(Transition transition) {
        TransitionManager.go(isScene2 ? scene1 : scene2, transition);
        isScene2 = !isScene2;
    }


    protected void initToolbar() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchScene(getTransition());
            }
        });
    }

    protected void initScene(@IdRes int rootView, @LayoutRes int scene1_layout, @LayoutRes int scene2_layout) {
        ViewGroup sceneRoot = (ViewGroup) findViewById(rootView);
        scene1 = Scene.getSceneForLayout(sceneRoot, scene1_layout, this);
        scene2 = Scene.getSceneForLayout(sceneRoot, scene2_layout, this);
        TransitionManager.go(scene1);

    }


}
