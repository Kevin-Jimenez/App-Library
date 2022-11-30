package com.example.applibrary.id

import com.example.applibrary.data.repositories.HomeRepository
import com.example.applibrary.data.repositories.LoginRepository
import org.koin.dsl.module

val repoModule = module {
    single { LoginRepository(get(), get()) }
    single { HomeRepository(get(), get(), get()) }
}