package com.example.burgerloginapi;

import retrofit2.http.GET;

public interface TeamInterface {


    @GET("search_all_teams.php?l=English%20Premier%20League")
    retrofit2.Call<Teamresponse> getTeam();

    @GET("search_all_teams.php?s=Soccer&c=Spain")
    retrofit2.Call<Teamresponse> getspain();
}
