package com.zaky.androidexpertdicoding.core.data.source.local

import com.zaky.androidexpertdicoding.core.data.source.local.entity.SportEntity
import com.zaky.androidexpertdicoding.core.data.source.local.room.SportDAO
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val sportDAO: SportDAO) {

    fun getAllTeams(): Flow<List<SportEntity>> = sportDAO.getAllTeams()
    fun getFavoriteTeams(): Flow<List<SportEntity>> = sportDAO.getFavoriteTeams()
    suspend fun insertTeams(teamsList: List<SportEntity>) = sportDAO.insertTeams(teamsList)

    fun setFavoriteTeams(teams: SportEntity, stateFavorite: Boolean) {
        teams.isFavorite = stateFavorite
        sportDAO.updateFavoriteTeams(teams)
    }
}