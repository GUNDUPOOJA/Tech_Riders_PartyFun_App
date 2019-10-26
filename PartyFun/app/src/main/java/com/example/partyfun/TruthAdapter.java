package com.example.partyfun;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TruthAdapter extends RecyclerView.Adapter<TruthAdapter.TruthViewHolder> {
    private Model1 truth_model;

    public TruthAdapter(Model1 truth_model) {
        super();
        this.truth_model = truth_model;
    }

    public static class TruthViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout linearView;

        public TruthViewHolder(LinearLayout lin_layout) {
            super(lin_layout);
            linearView = lin_layout;
        }
    }
    @NonNull
    @Override
    public TruthViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LinearLayout lin_layout = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.truths_detailed_view, parent, false);
        TruthViewHolder linviewhol = new TruthViewHolder(lin_layout);
        return linviewhol;
    }

    @Override
    public void onBindViewHolder(@NonNull TruthViewHolder holder, int position) {
        LinearLayout hold_view = holder.linearView;
        TextView truth_holder = hold_view.findViewById(R.id.truth_holder);
        truth_holder.setText(truth_model.gettruthsarray().get(position).truth);
    }

    @Override
    public int getItemCount() {
        return truth_model.gettruthsarray().size();
    }
}
