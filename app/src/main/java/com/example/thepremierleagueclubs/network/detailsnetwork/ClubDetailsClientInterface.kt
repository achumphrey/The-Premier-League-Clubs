package com.example.thepremierleagueclubs.network.detailsnetwork


import android.content.Intent
import com.example.thepremierleagueclubs.common.clubdetailcommon.ClubDetailsConstants
import com.example.thepremierleagueclubs.model.clubdetails.DetailedClubRecord
import com.example.thepremierleagueclubs.model.clubdetails.TeamsDetail
import com.example.thepremierleagueclubs.model.clublist.ClubsModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ClubDetailsClientInterface {

    @GET("lookupteam.php")
    fun getClubDetail(@Query("id") club_id : Int): Call<DetailedClubRecord>

    fun getClubID() : Int{
        var intent: Intent? = null
        return intent!!.getIntExtra(ClubDetailsConstants.INTENT_MESSAGE, 0)
    }
}
