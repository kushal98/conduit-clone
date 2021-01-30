package com.conduit.api

import com.example.api.models.entities.UserCreds
import com.example.api.models.requests.SignupRequest
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test
import kotlin.random.Random

class ConduitClientTests {

    private val conduitClient = com.example.api.ConduitClient()

    @Test
    fun `GET articles`(){
        runBlocking {
            var articles = conduitClient.api.getArticles()
            assertNotNull(articles.body()?.articles)
        }
    }

    @Test
    fun `GET articles by author`(){
        runBlocking {
            var articles = conduitClient.api.getArticles(author = "444")
            assertNotNull(articles.body()?.articles)
        }
    }

    @Test
    fun `create User - post user`(){

        val userCreds = UserCreds(
            email = "testemail${Random.nextInt(999,9999)}@test.com",
            password = "pass@123",
            username = "nd_use_${Random.nextInt(99,9999)}"
        )

        runBlocking {
            val resp = conduitClient.api.signupUser(
                SignupRequest(userCreds)
            )
            assertEquals(userCreds.username , resp.body()?.user?.username)
        }
    }
}