package com.learn.transition;

import android.os.Bundle;
import android.transition.ChangeTransform;
import android.transition.Transition;


public class SceneChangeTransformActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scene_change_transform);
        initToolbar();
        initScene(R.id.rootview,R.layout.scene_1_changetransform,R.layout.scene_2_changetransform);

    }

    @Override
    Transition getTransition() {
        return new ChangeTransform();
    }


}

