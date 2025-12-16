package com.zaky.androidexpertdicoding.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class SportResponse(
    @field:SerializedName("idTeam")
    val idTeam: String,
    @field:SerializedName("strTeam")
    val strTeam: String,
    @field:SerializedName("intFormedYear")
    val intFormedYear: String,
    @field:SerializedName("strLeague")
    val strLeague: String?,
    @field:SerializedName("strStadium")
    val strStadium: String?,
    @field:SerializedName("strStadiumThumb")
    val strStadiumThumb: String?,
    @field:SerializedName("strStadiumDescription")
    val strStadiumDescription: String?,
    @field:SerializedName("strLocation")
    val strStadiumLocation: String?,
    @field:SerializedName("intStadiumCapacity")
    val intStadiumCapacity: String?,
    @field:SerializedName("strDescriptionEN")
    val strDescriptionEN: String?,
    @field:SerializedName("strCountry")
    val strCountry: String?,
    @field:SerializedName("strBadge")
    val strTeamBadge: String?,
    @field:SerializedName("strTeamJersey")
    val strTeamJersey: String?,
    @field:SerializedName("strLogo")
    val strTeamLogo: String?,
    @field:SerializedName("strYoutube")
    val strYoutube: String?,
)
