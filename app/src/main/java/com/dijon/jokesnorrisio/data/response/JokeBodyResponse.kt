package com.dijon.jokesnorrisio.data.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class JokeBodyResponse(
    @Json(name = "result")
    val jokeResults: List<JokeResultsResponse>
)