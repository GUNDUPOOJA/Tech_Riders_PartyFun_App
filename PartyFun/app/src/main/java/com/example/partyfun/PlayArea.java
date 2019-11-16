package com.example.partyfun;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PlayArea extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_area);
        Button truth=findViewById(R.id.truth);
        Button dare = findViewById(R.id.dare);
//        truth.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                PlayDialog mad = new PlayDialog();

                //

//                final TextView a = findViewById(R.id.tv);
//                ParseQuery<ParseObject> query = ParseQuery.getQuery("Truth");
//                query.findInBackground(new FindCallback<ParseObject>(){
//                                           public void done(List<ParseObject> truthList, ParseException e) {
//                                               if (e == null) {
//                                                   for (int i = 0; i < truthList.size(); i++) {
//                                                       System.out.println(truthList.get(i).get("Truth"));
//                                                       a.setText(""+truthList.get(i).get("Truth"));
//                                                   }
//                                               } else {
//                                                   Log.d("Parse", "Error: " + e.getMessage());
//                                               }
//                                           }
//                                       }
//                );
                //SharedPreferences pref = getApplicationContext().getSharedPreferences("emotionValue", 0);
                // SharedPreferences.Editor editor = pref.edit();
                //editor.putInt("key_name", -1);
//                mad.show(getSupportFragmentManager(),"Emotion Dialog Box");

//            }
//        });

//        dare.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                PlayDialog mad = new PlayDialog();
//                //SharedPreferences pref = getApplicationContext().getSharedPreferences("emotionValue", 0);
//                // SharedPreferences.Editor editor = pref.edit();
//                //editor.putInt("key_name", -1);
//                mad.show(getSupportFragmentManager(),"Emotion Dialog Box");
//
//            }
//        });
//
//
//    }



//    @Override
//    public void done() {
//
//    };
//
//    @Override
//    public void forfeit() {
//
   };


    public void onTruth(View v) {
        //Button getBTN = findViewById(R.id.test);
        final ArrayList<Object> Tlist  = new ArrayList<>();





        final TextView a = findViewById(R.id.tv);
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Truth");
        final Random r = new Random();

        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> truthList, ParseException e) {
                                       if (e == null) {
                                           for (int i = 0; i < truthList.size(); i++) {
                                            System.out.println(truthList.get(i).get("Truth"));

                                               Tlist.add(" "+truthList.get(i).get("Truth"));
                                           //    a.setText("truth" + truthList.get(i).get("Truth"));
                                               System.out.println("abc");
                                               System.out.println(Tlist.size());
                                           }
                                           System.out.println("dffafafdg");
                                           System.out.println(Tlist);
                                           Object abc = Tlist.get(r.nextInt(Tlist.size()));
                                           a.setText(""+ abc);
                                       } else {
                                           Log.d("Parse", "Error: " + e.getMessage());
                                       }
                                   }
                               }

        );

        
        System.out.println(Tlist.size());

    }








    };




