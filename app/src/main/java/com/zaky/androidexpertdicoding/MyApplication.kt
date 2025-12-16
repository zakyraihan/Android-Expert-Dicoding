package com.zaky.androidexpertdicoding

import android.app.Application
import com.zaky.androidexpertdicoding.core.di.databaseModule
import com.zaky.androidexpertdicoding.core.di.networkModule
import com.zaky.androidexpertdicoding.core.di.repositoryModule
import com.zaky.androidexpertdicoding.di.useCaseModule
import com.zaky.androidexpertdicoding.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}