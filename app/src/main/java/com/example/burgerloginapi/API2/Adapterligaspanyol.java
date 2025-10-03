package com.example.burgerloginapi.API2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.burgerloginapi.API1.Adapterligaeng;
import com.example.burgerloginapi.R;
import com.example.burgerloginapi.TeamGetSet;

import java.util.List;

public class Adapterligaspanyol extends RecyclerView.Adapter<Adapterligaspanyol.TeamViewHolder> {
    private List<TeamGetSet> teamList;
    private Context context;

    public Adapterligaspanyol(List<TeamGetSet> teamList, Context context) {
        this.teamList = teamList;
        this.context = context;
    }

    @NonNull
    @Override
    public TeamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout_team, parent, false);
        return new TeamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapterligaspanyol.TeamViewHolder holder, int position) {
        TeamGetSet team = teamList.get(position);
        holder.teamName.setText(team.getStrTeam());
        holder.teamStadium.setText(team.getStrStadium());
        Glide.with(context).load(team.getStrTeamBadge()).into(holder.teamBadge);
    }

    @Override
    public int getItemCount() {
        return teamList.size();
    }

    public static class TeamViewHolder extends RecyclerView.ViewHolder {
        TextView teamName;
        TextView teamStadium;
        ImageView teamBadge;

        public TeamViewHolder(@NonNull View itemView) {
            super(itemView);
            teamName = itemView.findViewById(R.id.team_name);
            teamStadium = itemView.findViewById(R.id.team_stadium);
            teamBadge = itemView.findViewById(R.id.team_badge);
        }
    }
}
