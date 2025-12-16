package com.zaky.androidexpertdicoding.core.utils

import com.zaky.androidexpertdicoding.core.data.source.local.entity.SportEntity
import com.zaky.androidexpertdicoding.core.data.source.remote.response.SportResponse
import com.zaky.androidexpertdicoding.core.domain.model.Teams

object DataMapper {

    fun mapResponseToEntities(input: List<SportResponse>): List<SportEntity> {
        val teamList = ArrayList<SportEntity>()
        input.map {
            val teams = SportEntity(
                idTeam = it.idTeam,
                strTeam = it.strTeam,
                intFormedYear = it.intFormedYear,
                strLeague = it.strLeague,
                strStadium = it.strStadium,
                strStadiumThumb = it.strStadiumThumb,
                strStadiumDescription = it.strStadiumDescription,
                strStadiumLocation = it.strStadiumLocation,
                intStadiumCapacity = it.intStadiumCapacity,
                strDescriptionEN = it.strDescriptionEN,
                strCountry = it.strCountry,
                strTeamBadge = it.strTeamBadge,
                strTeamJersey = it.strTeamJersey,
                strTeamLogo = it.strTeamLogo,
                strYoutube = it.strYoutube,
                isFavorite = false
            )
            teamList.add(teams)
        }
        return teamList
    }

    fun mapEntitiesToDomain(input: List<SportEntity>): List<Teams> =
        input.map {
            Teams(
                idTeam = it.idTeam,
                strTeam = it.strTeam,
                intFormedYear = it.intFormedYear,
                strLeague = it.strLeague,
                strStadium = it.strStadium,
                strStadiumThumb = it.strStadiumThumb,
                strStadiumDescription = it.strStadiumDescription,
                strStadiumLocation = it.strStadiumLocation,
                intStadiumCapacity = it.intStadiumCapacity,
                strDescriptionEN = it.strDescriptionEN,
                strCountry = it.strCountry,
                strTeamBadge = it.strTeamBadge,
                strTeamJersey = it.strTeamJersey,
                strTeamLogo = it.strTeamLogo,
                strYoutube = it.strYoutube,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: Teams) = SportEntity(
        idTeam = input.idTeam,
        strTeam = input.strTeam,
        intFormedYear = input.intFormedYear,
        strLeague = input.strLeague,
        strStadium = input.strStadium,
        strStadiumThumb = input.strStadiumThumb,
        strStadiumDescription = input.strStadiumDescription,
        strStadiumLocation = input.strStadiumLocation,
        intStadiumCapacity = input.intStadiumCapacity,
        strDescriptionEN = input.strDescriptionEN,
        strCountry = input.strCountry,
        strTeamBadge = input.strTeamBadge,
        strTeamJersey = input.strTeamJersey,
        strTeamLogo = input.strTeamLogo,
        strYoutube = input.strYoutube,
        isFavorite = input.isFavorite
    )
}