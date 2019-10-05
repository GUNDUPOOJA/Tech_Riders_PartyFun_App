package com.example.partyfun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Question extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
    }
    public void onForfeit(View v){
        Intent forfeit_intent = new Intent();
        setResult(TruthOrDare.TRUTH_RES,forfeit_intent);
        finish();
    }
}
