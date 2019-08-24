package com.example.thepremierleagueclubs.view.clubdetailsview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.thepremierleagueclubs.R
import com.example.thepremierleagueclubs.common.clubdetailcommon.ClubDetailsConstants
import com.example.thepremierleagueclubs.common.enqueue
import com.example.thepremierleagueclubs.common.loadImage
import com.example.thepremierleagueclubs.model.clubdetails.DetailedClubRecord
import com.example.thepremierleagueclubs.model.clubdetails.TeamsDetail
import com.example.thepremierleagueclubs.network.detailsnetwork.ClubDetailsClientInterface
import com.example.thepremierleagueclubs.network.detailsnetwork.ClubDetailsRetrofitInstance
import kotlinx.android.synthetic.main.activity_details_club.*

class DetailsClubActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_club)

        val intent = intent
        val movieId = intent.getIntExtra(ClubDetailsConstants.INTENT_MESSAGE, 0)

        val clubDetatilsclientInterface = ClubDetailsRetrofitInstance()
            .retrofitInstance.create(ClubDetailsClientInterface::class.java)

        val call = clubDetatilsclientInterface.getClubDetail(movieId)

        call.enqueue {
            onResponse = {

                    clubDetails -> val details = clubDetails.body()
                    Log.d("DetailActivity", details!!.teams[0].strTeam)

                   tv_stadium_capacity.text = "" + details.teams[0].intStadiumCapacity
                   tv_stadium.text = details.teams[0].strStadium
                   tv_stadium_location.text = details.teams[0].strStadiumLocation
                   tv_year_formed.text = "" + details.teams[0].intFormedYear
                   tv_team_name.text = details.teams[0].strTeam
                   img_view.loadImage(details.teams[0].strTeamBadge)


            }

            onFailure = {

                    error -> Log.d("Fail", error?.message)
            }

        }

    }
}
