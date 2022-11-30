package com.example.applibrary.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.applibrary.data.models.ServiceItemModel


@Dao
interface ServicesDao {
    @Query("SELECT * FROM services")
    suspend fun getAll(): List<ServiceItemModel>

    @Query("SELECT COUNT(*) FROM services")
    suspend fun getCount(): Int

    @Insert
    suspend fun insertAll(services: List<ServiceItemModel>)
}