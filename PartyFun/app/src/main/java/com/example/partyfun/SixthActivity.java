package com.example.partyfun;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class SixthActivity extends AppCompatActivity {
    private Model2 player_Model2;
    private DareAdapter playerServer = null;
    private RecyclerView playerrecycler = null;
    private GestureDetectorCompat gesture_detector = null;
    static ArrayList<String> dareArray = new ArrayList<String>();
    private class RecyclerViewOnGestureListener extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            View view = playerrecycler.findChildViewUnder(e.getX(), e.getY());
            if (view != null) {
                RecyclerView.ViewHolder holder = playerrecycler.getChildViewHolder(view);
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
        setContentView(R.layout.activity_sixth);
        player_Model2 = Model2.getModel();
        playerServer = new DareAdapter(player_Model2);
        playerrecycler = findViewById(R.id.RecyclerView2);
        playerrecycler.setAdapter(playerServer);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        playerrecycler.setLayoutManager(linearLayoutManager);

        gesture_detector = new GestureDetectorCompat(this, new SixthActivity.RecyclerViewOnGestureListener());
        playerrecycler.addOnItemTouchListener(new RecyclerView.SimpleOnItemTouchListener(){
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                return gesture_detector.onTouchEvent(e);
            }
        });

        Button dare_add = findViewById(R.id.dareBTN);

        dare_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText add_player = findViewById(R.id.dareEdt);
                String str = add_player.getText().toString();

                if (str.length()==0){

                    Toast.makeText(SixthActivity.this, "Enter Dares " + str, Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(SixthActivity.this, "Your Dare question is succesfully entered", Toast.LENGTH_SHORT).show();
                    player_Model2.getdaresArray().add(new Model2.Dare(str));
                    dareArray.add(str);

                    playerServer.notifyItemInserted(player_Model2.getdaresArray().size() - 1);
                    add_player.getText().clear();
                }
            }

        });


    }


    public void onDone2(View v){
        Intent done_int2 =  new Intent();
        setResult(FourthActivity.GOOD_D_RES,done_int2);
        finish();
    }
}
