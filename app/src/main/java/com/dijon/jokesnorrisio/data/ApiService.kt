package com.dijon.jokesnorrisio.data

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

//https://api.chucknorris.io/jokes/categories
//https://api.chucknorris.io/jokes/random?category=animal
//https://api.chucknorris.io/jokes/search?query={query}

class ApiService {
    private fun initRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.chucknorris.io/jokes/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    val service: JNServices = initRetrofit().create(JNServices::class.java)
}