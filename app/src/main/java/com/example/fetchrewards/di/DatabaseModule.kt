package com.example.fetchrewards.di

import android.content.Context
import androidx.room.Room
import com.example.fetchrewards.data.database.FetchDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DatabaseModule {
    private const val DATABASE_NAME = "fetch_database"

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): FetchDatabase {
        return Room
            .databaseBuilder(
                appContext,
                FetchDatabase::class.java,
                DATABASE_NAME
            )
            .fallbackToDestructiveMigration()
            .build()
    }
}