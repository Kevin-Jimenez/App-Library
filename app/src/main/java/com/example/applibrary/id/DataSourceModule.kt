package com.example.applibrary.id

import androidx.room.Room
import com.example.applibrary.data.datasource.MemoryDatasource
import com.example.applibrary.data.db.AppDatabase
import com.example.applibrary.data.db.dao.LibroDao
import com.example.applibrary.data.db.dao.ServicesDao
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataSourceModule = module {
    single { MemoryDatasource() }
    single<AppDatabase> {Room.databaseBuilder(androidContext(), AppDatabase::class.java, "applibrary").build() }
    single<LibroDao> { get<AppDatabase>().libroDao() }
    single<ServicesDao> { get<AppDatabase>().servicesDao() }
    single { Firebase.auth }
    single { Firebase.firestore }
}