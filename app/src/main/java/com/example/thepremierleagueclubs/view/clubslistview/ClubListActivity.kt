package com.example.thepremierleagueclubs.view.clubslistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.thepremierleagueclubs.R
import com.example.thepremierleagueclubs.model.clublist.ClubsModel
import com.example.thepremierleagueclubs.presenter.ClubView
import com.example.thepremierleagueclubs.presenter.ClubsPresenterImp
import kotlinx.android.synthetic.main.activity_club_list.*

class ClubListActivity : AppCompatActivity(), ClubView {

    val presenter: ClubsPresenterImp = ClubsPresenterImp()

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun showRepoResults(clubsModel: ClubsModel) {

        progressBar.visibility = View.GONE
        Log.d("CLICKEDITEM", clubsModel.teams[0].strTeam)

        // initialize the adapter
        val adapter: ClubsListAdapter =
            ClubsListAdapter(
                clubsModel!!,
                object :
                    OnClubListClickLister {
                    override fun onClubListClick(clubsModel: ClubsModel) {

                        Log.d("CLICKEDITEM", clubsModel.teams[0].strTeam)
                    }
            })

        rv_list.layoutManager = LinearLayoutManager(this@ClubListActivity)
        rv_list.adapter = adapter
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_club_list)



        presenter.onViewAttached(this)
    }
}
