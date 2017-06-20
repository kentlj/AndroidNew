package com.learn.transition;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class SceneActivity extends AppCompatActivity {

    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    @InjectView(R.id.button1)
    Button button1;
    @InjectView(R.id.button2)
    Button button2;
    @InjectView(R.id.button3)
    Button button3;
    @InjectView(R.id.button4)
    Button button4;
    @InjectView(R.id.button5)
    Button button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scene);
        ButterKnife.inject(this);
        setSupportActionBar(toolbar);

        //在xml中定义title
//        getSupportActionBar().setDisplayShowTitleEnabled(false);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @OnClick({R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button1:
                startActivity(new Intent(this, SceneChangeBoundsActivity.class));
                break;
            case R.id.button2:
                startActivity(new Intent(this, SceneChangeTransformActivity.class));
                break;
            case R.id.button3:
                startActivity(new Intent(this, SceneChangeClipBoundsActivity.class));
                break;
            case R.id.button4:
                startActivity(new Intent(this, SceneChangeImageTransformActivity.class));
                break;
            case R.id.button5:
                startActivity(new Intent(this, SceneFadeSlideExplodeActivity.class));
                break;
        }
    }
}
