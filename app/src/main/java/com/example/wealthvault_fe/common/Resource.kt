package com.example.wealthvault_fe.common

import com.example.wealthvault_fe.domain.model.Post

sealed class Resource<T>(val data: T? = null, val message: String? = null) {

    // 1. Success: ส่ง data เข้ามา
    class Success<T>(data: T) : Resource<T>(data)

    // 2. Error: ส่ง message และอาจมี data เก่า
    class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)

    // 3. Loading: อาจมี data เก่าโชว์ระหว่างโหลด
    class Loading<T>(data: T? = null) : Resource<T>(data)
}