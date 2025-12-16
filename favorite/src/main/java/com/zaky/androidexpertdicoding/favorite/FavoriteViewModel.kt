package com.zaky.androidexpertdicoding.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.zaky.androidexpertdicoding.core.domain.usecase.SportUseCase

class FavoriteViewModel(sportUseCase: SportUseCase): ViewModel() {
    val favoriteTeams = sportUseCase.getFavoriteTeams().asLiveData()
}