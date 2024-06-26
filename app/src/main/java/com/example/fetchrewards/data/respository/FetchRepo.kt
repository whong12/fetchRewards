package com.example.fetchrewards.data.respository

import android.util.Log
import com.example.fetchrewards.data.api.model.Hiree
import com.example.fetchrewards.data.api.model.ResultOf
import com.example.fetchrewards.data.api.service.FetchService
import com.example.fetchrewards.data.database.FetchDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

interface FetchRepo {
    suspend fun fetchHiringJson(): Flow<ResultOf<Boolean>>
    suspend fun getAllHiree(): List<Hiree>
    suspend fun getHireeById(id: Long): Hiree
}

private const val TAG = "FetchRepoImpl"
@Singleton
class FetchRepoImpl @Inject constructor(
    private val service: FetchService,
    private val fetchDb: FetchDatabase
): FetchRepo {
    private val hireeDao by lazy { fetchDb.hireeDao() }

    override suspend fun fetchHiringJson(): Flow<ResultOf<Boolean>> {
        return flow {
            val response = service.getHiringJson()
            if(response.isSuccessful) {
                val body = response.body()
                if(body == null) {
                    emit (
                        ResultOf.Error(
                            message = "response body was null",
                            throwable = null
                        )
                    )
                } else {
                    for(hiringResponseItem in body) {
                        hireeDao.insertHiree(
                            Hiree(
                                id = hiringResponseItem.id,
                                listId = hiringResponseItem.listId,
                                name = hiringResponseItem.name
                            )
                        )
                    }
                    emit (
                        ResultOf.Success(true)
                    )
                }
            } else {
                emit (
                    ResultOf.Error (
                        message = response.message(),
                        throwable = null
                    )
                )
            }
        }
    }

    override suspend fun getAllHiree(): List<Hiree> {
        return hireeDao.getAllHiree()
    }

    override suspend fun getHireeById(id: Long): Hiree {
        return hireeDao.getHireeById(id)
    }
}