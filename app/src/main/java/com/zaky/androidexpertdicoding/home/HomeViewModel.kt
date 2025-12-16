package com.zaky.androidexpertdicoding.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.zaky.androidexpertdicoding.core.domain.usecase.SportUseCase

class HomeViewModel(sportUseCase: SportUseCase): ViewModel() {
    val teams = sportUseCase.getAllTeams().asLiveData()
}