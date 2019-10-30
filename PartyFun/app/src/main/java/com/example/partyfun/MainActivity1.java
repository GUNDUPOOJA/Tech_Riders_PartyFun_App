package com.example.partyfun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.core.view.GestureDetectorCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.MotionEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity1 extends AppCompatActivity {
    private Model player_model;
    private PlayerAdapter playerServer = null;
    private RecyclerView playerrecycler = null;
    private GestureDetectorCompat gesture_detector = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        player_model = Model.getModel();
        playerServer = new PlayerAdapter(player_model);
        playerrecycler = findViewById(R.id.RecyclerView);
        playerrecycler.setAdapter(playerServer);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        playerrecycler.setLayoutManager(linearLayoutManager);

        Button word_add = findViewById(R.id.button);
        EditText add_player = findViewById(R.id.addBTN);

        /*String str = add_player.getText().toString();
        word_add.setEnabled(true);
        if(str.equals(" ")|| str == null);
        {
            word_add.setEnabled(false);
        }*/

        playerrecycler.addOnItemTouchListener(new RecyclerView.SimpleOnItemTouchListener(){
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                return gesture_detector.onTouchEvent(e);
            }
        });
      //  Button word_add = findViewById(R.id.button);

        word_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText add_player = findViewById(R.id.addBTN);
                String str = add_player.getText().toString();



                if (str.length()==0){
                    Toast.makeText(MainActivity1.this, "Enter the player name " + str, Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity1.this, "Name is succesfully  is entered", Toast.LENGTH_SHORT).show();
                    player_model.getPlayersarray().add(new Model.Player(str));

                    playerServer.notifyItemInserted(player_model.getPlayersarray().size() - 1);
                    add_player.getText().clear();
                }



            }


        });
    }




    public void onClick(View v) {
        Intent intent_special = new Intent(this, SpecialOne.class);
        startActivity(intent_special);
    }





}


