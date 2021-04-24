package com.dijon.jokesnorrisio.data.response

import com.dijon.jokesnorrisio.data.model.Joke
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class JokeDetailsResponse(
    @Json(name = "categories")
    val categories: List<String>,
    @Json(name = "created_at")
    val created_at: String,
    @Json(name = "icon_url")
    val icon_url: String,
    @Json(name = "id")
    val id: String,
    @Json(name = "updated_at")
    val updated_at: String,
    @Json(name = "url")
    val url: String,
    @Json(name = "value")
    val value: String
) {
    fun getJokeModel() = Joke(
        categories = this.categories,
        created_at = this.created_at,
        icon_url = this.icon_url,
        id = this.id,
        updated_at = this.updated_at,
        url = this.url,
        value = this.value
    )
}