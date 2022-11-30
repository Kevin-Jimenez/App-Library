package com.example.applibrary.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.applibrary.data.db.dao.LibroDao
import com.example.applibrary.data.db.dao.ServicesDao
import com.example.applibrary.data.models.LibroItemModel
import com.example.applibrary.data.models.ServiceItemModel

@Database(entities = [LibroItemModel::class, ServiceItemModel::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun libroDao(): LibroDao
    abstract  fun servicesDao(): ServicesDao
}