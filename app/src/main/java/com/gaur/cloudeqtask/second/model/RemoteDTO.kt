package com.gaur.cloudeqtask.second.model

data class RemoteDTO(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val rating: RatingDTO,
    val title: String
)