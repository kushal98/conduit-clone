package com.example.api.models.requests


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LoginUser(
    @Json(name = "email")
    val email: String,
    @Json(name = "password")
    val password: String
)