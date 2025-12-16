package com.zaky.androidexpertdicoding.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.zaky.androidexpertdicoding.core.data.source.local.entity.SportEntity

@Database(entities = [SportEntity::class], version = 5, exportSchema = false)
abstract class SportDatabase: RoomDatabase() {

    abstract fun sportDao(): SportDAO
}