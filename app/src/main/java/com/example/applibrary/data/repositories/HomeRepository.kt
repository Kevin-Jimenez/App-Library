package com.example.applibrary.data.repositories

import com.example.applibrary.data.datasource.MemoryDatasource
import com.example.applibrary.data.db.dao.LibroDao
import com.example.applibrary.data.db.dao.ServicesDao
import com.example.applibrary.data.models.CompanyModel
import com.example.applibrary.data.models.LibroItemModel
import com.example.applibrary.data.models.ServiceItemModel
import kotlinx.coroutines.delay

class HomeRepository(private val memoryDatasource: MemoryDatasource,
                     private val servicesDao: ServicesDao, private val libroDao: LibroDao) {

    suspend fun services(): List<ServiceItemModel>{
        return servicesDao.getAll()
    }

    suspend fun company(): CompanyModel{
        return  memoryDatasource.company()
    }

    suspend fun libros(gender: String?): List<LibroItemModel>{
        if(gender != null) return libroDao.getAllByGender(gender)
        return  libroDao.getAll()
    }
}