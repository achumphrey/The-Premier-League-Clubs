package com.example.thepremierleagueclubs.model.clublist

import com.google.gson.annotations.SerializedName

data class ClubsModel (

	@SerializedName("teams") val teams : List<Teams>
)