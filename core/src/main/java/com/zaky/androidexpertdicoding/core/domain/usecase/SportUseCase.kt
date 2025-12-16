package com.zaky.androidexpertdicoding.core.domain.usecase

import com.zaky.androidexpertdicoding.core.data.Resource
import com.zaky.androidexpertdicoding.core.domain.model.Teams
import kotlinx.coroutines.flow.Flow

interface SportUseCase {
    fun getAllTeams(): Flow<Resource<List<Teams>>>
    fun getFavoriteTeams(): Flow<List<Teams>>
    fun setFavoriteTeams(teams: Teams, state: Boolean)

}