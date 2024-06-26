package com.example.fetchrewards.data.api.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "hiree_dao")
data class Hiree (
    @ColumnInfo(name = "id")
    @PrimaryKey
    val id: Long,

    @ColumnInfo(name = "listId")
    val listId: Long,

    @ColumnInfo(name = "name")
    val name: String?
) : Comparable<Hiree> {
    override fun compareTo(other: Hiree): Int {
        if(this.listId == other.listId) {
            val thisName = this.name ?: ""
            val otherName = other.name ?: ""
            return thisName.compareTo(otherName)
        }
        return this.listId.compareTo(other.listId)
    }
}