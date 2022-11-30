package com.example.applibrary

import android.text.TextUtils
import android.util.Patterns

fun String.isValidEmail(): Boolean{
    return !TextUtils.isEmpty(this) && Patterns.EMAIL_ADDRESS.matcher(this).matches()
}

fun String.isValidPassword(): Boolean{
    return this.length >= 8
}

fun String.isValidDocument(): Boolean{
    return this.length >= 6;
}

fun String.isValidName(): Boolean{
    return this.length >= 1
}