package com.example.partyfun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static int timeout = 3000;
    TextView txt ;
    ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt=findViewById(R.id.txt);
        img=findViewById(R.id.img);

        Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.animi);
        img.startAnimation(animation);
        txt.startAnimation(animation);

        Handler handler = new Handler ();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(MainActivity.this, MainActivity1.class);
                startActivity(intent);

            }
        },timeout);

    }
}