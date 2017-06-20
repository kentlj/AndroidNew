package com.learn.outlines;

import android.content.Context;
import android.graphics.Outline;
import android.graphics.Path;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    TextView tv1,tv2,circle1,circle2,cut1,cut2,cut3,cut4,cut5,cut6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        circle1 = (TextView) findViewById(R.id.tv_circle_1);
        circle2 = (TextView) findViewById(R.id.tv_circle_2);
        ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                outline.setOval(0, 0, view.getWidth(), view.getHeight());
            }
        };
        circle1.setOutlineProvider(viewOutlineProvider);


        viewOutlineProvider = new ViewOutlineProvider() {
            public void getOutline(View view, Outline outline) {
                // 可以指定圆形，矩形，圆角矩形，path
                outline.setOval(50, 50, view.getWidth() - 100, view.getHeight() - 100);
            }
        };
        circle2.setOutlineProvider(viewOutlineProvider);

        cut(this);
    }


    private void cut(Context ctx){
        cut1 = (TextView) findViewById(R.id.cut1);
        cut2 = (TextView) findViewById(R.id.cut2);
        cut3 = (TextView) findViewById(R.id.cut3);
        cut4 = (TextView) findViewById(R.id.cut4);
        cut5 = (TextView) findViewById(R.id.cut5);
        cut6 = (TextView) findViewById(R.id.cut6);
        final boolean[] flag = {true};

        ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider() {
            public void getOutline(View view, Outline outline) {
                Path p = new Path();
                p.moveTo(view.getWidth()/2,0);
                p.lineTo(0,view.getHeight());
                p.lineTo(view.getWidth(),view.getHeight());
                p.close();
                outline.setConvexPath(p);
                flag[0] = outline.canClip();
            }
        };
        cut2.setOutlineProvider(viewOutlineProvider);
        cut2.setClipToOutline(true);

        viewOutlineProvider = new ViewOutlineProvider() {
            public void getOutline(View view, Outline outline) {
                outline.setOval(0,0,view.getWidth(),view.getHeight());
            }
        };
        cut3.setOutlineProvider(viewOutlineProvider);
        cut3.setClipToOutline(true);

        viewOutlineProvider = new ViewOutlineProvider() {
            public void getOutline(View view, Outline outline) {
                outline.setRoundRect(0,0,view.getWidth(),view.getHeight(),25);
            }
        };
        cut4.setOutlineProvider(viewOutlineProvider);
        cut4.setClipToOutline(true);

        viewOutlineProvider = new ViewOutlineProvider() {
            public void getOutline(View view, Outline outline) {
                outline.setRect(-50,-50,view.getWidth() + 100,view.getHeight()+100);
            }
        };
        cut5.setOutlineProvider(viewOutlineProvider);
        cut5.setClipToOutline(true);

        cut5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"View的测量大小:" + v.getMeasuredWidth() + "*" +v.getMeasuredHeight(),Toast.LENGTH_SHORT).show();
            }
        });

        viewOutlineProvider = new ViewOutlineProvider() {
            public void getOutline(View view, Outline outline) {
                outline.setRect(50,50,view.getWidth() - 100,view.getHeight()-100);
            }
        };
        cut6.setOutlineProvider(viewOutlineProvider);
        cut6.setClipToOutline(true);

        cut6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"View的布局大小:" + v.getWidth() + "*" +v.getHeight(),Toast.LENGTH_SHORT).show();
            }
        });
        cut2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,flag[0]+"",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
