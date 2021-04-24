package com.dijon.jokesnorrisio.data.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class JokeResultsResponse(
    @Json(name = "joke_details")
    val jokeDetailsResponse: List<JokeDetailsResponse>
)