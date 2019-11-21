package com.example.partyfun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PlayArea2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_area);
        Button truth=findViewById(R.id.truth);
        Button dare = findViewById(R.id.dare);

    };


    public void onTruth(View v) {
        Intent t = new Intent(this, Tru1.class);
        startActivity(t);
    }

    public void onDare(View v) {
        Intent D = new Intent(this, Dar1.class);
        startActivity(D);
    }
};
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











