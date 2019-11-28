package com.example.partyfun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class PlayArea2 extends AppCompatActivity {
    final Handler handler = new Handler();
    Runnable runnable;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_area);
        Button truth=findViewById(R.id.truth);
        Button dare = findViewById(R.id.dare);

        imageView = (ImageView) findViewById(R.id.imageView);
        final int[] imageArray =
                {R.drawable.men1, R.drawable.men2, R.drawable.men3,R.drawable.woman1, R.drawable.woman2, R.drawable.women3};


        Random r = new Random();
        int timer = r.nextInt(200 - 100) + 30;


        runnable = new Runnable() {
            int i = 0;

            public void run() {
                imageView.setImageResource(imageArray[i]);
                i++;
                if (i > imageArray.length - 1) {
                    i = 0;
                }
                handler.postDelayed(this, 100);  //for interval...
            }

        };
        handler.postDelayed(runnable, 100); //for initial delay..

    };

    public void onTruth(View v) {
        Intent t = new Intent(this, Tru1.class);
        startActivity(t);
    }

    public void onDare(View v) {
        Intent D = new Intent(this, Dar1.class);
        startActivity(D);
    }

    public void onclick(View v) {

        handler.removeCallbacks(runnable);

    }
}
//Button getBTN = findViewById(R.id.test);
//        final ArrayList<Object> Tlist  = new ArrayList<>();
//
//        final TextView a = findViewById(R.id.tv);
//        ParseQuery<ParseObject> query = ParseQuery.getQuery("Truth");
//        final Random r = new Random();
//
//        query.findInBackground(new FindCallback<ParseObject>() {
//            public void done(List<ParseObject> truthList, ParseException e) {
//                                       if (e == null) {
//                                           for (int i = 0; i < truthList.size(); i++) {
//                                            System.out.println(truthList.get(i).get("Truth"));
//
//                                               Tlist.add(" "+truthList.get(i).get("Truth"));
//                                           //    a.setText("truth" + truthList.get(i).get("Truth"));
//                                               System.out.println("abc");
//                                               System.out.println(Tlist.size());
//                                           }
//                                           System.out.println("dffafafdg");
//                                           System.out.println(Tlist);
//                                           Object abc = Tlist.get(r.nextInt(Tlist.size()));
//                                           a.setText(""+ abc);
//                                       } else {
//                                           Log.d("Parse", "Error: " + e.getMessage());
//                                       }
//                                   }
//                               }
//
//        );
//
//
//
//    }
//
//











