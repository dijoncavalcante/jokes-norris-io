package com.dijon.jokesnorrisio.data.response

import com.dijon.jokesnorrisio.data.model.Joke
import com.dijon.jokesnorrisio.data.model.Result
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ResultDetailResponse(
//    @Json(name = "total")
//    val total: Int,
    @Json(name = "result")
    val jokeList: List<Joke>
) {
    fun getResultModel() = Result(
//        total = this.total,
        jokeList = this.jokeList
    )
}