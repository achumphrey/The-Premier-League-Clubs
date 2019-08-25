package com.example.thepremierleagueclubs.presenter.clubpresenter

import android.util.Log
import com.example.thepremierleagueclubs.common.clubcommon.ClubConstants
import com.example.thepremierleagueclubs.common.enqueue
import com.example.thepremierleagueclubs.model.clublist.ClubsModel
import com.example.thepremierleagueclubs.network.clubsnetwork.ClubsClientInterface
import com.example.thepremierleagueclubs.network.clubsnetwork.ClubsRetrofitInstance


class ClubsPresenterImp: ClubsBasePresenter<ClubView>() {

    override fun onViewAttached(view: ClubView) {
        super.onViewAttached(view)

        view.showLoading()

        val clubsClientInterface =
            ClubsRetrofitInstance().retrofitInstance.create(ClubsClientInterface::class.java)

        val call = clubsClientInterface.getClubRecords(ClubConstants.LEAGUE)

        // this is the extension function version of the callback enqueue

        call.enqueue{
            onResponse = {

                    clubRecords -> val clubRecordResults = clubRecords.body()

                        Log.d("CHECKPOINT", clubRecordResults!!.teams[0].strTeam)

                        view.showRepoResults(clubRecordResults)
            }

            onFailure = {
                    error -> Log.d("Fail", error?.message)
            }
        }//END CALL ENQUEUE
    }//END ONVIEWATTACHED
}

interface ClubView: ClubsBasePresenter.View {

    fun showLoading()
    fun showRepoResults(clubsModel:ClubsModel)

}