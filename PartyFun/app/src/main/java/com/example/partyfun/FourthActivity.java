package com.example.partyfun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FourthActivity extends AppCompatActivity {
    public static final int GOOD_REQ=1;
    public static final int GOOD_RES=0;
    public static final int GOOD_D_RES=10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
    }

    public void onTruth(View v){
        Intent truth = new Intent(this,FifthActivity.class);
        startActivity(truth);
    }


    public void onDare(View v){
        Intent dare = new Intent(this,SixthActivity.class);
        startActivity(dare);
    }

    public void onStart(View v){
        Intent start = new Intent(this,SelectImage.class);
        startActivity(start);
    }

    public void onActivityResult(int requestCode,int resultCode,Intent tipInt){
        if(requestCode==GOOD_REQ) {
            if (resultCode == GOOD_RES) {


            }
            else if(resultCode==GOOD_D_RES){

            }
        }

    }
}
