package com.example.partyfun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class Tru1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tru1);
        final Random r1 = new Random();


        final TextView a = findViewById(R.id.tru);
        System.out.println(FifthActivity.truthArray);
    }


    public void onDone(View v) {
        Intent D = new Intent(this,PlayArea2.class);
        startActivity(D);
    }
    public void onForfeit(View v) {
        Intent F = new Intent(this,PlayArea2.class);
        startActivity(F);
    }


}
