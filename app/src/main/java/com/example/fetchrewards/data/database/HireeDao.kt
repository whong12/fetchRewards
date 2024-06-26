package com.example.fetchrewards.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.fetchrewards.data.api.model.Hiree

@Dao
interface HireeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHiree(hiree: Hiree)

    @Query("SELECT * FROM hiree_dao")
    suspend fun getAllHiree(): List<Hiree>

    @Query("SELECT * FROM hiree_dao WHERE id=:id")
    suspend fun getHireeById(id: Long): Hiree
}