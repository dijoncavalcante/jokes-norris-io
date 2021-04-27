package com.dijon.jokesnorrisio.data.response

//import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
//import com.squareup.moshi.ToJson

@JsonClass(generateAdapter = true)
data class CategoryResponse(
    val categories: List<String>
) {
}