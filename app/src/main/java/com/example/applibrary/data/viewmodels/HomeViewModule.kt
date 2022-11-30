package com.example.applibrary.data.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.applibrary.data.models.CompanyModel
import com.example.applibrary.data.models.LibroItemModel
import com.example.applibrary.data.models.ServiceItemModel
import com.example.applibrary.data.repositories.HomeRepository
import kotlinx.coroutines.launch

class HomeViewModule(private val repo: HomeRepository): ViewModel() {

    private var _services: MutableLiveData<List<ServiceItemModel>> = MutableLiveData()
    val services: LiveData<List<ServiceItemModel>> get() = _services

    private var _company: MutableLiveData<CompanyModel> = MutableLiveData()
    val company: LiveData<CompanyModel> get() = _company

    private var _libros: MutableLiveData<List<LibroItemModel>> = MutableLiveData()
    val libros: LiveData<List<LibroItemModel>> get() = _libros

    private var _selected: MutableLiveData<LibroItemModel> = MutableLiveData()
    val selected: LiveData<LibroItemModel> get() = _selected

    fun services(){
        viewModelScope.launch {
            _services.postValue(repo.services())
        }
    }

    fun company(){
        viewModelScope.launch {
            _company.postValue(repo.company())
        }
    }

    fun libros(gender: String?){
        viewModelScope.launch {
            _libros.postValue(repo.libros(gender))
        }
    }

    fun clear(){
        _libros.postValue(listOf())
    }

    fun selected(item: LibroItemModel){
        _selected.postValue(item)
    }
}