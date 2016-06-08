package com.example.lenovo.materialdesigndemo;

import android.animation.Animator;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView image;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  getWindow().setExitTransition(new Explode());
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        button1= (Button) findViewById(R.id.button1);
        button2= (Button) findViewById(R.id.button2);
        button3= (Button) findViewById(R.id.button3);
        button4= (Button) findViewById(R.id.button4);
        image= (ImageView) findViewById(R.id.image);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        image.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {


        switch (v.getId())
        {
            case R.id.button1:
                Intent intent=new Intent();
                intent.putExtra("type",1);
                intent.setClass(MainActivity.this, SecondActivity.class);
                startActivity(intent,
                        ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
                break;
            case R.id.button2:

                Intent intent2=new Intent();
                intent2.putExtra("type",2);
                intent2.setClass(MainActivity.this, SecondActivity.class);
                startActivity(intent2,
                        ActivityOptions.makeSceneTransitionAnimation
                                (this,button2,"shareelement").toBundle());
                break;

            case R.id.button3:
                Intent intent3=new Intent();
                intent3.putExtra("type",3);
                intent3.setClass(MainActivity.this, SecondActivity.class);
                startActivity(intent3,
                        ActivityOptions.makeSceneTransitionAnimation(this).toBundle());

                break;

            case R.id.button4:
                Intent intent4=new Intent();
                intent4.putExtra("type",4);
                intent4.setClass(MainActivity.this, SecondActivity.class);
                startActivity(intent4,
                        ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
                break;
            case R.id.image:
                Animator animator= ViewAnimationUtils.createCircularReveal(image, image.getWidth() / 2, image.getHeight() / 2,
                        image.getWidth(), 0);
                animator.setInterpolator(new AccelerateDecelerateInterpolator());
                animator.setDuration(1000);
                animator.start();
                break;
        }
    }
}
