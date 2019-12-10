package com.example.partyfun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;




public class Tru extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tru);
        final ArrayList<Object> Tlist  = new ArrayList<>();

        final TextView a = findViewById(R.id.tru);
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



    }

    public void onDone(View v) {
        Intent D = new Intent(this,PlayArea.class);
        startActivity(D);
    }
    public void onForfeit(View v) {
        Intent F = new Intent(this,PlayArea.class);
        startActivity(F);
    }

    public void onAdd(View v){
        Intent add_intent = new Intent(this, MainActivity1.class);
        startActivity(add_intent);
        MainActivity1.player_model.getPlayersarray().clear();
        MainActivity1.playerServer.notifyDataSetChanged();

    }
}

