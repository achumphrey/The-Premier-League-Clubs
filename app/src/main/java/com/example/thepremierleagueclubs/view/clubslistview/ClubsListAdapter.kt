package com.example.thepremierleagueclubs.view.clubslistview

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.thepremierleagueclubs.R
import com.example.thepremierleagueclubs.common.inflate
import com.example.thepremierleagueclubs.common.loadImage
import com.example.thepremierleagueclubs.model.clublist.ClubsModel
import kotlinx.android.synthetic.main.club_list_recyclerview.view.*


class ClubsListAdapter(private val clubsModel: ClubsModel, private val listener: OnClubListClickLister):
    RecyclerView.Adapter<ClubListViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClubListViewHolder {

        val view: View = parent.inflate(R.layout.club_list_recyclerview, false)
        return ClubListViewHolder(view)
    }

    override fun getItemCount(): Int {

        return clubsModel.teams.size
    }

    override fun onBindViewHolder(holder: ClubListViewHolder, position: Int) {

        holder.tvTeamName.text = clubsModel.teams[position].strTeam
        holder.tvYeraFormed.text = "" + clubsModel.teams[position].intFormedYear
        holder.tvStadiumLocation.text = clubsModel.teams[position].strStadiumLocation
        holder.tvStadiumName.text = clubsModel.teams[position].strStadium
        holder.tvStadiumCapacity.text = "" + clubsModel.teams[position].intStadiumCapacity

        holder.imgView.loadImage(clubsModel.teams[position].strTeamBadge)

//        holder.imgView.loadImage("http://image.tmdb.org/t/p/w185"
//                + clubsModel.teams[position].strTeamLogo)

        holder.bind(clubsModel, listener)
    }
}

class ClubListViewHolder (view: View): RecyclerView.ViewHolder(view){

    fun bind (clubsModel: ClubsModel, listener: OnClubListClickLister){
        itemView.setOnClickListener{
            listener.onClubListClick(clubsModel)
        }
    }

    val tvTeamName = view.tv_team_name
    val imgView = view.iv_team_logo
    val tvYeraFormed = view.tv_year_formed
    val tvStadiumLocation = view.tv_stadium_location
    val tvStadiumName = view.tv_stadium
    val tvStadiumCapacity = view.tv_stadium_capacity
}

interface OnClubListClickLister{

    fun onClubListClick(clubsModel: ClubsModel)
}