package com.example.partyfun;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder> {
    private Model player_model;

    public PlayerAdapter(Model player_model) {
        super();
        this.player_model = player_model;
    }

    public static class PlayerViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout linearView;

        public PlayerViewHolder(LinearLayout lin_layout) {
            super(lin_layout);
            linearView = lin_layout;
        }
    }
    @NonNull
    @Override
    public PlayerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LinearLayout lin_layout = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.players_detailed_view, parent, false);
        PlayerViewHolder linviewhol = new PlayerViewHolder(lin_layout);
        return linviewhol;
    }

    @Override
    public void onBindViewHolder(@NonNull PlayerViewHolder holder, int position) {
        LinearLayout hold_view = holder.linearView;
        TextView word_holder = hold_view.findViewById(R.id.word_holder);
        word_holder.setText(player_model.getPlayersarray().get(position).player);
    }

    @Override
    public int getItemCount() {
        return player_model.getPlayersarray().size();
    }
}