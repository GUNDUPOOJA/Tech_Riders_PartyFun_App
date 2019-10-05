package com.example.partyfun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SixthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixth);
    }
    public void onDone2(View v){
        Intent done_int2 =  new Intent();
        setResult(FourthActivity.GOOD_D_RES,done_int2);
        finish();
    }
}
