package com.example.api.services

import com.example.api.models.requests.CreateArticleRequest
import com.example.api.models.requests.UpdateUserRequest
import com.example.api.models.responses.ArticleResponse
import com.example.api.models.responses.ArticlesResponse
import com.example.api.models.responses.ProfileResponse
import com.example.api.models.responses.UserResponse
import retrofit2.http.*
import javax.xml.ws.Response

interface ConduitAuthApi {

    @GET("user")
    suspend fun getCurrentUser(): Response<UserResponse>

    @PUT("user")
    suspend fun updateUser(
        @Body updateUserRequest : UpdateUserRequest
    ): Response<UserResponse>

    @GET("profiles/{username")
    suspend fun getProfiles(
        @Path("username") username: String
    ): Response<ProfileResponse>

    @GET("profiles/{username}/follow")
    suspend fun followProfile(
        @Path("username") username: String
    ): Response<ProfileResponse>

    @GET("profiles/:username/unfollow")
    suspend fun unfollowProfile(
        @Path("username") username: String
    ): Response<ProfileResponse>

    @GET("articles/feed")
    suspend fun getFeedArticles(
        @Query("limit") limit : Int? = null,
        @Query("offset") offset : Int? = null
    ): Response<ArticlesResponse>

    @POST("articles")
    suspend fun createArticle(
        @Body createArticleRequest: CreateArticleRequest
    ): Response<ArticleResponse>
}