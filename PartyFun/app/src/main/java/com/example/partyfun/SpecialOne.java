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
import android.widget.Toast;

public class SpecialOne extends AppCompatActivity {
    public int counter;
    public static int click = 0;

    private Model3 score_model;
    private ScoreAdapter scoreServer = null;
    private RecyclerView scorerecycler = null;
    private GestureDetectorCompat gesture_detector = null;
    static int to_be_rotated = MainActivity1.player_data.size();
    private int no_of_times_rotated = 0;
    TextView display;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_special_one);
        Button button = findViewById(R.id.button3);
        button.setEnabled(false);

        display = findViewById(R.id.display);

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

        for(int i=0; i<MainActivity1.player_data.size(); i++){
            String name=MainActivity1.player_data.get(i);
            score_model.getScoresarray().add(new Model3.Score(name));
        }

    }

    public void onContinue(View v){
        Intent opt = new Intent(this,FourthActivity.class);
        startActivity(opt);
    }

    public void onStart(final View v){

        if (no_of_times_rotated<to_be_rotated) {

            Button button = findViewById(R.id.button3);
            button.setEnabled(true);
            click = 0;
            display.setText(Integer.toString(click));
            counter = 0;
            int i = 1;
            final TextView counttime = findViewById(R.id.counttime);
            new CountDownTimer(10000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    counttime.setText(String.valueOf(counter));
                    if (counter < 10) {
                        counter++;
                    }

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
                    no_of_times_rotated = no_of_times_rotated +1;


                }
            }.start();

        }
        else{
            Toast.makeText(SpecialOne.this, "GAME OVER", Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickClick(View v){
        click++;

        Log.d("Alert",String.valueOf(click));
        display.setText(Integer.toString(click));

        String player_name= MainActivity1.player_data.get(no_of_times_rotated);
        player_name = player_name + " " + String.valueOf(click);
        //MainActivity1.player_data.set(no_of_times_rotated, player_name);



        score_model.getScoresarray().set(no_of_times_rotated, new Model3.Score(player_name));

        Log.d("updated array", String.valueOf(no_of_times_rotated));
        Log.d("updated array", score_model.getScoresarray().get(no_of_times_rotated).Score);

        scoreServer.notifyItemChanged(no_of_times_rotated);

        scoreServer.notifyDataSetChanged();



    }
}