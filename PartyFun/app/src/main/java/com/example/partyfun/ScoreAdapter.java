package com.example.partyfun;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ScoreAdapter extends RecyclerView.Adapter<ScoreAdapter.ScoreViewHolder>  {
    private Model3 score_model;

    public ScoreAdapter(Model3 score_model) {
        super();
        this.score_model = score_model;
    }

    @NonNull
    @Override
    public ScoreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LinearLayout lin_layout = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.score_detailed_view, parent, false);
        ScoreViewHolder linviewhol = new ScoreViewHolder(lin_layout);
        return linviewhol;
    }



    @Override
    public void onBindViewHolder(@NonNull ScoreViewHolder holder, int position) {
        LinearLayout hold_view = holder.linearView;
        TextView score_holder = hold_view.findViewById(R.id.score_holder);
        score_holder.setText(score_model.getScoresarray().get(position).Score);

    }

    @Override
    public int getItemCount() {
        return score_model.getScoresarray().size();
    }

    public static class ScoreViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout linearView;

        public ScoreViewHolder(LinearLayout lin_layout) {
            super(lin_layout);
            linearView = lin_layout;
        }
    }


}
