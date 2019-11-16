package com.example.partyfun;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SpecialOne extends AppCompatActivity {
    public int counter;
    public int click = 0;

    private Model3 score_model;
    private ScoreAdapter scoreServer = null;
    private RecyclerView scorerecycler = null;
    private GestureDetectorCompat gesture_detector = null;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_special_one);
        Button button = findViewById(R.id.button3);
        button.setEnabled(false);

        score_model = Model3.getModel();
        scoreServer = new ScoreAdapter(score_model);
        scorerecycler = findViewById(R.id.RecyclerView2);
        scorerecycler.setAdapter(scoreServer);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        scorerecycler.setLayoutManager(linearLayoutManager);
        scorerecycler.addOnItemTouchListener(new RecyclerView.SimpleOnItemTouchListener(){
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                return gesture_detector.onTouchEvent(e);
            }
        });


    }

    public void onContinue(View v){
        Intent opt = new Intent(this,FourthActivity.class);
        startActivity(opt);
    }

    public void onStart(final View v){
        Button button = findViewById(R.id.button3);
        button.setEnabled(true);

        counter = 0;
        int i = 1;
        final TextView counttime=findViewById(R.id.counttime);
        new CountDownTimer(10000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                counttime.setText(String.valueOf(counter));
                if (counter<10){
                    counter++;}
            }
            @Override
            public void onFinish() {
                int p = 1;
                Button button = findViewById(R.id.button3);
                button.setEnabled(false);
                counttime.setText("Finished");
//                TextView t = findViewById(R.id.textView8);
//                t.setText("Player "+ p + " Score = 10" );
                p++;
            }
        }.start();
    }

    public void onClickClick(View v){
        click++;
        TextView display = findViewById(R.id.display);
        Log.d("Alert",String.valueOf(click));
        display.setText(Integer.toString(click));


    }
}