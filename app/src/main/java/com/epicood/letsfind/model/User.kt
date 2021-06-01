package com.epicood.letsfind.model

data class User(
    val username: String?,
    val email: String?,
    val password: String?,
    val point: String?,
    val image: String?,
    var uuid: String?
)
