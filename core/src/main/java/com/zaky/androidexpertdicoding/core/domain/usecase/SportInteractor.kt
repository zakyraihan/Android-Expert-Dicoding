package com.zaky.androidexpertdicoding.core.domain.usecase

import com.zaky.androidexpertdicoding.core.domain.model.Teams
import com.zaky.androidexpertdicoding.core.domain.repository.ISportRepository

class SportInteractor(private val sportRepository: ISportRepository) : SportUseCase {

    override fun getAllTeams() = sportRepository.getAllTeams()


    override fun getFavoriteTeams() = sportRepository.getFavoriteTeams()


    override fun setFavoriteTeams(teams: Teams, state: Boolean) = sportRepository.setFavoriteTeams(teams, state)

}