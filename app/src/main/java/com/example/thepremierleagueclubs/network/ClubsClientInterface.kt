package com.example.thepremierleagueclubs.network


import com.example.thepremierleagueclubs.model.clublist.ClubsModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ClubsClientInterface {

    @GET("lookupteam.php")
    fun getClubDetail(@Query("id") club_id : String): Call<List<ClubsModel>>

    @GET("search_all_teams.php")
    fun getClubRecords(@Query("l") league : String): Call<ClubsModel>
}
