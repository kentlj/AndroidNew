package com.learn.transition;

import android.os.Bundle;
import android.transition.Fade;
import android.transition.Transition;


public class SceneFadeSlideExplodeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scene_fade_slide_explode);
        initToolbar();
        initScene(R.id.rootview,R.layout.scene_1_explode,R.layout.scene_2_explode);
    }

    @Override
    Transition getTransition() {
        return new Fade();
    }
}
