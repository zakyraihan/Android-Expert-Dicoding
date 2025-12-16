package com.zaky.androidexpertdicoding.detail

import androidx.lifecycle.ViewModel
import com.zaky.androidexpertdicoding.core.domain.model.Teams
import com.zaky.androidexpertdicoding.core.domain.usecase.SportUseCase

class DetailViewModel(private val sportUseCase: SportUseCase) : ViewModel() {
    fun setFavoriteTeams(teams: Teams, state: Boolean) =
        sportUseCase.setFavoriteTeams(teams, state)
}