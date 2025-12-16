package com.zaky.androidexpertdicoding.core.data

import com.zaky.androidexpertdicoding.core.data.source.local.LocalDataSource
import com.zaky.androidexpertdicoding.core.data.source.remote.RemoteDataSource
import com.zaky.androidexpertdicoding.core.data.source.remote.network.ApiResponse
import com.zaky.androidexpertdicoding.core.data.source.remote.response.SportResponse
import com.zaky.androidexpertdicoding.core.domain.model.Teams
import com.zaky.androidexpertdicoding.core.domain.repository.ISportRepository
import com.zaky.androidexpertdicoding.core.utils.AppExecutors
import com.zaky.androidexpertdicoding.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SportRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : ISportRepository {

    override fun getAllTeams(): Flow<Resource<List<Teams>>> =
        object : NetworkBoundResource<List<Teams>, List<SportResponse>>() {
            override fun loadFromDb(): Flow<List<Teams>> {
                return localDataSource.getAllTeams().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Teams>?): Boolean =
                data == null || data.isEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<SportResponse>>> =
                remoteDataSource.getAllTeams()

            override suspend fun saveCallResult(data: List<SportResponse>) {
                val teamsList = DataMapper.mapResponseToEntities(data)
                localDataSource.insertTeams(teamsList)
            }
        }.asFlow()

    override fun getFavoriteTeams(): Flow<List<Teams>> {
        return localDataSource.getFavoriteTeams().map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun setFavoriteTeams(teams: Teams, state: Boolean) {
        val sportEntity = DataMapper.mapDomainToEntity(teams)
        appExecutors.diskIO().execute {
            localDataSource.setFavoriteTeams(sportEntity, state)
        }
    }
}