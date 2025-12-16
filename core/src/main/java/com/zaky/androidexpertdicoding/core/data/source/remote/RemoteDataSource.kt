package com.zaky.androidexpertdicoding.core.data.source.remote

import android.util.Log
import com.zaky.androidexpertdicoding.core.data.source.remote.network.ApiResponse
import com.zaky.androidexpertdicoding.core.data.source.remote.network.ApiService
import com.zaky.androidexpertdicoding.core.data.source.remote.response.SportResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(private val apiService: ApiService) {

    suspend fun getAllTeams(): Flow<ApiResponse<List<SportResponse>>> {
        return flow {
            try {
                val response = apiService.getListTeam("English Premier League")
                val dataArray = response.teams
                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(response.teams))
                    Log.d("TAG", "RemoteDataSource getAllTeams: " + response.teams)
                } else {
                    emit(ApiResponse.Empty)
                    Log.d("TAG", "RemoteDataSource getAllTeams: KOSONG")
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                e.printStackTrace()
            }
        }.flowOn(Dispatchers.IO)
    }
}