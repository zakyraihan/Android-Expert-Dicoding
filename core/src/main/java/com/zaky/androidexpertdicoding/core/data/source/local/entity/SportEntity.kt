package com.zaky.androidexpertdicoding.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "teams")
data class SportEntity(

    @PrimaryKey
    @ColumnInfo(name = "idTeam")
    val idTeam: String,

    @ColumnInfo(name = "strTeam")
    val strTeam: String? = null,

    @ColumnInfo(name = "intFormedYear")
    val intFormedYear: String? = null,

    @ColumnInfo(name = "strLeague")
    val strLeague: String? = null,

    @ColumnInfo(name = "strStadium")
    val strStadium: String? = null,

    @ColumnInfo(name = "strStadiumThumb")
    val strStadiumThumb: String? = null,

    @ColumnInfo(name = "strStadiumDescription")
    val strStadiumDescription: String? = null,

    @ColumnInfo(name = "strStadiumLocation")
    val strStadiumLocation: String? = null,

    @ColumnInfo(name = "intStadiumCapacity")
    val intStadiumCapacity: String? = null,

    @ColumnInfo(name = "strDescriptionEN")
    val strDescriptionEN: String? = null,

    @ColumnInfo(name = "strCountry")
    val strCountry: String? = null,

    @ColumnInfo(name = "strTeamBadge")
    val strTeamBadge: String? = null,

    @ColumnInfo(name = "strTeamJersey")
    val strTeamJersey: String? = null,

    @ColumnInfo(name = "strTeamLogo")
    val strTeamLogo: String? = null,

    @ColumnInfo(name = "strYoutube")
    val strYoutube: String? = null,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
)
