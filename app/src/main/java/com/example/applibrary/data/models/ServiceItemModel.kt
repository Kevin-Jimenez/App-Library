package com.example.applibrary.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "services")
data class ServiceItemModel(
    @PrimaryKey val id: String,
    val title: String,
    val description: String,
    val icon: String
)

