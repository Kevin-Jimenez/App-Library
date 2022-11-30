package com.example.applibrary.interfaces

import com.example.applibrary.data.models.LibroItemModel

interface OnLibroClickListener {
    fun onClick(item: LibroItemModel)
}