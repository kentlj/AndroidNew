package com.learn.transition;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;


/**
 *
 */
public class BeginDelayedActivity extends AppCompatActivity {
    private boolean isImageBigger;
    private int primarySize;

    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    @InjectView(R.id.cuteboy)
    CircleImageView cuteboy;
    @InjectView(R.id.cutegirl)
    CircleImageView cutegirl;
    @InjectView(R.id.hxy)
    CircleImageView hxy;
    @InjectView(R.id.lly)
    CircleImageView lly;
    @InjectView(R.id.scene_root)
    RelativeLayout sceneRoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_begin_delayed);
        ButterKnife.inject(this);
        setSupportActionBar(toolbar);
        primarySize = cuteboy.getLayoutParams().width;
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    /**
     * @param view
     */
    @OnClick({R.id.cuteboy, R.id.cutegirl, R.id.hxy, R.id.lly})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.cuteboy:

                Transition transition = TransitionInflater.from(this).inflateTransition(R.transition.explode);
                TransitionManager.beginDelayedTransition(sceneRoot, transition);

                changeScene(view);
                break;

            case R.id.cutegirl:
                Transition transition1 = TransitionInflater.from(this).inflateTransition(R.transition.fade);
                TransitionManager.beginDelayedTransition(sceneRoot, transition1);

                changeScene(view);
                break;

            case R.id.hxy:
                Transition transition2 = TransitionInflater.from(this).inflateTransition(R.transition.slide);
                TransitionManager.beginDelayedTransition(sceneRoot, transition2);

                changeScene(view);
                break;

            case R.id.lly:
                //                Transition transition3 = TransitionInflater.from(this).inflateTransition(R
                // .transition.explode);
                //默认效果
                TransitionManager.beginDelayedTransition(sceneRoot);

                changeScene(view);
                break;
        }
    }


    /**
     * 代码动态改变scene各个view属性
     *
     * @param view
     */
    private void changeScene(View view) {
        changeSize(view);
        changeVisibility(cuteboy, cutegirl, hxy, lly);
        //       使当前view可见
        view.setVisibility(View.VISIBLE);
    }


    /**
     * VISIBLE和INVISIBLE状态切换
     *
     * @param views
     */

    private void changeVisibility(View... views) {
        for (View view : views) {
            view.setVisibility(view.getVisibility() == View.VISIBLE ? View.INVISIBLE : View.VISIBLE);
        }
    }

    /**
     * view的宽高1.5倍和原尺寸大小切换
     * 配合ChangeBounds实现缩放效果
     *
     * @param view
     */
    private void changeSize(View view) {
        isImageBigger = !isImageBigger;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (isImageBigger) {
            layoutParams.width = (int) (1.5 * primarySize);
            layoutParams.height = (int) (1.5 * primarySize);
        } else {
            layoutParams.width = primarySize;
            layoutParams.height = primarySize;
        }
        view.setLayoutParams(layoutParams);
    }

}
