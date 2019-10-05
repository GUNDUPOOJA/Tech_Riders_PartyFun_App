package com.example.partyfun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TruthOrDare extends AppCompatActivity {
    public static final int TRUTH_REQ=1;
    public static final int TRUTH_RES=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_truth_or_dare);
    }
    public void onBt(View v){
        Intent truth_intent = new Intent(this,Question.class);
        startActivity(truth_intent);
    }


}
