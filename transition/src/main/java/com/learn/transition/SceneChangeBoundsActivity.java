package com.learn.transition;

import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Transition;


public class SceneChangeBoundsActivity extends BaseActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scene_change_bounds);
        initToolbar();
        initScene(R.id.rootview,R.layout.scene_1_changebounds,R.layout.scene_2_changebounds);

    }

    @Override
    Transition getTransition() {
        return new ChangeBounds();
    }

}
