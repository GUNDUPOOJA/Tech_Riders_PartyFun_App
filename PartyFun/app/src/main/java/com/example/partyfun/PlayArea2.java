package com.example.partyfun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class PlayArea2 extends AppCompatActivity {
    final Handler handler = new Handler();
    Runnable runnable;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_area);
        Button truth=findViewById(R.id.truth);
        Button dare = findViewById(R.id.dare);

        imageView = (ImageView) findViewById(R.id.imageView);
        final int[] imageArray =
                {R.drawable.logo,  R.drawable.logo, R.drawable.logo, R.drawable.logo,  R.drawable.logo, R.drawable.logo};


        Random r = new Random();
        int timer = r.nextInt(200 - 100) + 30;


        runnable = new Runnable() {
            int i = 0;

            public void run() {
                imageView.setImageURI(SelectImage.temp_image_array.get(i));;
                i++;
                if (i > imageArray.length - 1) {
                    i = 0;
                }
                handler.postDelayed(this, 100);  //for interval...
            }

        };
        handler.postDelayed(runnable, 100); //for initial delay..

    };

    public void onTruth(View v) {
        Intent t = new Intent(this, Tru1.class);
        startActivity(t);
    }

    public void onDare(View v) {
        Intent D = new Intent(this, Dar1.class);
        startActivity(D);
    }

    public void onclick(View v) {

        handler.removeCallbacks(runnable);

    }
    public void onAdd(View v){
        Intent add_intent = new Intent(this, MainActivity1.class);
        startActivity(add_intent);
        MainActivity1.player_model.getPlayersarray().clear();
        MainActivity1.playerServer.notifyDataSetChanged();

    }
}











