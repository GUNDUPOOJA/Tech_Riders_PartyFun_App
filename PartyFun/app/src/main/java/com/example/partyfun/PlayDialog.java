package com.example.partyfun;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class PlayDialog extends DialogFragment {

    public interface DialogCallback{
        public void done();
        public void forfeit();
    }

    DialogCallback Activity = null;

    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Activity = (DialogCallback) context;
    }

    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Your Question");
        builder.setMessage("Did you ever cheat your partner?");
        builder.setPositiveButton("DONE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Activity.done();
            }
        });

        builder.setNegativeButton("FORFEIT", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Activity.forfeit();
            }
        });


        return builder.create();

    }

}
