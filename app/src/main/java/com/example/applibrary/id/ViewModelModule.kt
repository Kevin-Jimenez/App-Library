package com.example.applibrary.id

import com.example.applibrary.data.viewmodels.HomeViewModule
import com.example.applibrary.data.viewmodels.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        LoginViewModel(get())
    }
    viewModel {
        HomeViewModule(get())
    }
}