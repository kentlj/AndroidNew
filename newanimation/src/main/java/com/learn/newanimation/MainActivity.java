package com.learn.newanimation;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.PathInterpolator;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.bt1)
    ImageButton bt1;
    @InjectView(R.id.bt2)
    ImageButton bt2;
    @InjectView(R.id.curved)
    Button curved;
    @InjectView(R.id.vector_anim)
    ImageView im1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

    }

    @OnClick({R.id.bt1, R.id.bt2, R.id.curved,R.id.vector_anim})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt1:
                show();
                break;
            case R.id.bt2:
                hide();
                break;
            case R.id.curved:
                curved1();
            case R.id.vector_anim:
                vectorAnim();
                break;
        }
    }

    //适量动画
    private void vectorAnim() {
        AnimatedVectorDrawable vectorDrawable = (AnimatedVectorDrawable) getResources().getDrawable(R.drawable
                .animated_vector_heart);
        im1.setImageDrawable(vectorDrawable);
        if (vectorDrawable != null) {
            vectorDrawable.start();
        }


    }

    //放大
    void show() {

        int radius = Math.max(bt1.getWidth(), bt1.getHeight());
        Animator reveal = ViewAnimationUtils.createCircularReveal(bt1, 0, bt1.getHeight(), 0, radius);
        bt1.setVisibility(View.VISIBLE);
        reveal.setDuration(2000).start();

    }

    //缩小
    void hide() {


        // get the initial radius for the clipping circle
        int radius = bt2.getWidth();

        // create the animation (the final radius is zero)r
        Animator anim =
                ViewAnimationUtils.createCircularReveal(bt2, bt2.getWidth(), 0, radius, 0);

        // make the view invisible when the animation is done
        //        anim.addListener(new AnimatorListenerAdapter() {
        //            @Override
        //            public void onAnimationEnd(Animator animation) {
        //                super.onAnimationEnd(animation);
        //                bt2.setVisibility(View.INVISIBLE);
        //            }
        //        });

        // start the animation
        bt1.setVisibility(View.VISIBLE);
        anim.setDuration(2000).start();

    }

    //曲线运动
    void curved1() {
        Path path = new Path();
        path.lineTo(0, 300);
        path.cubicTo(100, 0, 300, 900, 500, 600);
        PathInterpolator pathInterpolator = new PathInterpolator(0.8f, 0f, 1f, 1f);
        ObjectAnimator mAnimator;
        mAnimator = ObjectAnimator.ofFloat(curved, View.X, View.Y, path);
        mAnimator.setInterpolator(pathInterpolator);
        mAnimator.setDuration(3000);
        mAnimator.start();

    }

}
