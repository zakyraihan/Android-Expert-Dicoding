package com.zaky.androidexpertdicoding.di

import com.zaky.androidexpertdicoding.core.domain.usecase.SportInteractor
import com.zaky.androidexpertdicoding.core.domain.usecase.SportUseCase
import com.zaky.androidexpertdicoding.detail.DetailViewModel
import com.zaky.androidexpertdicoding.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<SportUseCase> { SportInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}