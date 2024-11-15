package com.eddy.yakdabang.network

import io.ktor.client.call.body
import io.ktor.http.isSuccess
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class NewRepository{
    private val newsApi = NewsApi(ktorClient)

    suspend fun getSearchNews(query: String): Flow<List<NewsData>> = flow{
        try {
            newsApi.getNews(query).run {
                if (status.isSuccess()){
                    //Data Reponse 자동 역직렬화
                    val response = body<NewsResponse>()

                    emit(response.items)
                }else{
                    //Api Error 처리
                }
            }
        }catch (e: Exception){
            //Network Error 처리
        }
    }
}