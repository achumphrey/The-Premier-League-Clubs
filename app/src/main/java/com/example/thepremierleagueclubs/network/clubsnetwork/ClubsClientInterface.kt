package com.example.thepremierleagueclubs.network.clubsnetwork


import com.example.thepremierleagueclubs.model.clubdetails.DetailedClubRecord
import com.example.thepremierleagueclubs.model.clublist.ClubsModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ClubsClientInterface {

    @GET("search_all_teams.php")
    fun getClubRecords(@Query("l") league : String): Call<ClubsModel>
}
