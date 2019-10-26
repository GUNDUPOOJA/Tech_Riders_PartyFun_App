package com.example.partyfun;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FifthActivity extends AppCompatActivity {
    private Model1 player_Model1;
    private TruthAdapter playerServer = null;
    private RecyclerView playerrecycler = null;
    private GestureDetectorCompat gesture_detector = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);
        player_Model1 = Model1.getModel();
        playerServer = new TruthAdapter(player_Model1);
        playerrecycler = findViewById(R.id.RecyclerView1);
        playerrecycler.setAdapter(playerServer);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        playerrecycler.setLayoutManager(linearLayoutManager);
        playerrecycler.addOnItemTouchListener(new RecyclerView.SimpleOnItemTouchListener(){
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                return gesture_detector.onTouchEvent(e);
            }
        });
        Button truth_add = findViewById(R.id.dareBTN);

        truth_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText add_player = findViewById(R.id.dareEdt);


                String str = add_player.getText().toString();
                player_Model1.gettruthsarray().add(new Model1.Truth(str));

                playerServer.notifyItemInserted(player_Model1.gettruthsarray().size() - 1);
                add_player.getText().clear();
            }

        });

    }



    public void onDone(View v){
        Intent done_int1 =  new Intent();
        setResult(FourthActivity.GOOD_RES,done_int1);
        finish();
    }
}
