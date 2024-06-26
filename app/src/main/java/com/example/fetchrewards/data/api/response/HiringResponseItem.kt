package com.example.fetchrewards.data.api.response


import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class HiringResponseItem(
    @SerializedName("id")
    val id: Long,
    @SerializedName("listId")
    val listId: Long,
    @SerializedName("name")
    val name: String?
)