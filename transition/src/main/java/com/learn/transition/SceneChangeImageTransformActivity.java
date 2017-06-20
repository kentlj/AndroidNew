package com.learn.transition;

import android.os.Bundle;
import android.transition.ChangeImageTransform;
import android.transition.Transition;


public class SceneChangeImageTransformActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scene_change_image_transform);
        initToolbar();
        initScene(R.id.rootview,R.layout.scene_1_changeimagetransform,R.layout.scene_2_changeimagetransform);

    }

    @Override
    Transition getTransition() {
        return new ChangeImageTransform();
    }
}
