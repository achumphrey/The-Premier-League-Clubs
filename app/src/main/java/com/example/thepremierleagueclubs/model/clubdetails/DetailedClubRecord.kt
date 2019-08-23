package com.example.thepremierleagueclubs.model.clubdetails

import com.google.gson.annotations.SerializedName

data class DetailedClubRecord (

	@SerializedName("teams") val teams : List<TeamsDetail>
)