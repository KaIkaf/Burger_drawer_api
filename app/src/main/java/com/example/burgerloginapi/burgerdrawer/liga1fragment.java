package com.example.burgerloginapi.burgerdrawer;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.burgerloginapi.API1.Adapterligaeng;
import com.example.burgerloginapi.R;
import com.example.burgerloginapi.TeamGetSet;
import com.example.burgerloginapi.TeamInterface;
import com.example.burgerloginapi.Teamresponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class liga1fragment extends Fragment {

    private static final String Base_url = "https://www.thesportsdb.com/api/v1/json/3/";

    private RecyclerView recyclerView;
    private Adapterligaeng adapterapi;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_liga1fragment, container, false);
        recyclerView = view.findViewById(R.id.recyclerViewligaeng);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TeamInterface service = retrofit.create(TeamInterface.class);
        Call<Teamresponse> call = service.getTeam();

        call.enqueue(new Callback<Teamresponse>() {
            @Override
            public void onResponse(Call<Teamresponse> call, Response<Teamresponse> response) {
                if (response.isSuccessful()) {
                    Teamresponse teamresponse = response.body();
                    if (teamresponse != null) {
                        List<TeamGetSet> teamList = teamresponse.getTeams();
                        adapterapi = new Adapterligaeng(teamList, getContext());
                        recyclerView.setAdapter(adapterapi);
                    }
                }
            }

            @Override
            public void onFailure(Call<Teamresponse> call, Throwable t) {

            }
        });

        return view;
    }
}
