package com.zaky.androidexpertdicoding.core.data.source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.zaky.androidexpertdicoding.core.data.source.local.entity.SportEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SportDAO {

    @Query("SELECT * FROM teams")
    fun getAllTeams(): Flow<List<SportEntity>>

    @Query("SELECT * FROM teams where isFavorite = 1")
    fun getFavoriteTeams(): Flow<List<SportEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTeams(teams: List<SportEntity>)

    @Update
    fun updateFavoriteTeams(teams: SportEntity);
}