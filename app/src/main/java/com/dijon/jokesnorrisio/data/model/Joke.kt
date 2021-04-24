package com.dijon.jokesnorrisio.data.model

data class Joke(
    val created_at : String,
    val icon_url : String,
    val id : String,
    val updated_at : String,
    val url : String,
    val value : String
) {
}