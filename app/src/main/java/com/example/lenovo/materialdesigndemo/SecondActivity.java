package com.example.lenovo.materialdesigndemo;

import android.app.Activity;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/**
 * Created by lenovo on 7/6/2016.
 */
public class SecondActivity extends Activity implements View.OnTouchListener {

    float x=0;
    float y;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //允许使用transitions动画
        int flag=getIntent().getExtras().getInt("type");

        switch(flag)
        {
            case 1:
                Fade fade=new Fade();
                fade.setDuration(400);
                getWindow().setEnterTransition(fade);
                break;
            case 2:
                ChangeBounds b=new ChangeBounds();
                b.setDuration(300);
                getWindow().setSharedElementEnterTransition(b);
            //    getWindow().setSharedElementReturnTransition(new Slide());
                break;
            case 3:
                Toast.makeText(SecondActivity.this, "enter", Toast.LENGTH_SHORT).show();
                Explode ex=new Explode();
                ex.setDuration(400);
                getWindow().setEnterTransition(ex);
                break;
            case 4:
                Slide slide1=new Slide();
                slide1.setDuration(200);
                slide1.setSlideEdge(Gravity.RIGHT);
                getWindow().setEnterTransition(slide1);
                break;
        }

        View contentview=View.inflate(this,R.layout.secondactivity,null);
        setContentView(contentview);

        contentview.setOnTouchListener(this);
        /*setCon
        setContentView(R.layout.secondactivity);*/
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                 x=event.getX();
                 y=event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                float dx=event.getX()-x;
                v.offsetLeftAndRight((int)(dx));
                break;
            case MotionEvent.ACTION_UP:
                event.getX();
                break;
        }
        return true;
    }
}
