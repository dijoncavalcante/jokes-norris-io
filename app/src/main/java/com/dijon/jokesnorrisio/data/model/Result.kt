package com.dijon.jokesnorrisio.data.model

data class Result(
    val total : Int,
    val categories : List<String>,
    val joke : List<Joke>
)