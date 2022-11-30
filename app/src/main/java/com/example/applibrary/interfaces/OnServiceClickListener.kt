package com.example.applibrary.interfaces

import com.example.applibrary.data.models.ServiceItemModel

interface OnServiceClickListener {
    fun onClick(item: ServiceItemModel)
}