package com.example.partyfun;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class ScoreDialog extends DialogFragment{
    public interface ScoreCallback{

    }
    private  ScoreCallback scoreActivity = null;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        scoreActivity = (ScoreCallback) context;
    }
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder scorebuilder = new AlertDialog.Builder(getActivity());
//        scorebuilder.setTitle("Register the change");
        scorebuilder.setMessage("Congratulations, You are the winner");
//        scorebuilder.setPositiveButton()

        scorebuilder.setPositiveButton("Continue", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent t = new Intent((Context) scoreActivity, SelectImage.class);
                startActivity(t);
            }
        });
        return scorebuilder.create();
    }
}
