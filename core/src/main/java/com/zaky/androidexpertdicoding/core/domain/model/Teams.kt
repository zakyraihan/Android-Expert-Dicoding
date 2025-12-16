package com.zaky.androidexpertdicoding.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Teams(
    val idTeam: String,
    val strTeam: String? = null,
    val intFormedYear: String? = null,
    val strLeague: String? = null,
    val strStadium: String? = null,
    val strStadiumThumb: String? = null,
    val strStadiumDescription: String? = null,
    val strStadiumLocation: String? = null,
    val intStadiumCapacity: String? = null,
    val strDescriptionEN: String? = null,
    val strCountry: String? = null,
    val strTeamBadge: String? = null,
    val strTeamJersey: String? = null,
    val strTeamLogo: String? = null,
    val strYoutube: String? = null,
    val isFavorite: Boolean
) : Parcelable