package com.example.partyfun;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static com.example.partyfun.MainActivity1.player_model;

public class SpecialOne extends AppCompatActivity implements ScoreDialog.ScoreCallback{
    public int counter;
    public static int click = 0;

    private Model3 score_model;
    private ScoreAdapter scoreServer = null;
    private RecyclerView scorerecycler = null;
    private GestureDetectorCompat gesture_detector = null;
    static int to_be_rotated = MainActivity1.player_data.size();

    static String winner_name = null;

    private int no_of_times_rotated = 0;
    //TextView display;

    private class RecyclerViewOnGestureListener extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            View view = scorerecycler.findChildViewUnder(e.getX(), e.getY());
            if (view != null) {
                RecyclerView.ViewHolder holder = scorerecycler.getChildViewHolder(view);
                if (holder instanceof ScoreAdapter.ScoreViewHolder) {
                    int position = holder.getAdapterPosition();
                    Log.d("click", "clicked on item " + position);
                    return true;

                }
            }
            return false;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_special_one);
        Button button = findViewById(R.id.button3);
        button.setEnabled(false);

       // display = findViewById(R.id.display);




        score_model = Model3.getModel();
        scoreServer = new ScoreAdapter(score_model);
        scorerecycler = findViewById(R.id.RecyclerView2);
        scorerecycler.setAdapter(scoreServer);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        scorerecycler.setLayoutManager(linearLayoutManager);
        gesture_detector = new GestureDetectorCompat(this, new RecyclerViewOnGestureListener());

        scorerecycler.addOnItemTouchListener(new RecyclerView.SimpleOnItemTouchListener(){
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                return gesture_detector.onTouchEvent(e);
            }
        });

        int length = score_model.getScoresarray().size();

        for (int i =0; i<length; i++){
            score_model.getScoresarray().remove(0);
        }

        Log.d("Size", String.valueOf(score_model.getScoresarray().size()));
        Log.d("Size", String.valueOf(MainActivity1.player_data.size()));

        scoreServer.notifyDataSetChanged();


        for(int i=0; i<MainActivity1.player_data.size(); i++){
            String name=MainActivity1.player_data.get(i);
            score_model.getScoresarray().add(new Model3.Score(name));
        }



    }

    public void onContinue(View v){

        Intent image = new Intent(this, SelectImage.class);
        startActivity(image);


       /* Intent opt = new Intent(this,SelectImage.class);
        startActivity(opt);*/
    }

    public void onStart(final View v){
        final Random r1 = new Random();

        if (no_of_times_rotated<to_be_rotated) {

            Button button = findViewById(R.id.button3);
            button.setEnabled(true);
            click = 0;
         //   display.setText(Integer.toString(click));
            counter = 0;
            int i = 1;
            final TextView counttime = findViewById(R.id.counttime);
            new CountDownTimer(5000, 1000) {
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


            winner_name = null;
            int max_score = 0;

            for (int i=0; i<score_model.getScoresarray().size(); i++){
                Model3.Score player_data = score_model.getScoresarray().get(i);
                String string_player_data = player_data.Score;
                String[] plited_player_data = string_player_data.split(" ");
                if (max_score < Integer.parseInt(plited_player_data[1])) {
                    max_score = Integer.parseInt(plited_player_data[1]);
                    winner_name = plited_player_data[0];
                }

            }

            ScoreDialog ed = new ScoreDialog();
            ed.show(getSupportFragmentManager(), "Score  Dialog");
            Toast.makeText(SpecialOne.this, "GAME OVER", Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickClick(View v){
        click++;

        Log.d("Alert",String.valueOf(click));
     //   display.setText(Integer.toString(click));

        String player_name= MainActivity1.player_data.get(no_of_times_rotated);
        player_name = player_name + " " + String.valueOf(click);
        //MainActivity1.player_data.set(no_of_times_rotated, player_name);



        score_model.getScoresarray().set(no_of_times_rotated, new Model3.Score(player_name));

        Log.d("updated array", String.valueOf(no_of_times_rotated));
        Log.d("updated array", score_model.getScoresarray().get(no_of_times_rotated).Score);

        scoreServer.notifyItemChanged(no_of_times_rotated);

        scoreServer.notifyDataSetChanged();
    }

    public void onAdd(View v){
        Intent add_intent = new Intent(this, MainActivity1.class);
        startActivity(add_intent);
        int length = player_model.getPlayersarray().size();

        for (int i =0; i<length; i++){
            player_model.getPlayersarray().remove(0);
        }
       MainActivity1.playerServer.notifyDataSetChanged();;

    }
}