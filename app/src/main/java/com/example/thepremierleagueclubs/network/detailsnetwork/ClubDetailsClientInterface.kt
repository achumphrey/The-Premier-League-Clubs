package com.example.thepremierleagueclubs.network.detailsnetwork


import com.example.thepremierleagueclubs.model.clubdetails.DetailedClubRecord
import com.example.thepremierleagueclubs.model.clubdetails.TeamsDetail
import com.example.thepremierleagueclubs.model.clublist.ClubsModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ClubDetailsClientInterface {

    @GET("lookupteam.php")
    fun getClubDetail(@Query("id") club_id : Int): Call<DetailedClubRecord>
}
