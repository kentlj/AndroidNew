package com.learn.transition;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.card1)
    CardView card1;
    @InjectView(R.id.card2)
    CardView card2;
    @InjectView(R.id.card3)
    CardView card3;
    @InjectView(R.id.card4)
    CardView card4;
    @InjectView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    @OnClick({R.id.card1, R.id.card2, R.id.card3, R.id.card4})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.card1:
                startActivity(new Intent(this, SceneActivity.class));
                break;
            case R.id.card2:
                startActivity(new Intent(this, BeginDelayedActivity.class));
                break;
            case R.id.card3:
                Intent intent = new Intent(this, ContentTransitionsActivity.class);
                ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this);
                startActivity(intent, activityOptionsCompat.toBundle());
                break;
            case R.id.card4:
                startActivity(new Intent(this, ContentAndSharedTransitionActivity.class));
                break;
        }
    }
}
