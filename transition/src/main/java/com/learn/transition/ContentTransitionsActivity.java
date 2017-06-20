package com.learn.transition;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.transition.Fade;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class ContentTransitionsActivity extends AppCompatActivity {

    @InjectView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_transitions);
        ButterKnife.inject(this);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        Explode explode = new Explode();
        explode.setDuration(5000);
        int id = getResources().getIdentifier("statusBarBackground", "id", "android");
        explode.excludeTarget(id,true);
        getWindow().setEnterTransition(explode);

        Fade fade = new Fade();
        fade.setDuration(3000);
        getWindow().setReturnTransition(fade);


    }
}
