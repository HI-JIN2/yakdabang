package com.eddy.yakdabang.network

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.statement.HttpResponse

class NewsApi(private val client: HttpClient){
    suspend fun getNews(query: String) : HttpResponse = client.get{
        parameter("query", query)
    }
}