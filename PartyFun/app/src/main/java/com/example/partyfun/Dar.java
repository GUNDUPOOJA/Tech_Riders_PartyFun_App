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

public class Dar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dar);
        final ArrayList<Object> DList  = new ArrayList<>();

        final TextView n = findViewById(R.id.dru);
        ParseQuery<ParseObject> query2 = ParseQuery.getQuery("Dare");
        final Random ran = new Random();

        query2.findInBackground(new FindCallback<ParseObject>() {
                                   public void done(List<ParseObject> darelist, ParseException e) {
                                       if (e == null) {
                                           for (int i = 0; i < darelist.size(); i++) {
                                               System.out.println(darelist.get(i).get("Dares"));

                                               DList.add(" "+darelist.get(i).get("Dares"));
                                               //    a.setText("truth" + truthList.get(i).get("Truth"));
                                               System.out.println("abc");
                                               System.out.println(DList.size());
                                           }
                                           System.out.println("dffafafdg");
                                           System.out.println(DList);
                                           Object abc = DList.get(ran.nextInt(DList.size()));
                                           n.setText(""+ abc);
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

