package com.example.applibrary.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "libros")
data class LibroItemModel (
    @PrimaryKey val id: String,
    val name: String,
    val genero: String,
    val image: String,
    val star: Int,
    val descripcion: String
    )