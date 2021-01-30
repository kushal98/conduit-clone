package com.example.condduit.data

import com.example.api.ConduitClient

object ArticlesRepo {

    val api = ConduitClient().api

    suspend fun getGlobalfeed() = api.getArticles()

}