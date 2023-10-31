package com.example.lezycolum

data class data_gson(
    val timestamp: String,
    val code: String,
    val message: String,
    val path: String,
    val data3: Data,
    val errorDetail: Any
)

data class Data(
    val userId: Int,
    val avatar: String,
    val nickname: String,
    val gender: Int,
    val birthday: Long,
    val age: Int,
    val province: String,
    val city: String,
    val district: String,
    val workStatus: String,
    val userType: Int
)