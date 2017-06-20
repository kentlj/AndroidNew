package com.learn.tint;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView im3 = (ImageView) findViewById(R.id.imageView3);
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.icon);
        Drawable.ConstantState state = drawable.getConstantState();
        Drawable drawable4 = DrawableCompat.wrap(state == null ? drawable : state.newDrawable().mutate());
        drawable4.setBounds(0,0,drawable.getIntrinsicWidth(),drawable.getIntrinsicHeight());
        DrawableCompat.setTint(drawable4,ContextCompat.getColor(this, R.color.blue));
        im3.setImageDrawable(drawable4);


    }




}
