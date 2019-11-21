package com.example.partyfun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class Dar1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dar1);
        final Random r1 = new Random();


        final TextView a = findViewById(R.id.dru);
        System.out.println(SixthActivity.dareArray);
        String abc = SixthActivity.dareArray.get(r1.nextInt(SixthActivity.dareArray.size()));
        a.setText(""+ abc);
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
