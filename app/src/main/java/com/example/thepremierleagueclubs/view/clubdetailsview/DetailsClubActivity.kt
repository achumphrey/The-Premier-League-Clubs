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
import com.example.thepremierleagueclubs.common.clubdetailcommon.ClubDetailsConstants
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

class DetailsClubActivity : AppCompatActivity() {

//    var animationDuration = 2000 //millisecods

  //  , ClubDetailsView

  /*  val presenter: ClubsDetailsPresenterImp = ClubsDetailsPresenterImp()

    override fun showLoading() {

        prgBar.visibility = View.VISIBLE
    }

    override fun showRepoResults(detailClubRecords: DetailedClubRecord) {

        prgBar.visibility = View.GONE
        Log.d("DetailActivity", detailClubRecords!!.teams[0].strTeam)

        tv_stadium_capacity.text = "" + detailClubRecords.teams[0].intStadiumCapacity
        tv_stadium.text = detailClubRecords.teams[0].strStadium
        tv_stadium_location.text = detailClubRecords.teams[0].strStadiumLocation
        tv_year_formed.text = "" + detailClubRecords.teams[0].intFormedYear
        tv_team_name.text = detailClubRecords.teams[0].strTeam
        img_view.loadImage(detailClubRecords.teams[0].strTeamBadge)
    }
*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_club)

        var animRotate: Animation = AnimationUtils
            .loadAnimation(getApplicationContext(), R.anim.rotate)
        img_view.visibility = View.VISIBLE
        img_view.startAnimation(animRotate)

   //      presenter.onViewAttached(this)

      // Val movieId = view.getClubId()

        val movieId = intent.getIntExtra(ClubDetailsConstants.INTENT_MESSAGE, 0)

        val clubDetatilsClientInterface = ClubDetailsRetrofitInstance()
            .retrofitInstance.create(ClubDetailsClientInterface::class.java)

        val call = clubDetatilsClientInterface.getClubDetail(movieId)

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
