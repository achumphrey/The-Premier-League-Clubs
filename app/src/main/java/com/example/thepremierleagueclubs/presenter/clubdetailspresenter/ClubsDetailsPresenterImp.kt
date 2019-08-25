package com.example.thepremierleagueclubs.presenter.clubdetailspresenter

import android.content.Intent
import android.util.Log
import com.example.thepremierleagueclubs.common.clubcommon.ClubConstants
import com.example.thepremierleagueclubs.common.clubdetailcommon.ClubDetailsConstants
import com.example.thepremierleagueclubs.common.enqueue
import com.example.thepremierleagueclubs.common.loadImage
import com.example.thepremierleagueclubs.model.clubdetails.DetailedClubRecord
import com.example.thepremierleagueclubs.model.clublist.ClubsModel
import com.example.thepremierleagueclubs.network.clubsnetwork.ClubsClientInterface
import com.example.thepremierleagueclubs.network.clubsnetwork.ClubsRetrofitInstance
import com.example.thepremierleagueclubs.network.detailsnetwork.ClubDetailsClientInterface
import com.example.thepremierleagueclubs.network.detailsnetwork.ClubDetailsRetrofitInstance
import com.example.thepremierleagueclubs.presenter.clubpresenter.ClubView
import kotlinx.android.synthetic.main.activity_details_club.*


class ClubsDetailsPresenterImp: ClubsDetailsBasePresenter<ClubDetailsView>() {

    override fun onViewAttached(view: ClubDetailsView) {
        super.onViewAttached(view)

        view.showLoading()
        val intent = Intent()
        val movieId = intent.getIntExtra(ClubDetailsConstants.INTENT_MESSAGE, 0)
    //    var movieId = ClubDetailsClientInterface.getClubID()

        val clubDetatilsclientInterface = ClubDetailsRetrofitInstance()
            .retrofitInstance.create(ClubDetailsClientInterface::class.java)

        val call = clubDetatilsclientInterface.getClubDetail(movieId)

        call.enqueue {
            onResponse = {

                    clubDetails -> val details = clubDetails.body()
                Log.d("DetailActivity", details!!.teams[0].strTeam)
                view.showRepoResults(details)

            }

            onFailure = {

                    error -> Log.d("Fail", error?.message)
            }

        }

    }//END ONVIEWATTACHED
}

interface ClubDetailsView: ClubsDetailsBasePresenter.View{

    fun showLoading()
    fun showRepoResults(detailClubRecords: DetailedClubRecord)

}