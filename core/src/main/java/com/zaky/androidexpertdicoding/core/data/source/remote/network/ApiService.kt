package com.zaky.androidexpertdicoding.core.data.source.remote.network

import com.zaky.androidexpertdicoding.core.data.source.remote.response.ListSportResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("search_all_teams.php")
    suspend fun getListTeam(
        @Query("l") league: String
    ): ListSportResponse
}