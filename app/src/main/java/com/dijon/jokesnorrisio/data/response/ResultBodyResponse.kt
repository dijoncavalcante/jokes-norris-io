package com.dijon.jokesnorrisio.data.response

import com.dijon.jokesnorrisio.data.model.Joke
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ResultBodyResponse(

    @Json(name = "total")
    val total: Int,
    @Json(name = "result")
    val results: List<ResultDetailResponse>
//
//    @Json(name = "result")
//val jokeList: List<Joke>
)