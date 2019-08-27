package com.example.thepremierleagueclubs.view.clubdetailsview

import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.example.thepremierleagueclubs.R
import com.example.thepremierleagueclubs.common.asynctaskcommon.changeTextColour
import com.example.thepremierleagueclubs.common.clubdetailcommon.*
import com.example.thepremierleagueclubs.common.enqueue
import com.example.thepremierleagueclubs.common.loadImage
import com.example.thepremierleagueclubs.model.clubdetails.DetailedClubRecord
import com.example.thepremierleagueclubs.model.clubdetails.TeamsDetail
import com.example.thepremierleagueclubs.network.detailsnetwork.ClubDetailsClientInterface
import com.example.thepremierleagueclubs.network.detailsnetwork.ClubDetailsRetrofitInstance
import com.example.thepremierleagueclubs.presenter.clubdetailspresenter.ClubDetailsView
import com.example.thepremierleagueclubs.presenter.clubdetailspresenter.ClubsDetailsBasePresenter
import com.example.thepremierleagueclubs.presenter.clubdetailspresenter.ClubsDetailsPresenterImp
import com.example.thepremierleagueclubs.presenter.clubpresenter.ClubsPresenterImp
import kotlinx.android.synthetic.main.activity_club_list.*
import kotlinx.android.synthetic.main.activity_details_club.*

class DetailsClubActivity : AppCompatActivity() , ClubDetailsView {

    var strStadiumName = ""
    var stadiumCapacity = ""
    var stadiumLocation = ""
    var yearFormed = ""
    var teamName = ""

    val presenter: ClubsDetailsPresenterImp = ClubsDetailsPresenterImp()

    //this makes the intent value available to the presenter.
    override fun getTeamId(): Int {
        return intent.getIntExtra(ClubDetailsConstants.INTENT_MESSAGE, 0)
    }

    override fun showLoading() {
        prgBar.visibility = View.VISIBLE
    }

    override fun showRepoResults(detailClubRecords: DetailedClubRecord) {

        prgBar.visibility = View.GONE
        Log.d("DetailActivity", detailClubRecords!!.teams[0].strTeam)

        stadiumCapacity = detailClubRecords.teams[0].intStadiumCapacity.toString()
        tv_stadium_capacity.text = stadiumCapacity
        strStadiumName = detailClubRecords.teams[0].strStadium
        tv_stadium.text = strStadiumName
        stadiumLocation = detailClubRecords.teams[0].strStadiumLocation
        tv_stadium_location.text = stadiumLocation
        yearFormed = detailClubRecords.teams[0].intFormedYear.toString()
        tv_year_formed.text = yearFormed
        teamName = detailClubRecords.teams[0].strTeam
        tv_team_name.text = teamName
        img_view.loadImage(detailClubRecords.teams[0].strTeamBadge)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_club)

        var animRotate: Animation = AnimationUtils
            .loadAnimation(getApplicationContext(), R.anim.rotate)
        img_view.visibility = View.VISIBLE
        img_view.startAnimation(animRotate)

        presenter.onViewAttached(this)

        tv_stadium.setOnClickListener {

            tv_stadium.changeBackgroudColour(strStadiumName)
        }

        tv_stadium_capacity.setOnClickListener {
            tv_stadium_capacity.changeTextColour(stadiumCapacity)
        }

        tv_stadium_location.setOnClickListener {
            tv_stadium_location.changeTextStyle(stadiumLocation)
        }

        tv_year_formed.setOnClickListener {
            tv_year_formed.changeTextColourGreen(yearFormed)
        }

        tv_team_name.setOnClickListener {
            tv_team_name.changeBackgroudColourGray(teamName)
        }



/*
        val teamId = intent.getIntExtra(ClubDetailsConstants.INTENT_MESSAGE, 0)

        val clubDetatilsClientInterface = ClubDetailsRetrofitInstance()
            .retrofitInstance.create(ClubDetailsClientInterface::class.java)

        val call = clubDetatilsClientInterface.getClubDetail(teamId)

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
    }*/
    }
}
