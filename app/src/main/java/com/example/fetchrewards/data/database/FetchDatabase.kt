package com.example.fetchrewards.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.fetchrewards.data.api.model.Hiree

@Database(
    entities = [
        Hiree::class
    ],
    version = 1
)
abstract class FetchDatabase: RoomDatabase() {
    abstract fun hireeDao(): HireeDao
}