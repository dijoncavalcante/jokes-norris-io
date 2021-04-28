package com.dijon.jokesnorrisio.data

import com.dijon.jokesnorrisio.data.response.JokeBodyResponse
import com.dijon.jokesnorrisio.data.response.JokeDetailsResponse
import com.dijon.jokesnorrisio.data.response.ResultDetailResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface JNServices {

//https://api.chucknorris.io/jokes/categories
//https://api.chucknorris.io/jokes/random?category=animal
//https://api.chucknorris.io/jokes/search?query={query}

    @GET("categories")
    fun getCategories(): Call<List<String>>

    @GET("random")
    fun getJokeRandonByCategory(
        //TODO o argumento "animal" esta estatico
        @Query("category") category: String//= "animal"
    ): Call<JokeDetailsResponse>
//
//    @GET("search")
//    fun getSearch(
//        //TODO O argumento "rambo" esta estatico
//        @Query("query") query: String = "rambo"
//    ): Call<JokeBodyResponse>
}