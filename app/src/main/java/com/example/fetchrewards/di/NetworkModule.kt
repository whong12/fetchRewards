package com.example.fetchrewards.di

import android.util.Log
import com.example.fetchrewards.data.api.service.FetchService
import com.example.fetchrewards.data.database.FetchDatabase
import com.example.fetchrewards.data.respository.FetchRepo
import com.example.fetchrewards.data.respository.FetchRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object NetworkModule {
    private const val BASE_URL = "https://fetch-hiring.s3.amazonaws.com/"
    private const val TAG = "NetworkModule"

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor(
            HttpLoggingInterceptor.Logger {
                Log.i(TAG, it)
            }
        )
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideFetchService(okHttpClient: OkHttpClient): FetchService {
        val api: FetchService = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FetchService::class.java)
        return api
    }

    @Provides
    @Singleton
    fun provideFetchRepo(
        fetchService: FetchService,
        fetchDb: FetchDatabase
    ): FetchRepo {
        return FetchRepoImpl(fetchService, fetchDb)
    }
}