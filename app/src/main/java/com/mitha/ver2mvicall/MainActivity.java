package com.mitha.ver2mvicall;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.mitha.ver2mvicall.activity.HomeActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.otp_succes);
        blink();
        ConstraintLayout layout=(ConstraintLayout) findViewById(R.id.otp_blink);
        layout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, HomeActivity.class));
            }
        });
    }
    public void blink(){
        ImageView image = findViewById(R.id.imageView2);
        @SuppressLint("ResourceType") Animation animation1 =
                AnimationUtils.loadAnimation(getApplicationContext(),
                        R.animator.blink);
        image.startAnimation(animation1);
    }


}
