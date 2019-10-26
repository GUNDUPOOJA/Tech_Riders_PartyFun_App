package com.example.partyfun;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DareAdapter extends RecyclerView.Adapter<DareAdapter.DareViewHolder> {
    private Model2 dare_model;

    public DareAdapter(Model2 dare_model) {
        super();
        this.dare_model = dare_model;
    }

    public static class DareViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout linearView;

        public DareViewHolder(LinearLayout lin_layout) {
            super(lin_layout);
            linearView = lin_layout;
        }
    }
    @NonNull
    @Override
    public DareViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LinearLayout lin_layout = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dare_detailed_view, parent, false);
        DareViewHolder linviewhol = new DareViewHolder(lin_layout);
        return linviewhol;
    }

    @Override
    public void onBindViewHolder(@NonNull DareViewHolder holder, int position) {
        LinearLayout hold_view = holder.linearView;
        TextView dare_holder = hold_view.findViewById(R.id.dare_holder);
        dare_holder.setText(dare_model.getdaresArray().get(position).Dare);
    }

    @Override
    public int getItemCount() {
        return dare_model.getdaresArray().size();
    }
}
