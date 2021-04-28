package com.dijon.jokesnorrisio.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dijon.jokesnorrisio.R
import com.dijon.jokesnorrisio.data.ApiService
import com.dijon.jokesnorrisio.data.model.Joke
import com.dijon.jokesnorrisio.data.response.JokeDetailsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailCategoryViewModel : ViewModel() {

    val detailCategoryLiveData: MutableLiveData<List<Joke>> = MutableLiveData()

    fun getRandonJokeByCategory(category: String) {
        ApiService.service.getJokeRandonByCategory(category)
            .enqueue(object : Callback<JokeDetailsResponse> {
                override fun onResponse(
                    call: Call<JokeDetailsResponse>,
                    response: Response<JokeDetailsResponse>
                ) {
                    when {
                        response.isSuccessful -> {
                            val jokes: MutableList<Joke> = mutableListOf()
                            response.body()?.let { jokeDetailsResponse ->
                                jokes.add(0, jokeDetailsResponse.getJokeModel())
                            }
                            detailCategoryLiveData.value = jokes
                        }
//                        response.code() == 401 -> {
//                            viewFlipperLiveData.value =
//                                Pair(ResultViewModel.VIEW_FLIPPER_ERROR, R.string.books_error_400_generic)
//                        }
//                        else -> {
//                            viewFlipperLiveData.value =
//                                Pair(ResultViewModel.VIEW_FLIPPER_ERROR, R.string.books_error_400_generic)
//                        }
                    }
                }

                override fun onFailure(call: Call<JokeDetailsResponse>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })
    }
}