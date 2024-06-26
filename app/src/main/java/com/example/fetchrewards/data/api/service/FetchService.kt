package com.example.fetchrewards.data.api.service

import com.example.fetchrewards.data.api.response.HiringResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface FetchService {
    @GET("hiring.json")
    suspend fun getHiringJson(): Response<HiringResponse>
}