package com.example.partyfun;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PlayArea extends AppCompatActivity implements PlayDialog.DialogCallback{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_area);
        Button truth=findViewById(R.id.truth);
        Button dare = findViewById(R.id.dare);
        truth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PlayDialog mad = new PlayDialog();
                //SharedPreferences pref = getApplicationContext().getSharedPreferences("emotionValue", 0);
                // SharedPreferences.Editor editor = pref.edit();
                //editor.putInt("key_name", -1);
                mad.show(getSupportFragmentManager(),"Emotion Dialog Box");

            }
        });

        dare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PlayDialog mad = new PlayDialog();
                //SharedPreferences pref = getApplicationContext().getSharedPreferences("emotionValue", 0);
                // SharedPreferences.Editor editor = pref.edit();
                //editor.putInt("key_name", -1);
                mad.show(getSupportFragmentManager(),"Emotion Dialog Box");

            }
        });
    }



    @Override
    public void done() {

    }

    @Override
    public void forfeit() {

    }
}
