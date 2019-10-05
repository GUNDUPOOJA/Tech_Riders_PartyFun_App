package com.example.partyfun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PlayArea extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_area);
    }

    public void onGo(View V){
        Intent onGo = new Intent(this,TruthOrDare.class);
        startActivity(onGo);
    }
}
