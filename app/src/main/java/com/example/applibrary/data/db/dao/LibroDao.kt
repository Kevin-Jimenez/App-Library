package com.example.applibrary.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.applibrary.data.models.LibroItemModel

@Dao
interface LibroDao {
    @Query("SELECT * FROM libros")
    suspend fun getAll(): List<LibroItemModel>

    @Query("SELECT * FROM libros WHERE genero = :gender")
    suspend fun getAllByGender(gender: String): List<LibroItemModel>

    @Query("SELECT COUNT(*) FROM libros")
    suspend fun getCount(): Int

    @Insert
    suspend fun insertAll(libros: List<LibroItemModel>)
}