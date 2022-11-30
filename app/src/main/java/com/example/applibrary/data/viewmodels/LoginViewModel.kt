package com.example.applibrary.data.viewmodels

import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.applibrary.data.models.UserModel
import com.example.applibrary.data.repositories.LoginRepository
import com.example.applibrary.id.viewModelModule
import com.google.firebase.auth.FirebaseAuthException
import kotlinx.coroutines.launch

class LoginViewModel(private val repo: LoginRepository): ViewModel() {

    private var _login: MutableLiveData<Boolean> = MutableLiveData()
    val login: LiveData<Boolean> get() = _login

    private var _error: MutableLiveData<String> = MutableLiveData()
    val error: LiveData<String> get() = _error

    private var _user: MutableLiveData<UserModel> = MutableLiveData()
    val user: LiveData<UserModel> get() = _user

    private var _signUp: MutableLiveData<Boolean> = MutableLiveData()
    val signUp: LiveData<Boolean> get() = _signUp


    fun login(email: String, password: String){
        viewModelScope.launch {
            try {
                repo.login(email, password)
                _login.postValue(true)
            }catch (e: Exception){
                _error.postValue(e.message.toString())
            }
        }
    }

    fun signUp(documento: String, name: String, email: String, password: String){
        viewModelScope.launch {
            try {
                repo.signUp(documento, name, email, password)
                _signUp.postValue(true)
            }catch (e: Exception){
                _error.postValue(e.message.toString())
            }
        }
    }

    fun currentUser(){
        viewModelScope.launch {
            try{
                _user.postValue(repo.currentUser())
            }catch (e: FirebaseAuthException){
                _user.postValue(null)
            }
        }
    }

    fun logOut(){
        viewModelScope.launch {
            repo.logOut()
            _user.postValue(null)
        }
    }
}