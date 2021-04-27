package com.dijon.jokesnorrisio.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dijon.jokesnorrisio.R
import com.dijon.jokesnorrisio.data.ApiService
import com.dijon.jokesnorrisio.data.model.Category
import com.dijon.jokesnorrisio.data.model.Result
import com.dijon.jokesnorrisio.data.response.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ResultViewModel : ViewModel() {

    val resultLiveData: MutableLiveData<List<String>> = MutableLiveData()
    val viewFlipperLiveData: MutableLiveData<Pair<Int, Int?>> = MutableLiveData()

    fun getCategory() {
        ApiService.service.getCategories().enqueue(object : Callback<List<String>> {
            override fun onResponse(
                call: Call<List<String>>,
                response: Response<List<String>>
            ) {
                when {
                    response.isSuccessful -> {
                        val categories: MutableList<String> = mutableListOf()

                        response.body()?.let { listCategory ->
                            for (category in listCategory) {
                                categories.add(category)
                            }
                        }
                        resultLiveData.value = categories
                        viewFlipperLiveData.value = Pair(VIEW_FLIPPER_CATEGORY, null)
                    }
                    response.code() == 401 -> {
                        viewFlipperLiveData.value =
                            Pair(VIEW_FLIPPER_ERROR, R.string.books_error_400_generic)
                    }
                    else -> {
                        viewFlipperLiveData.value =
                            Pair(VIEW_FLIPPER_ERROR, R.string.books_error_400_generic)
                    }
                }
            }

            override fun onFailure(call: Call<List<String>>, t: Throwable) {
                viewFlipperLiveData.value =
                    Pair(VIEW_FLIPPER_ERROR, R.string.books_error_500_generic)
            }
        })
    }

    companion object {
        private const val VIEW_FLIPPER_CATEGORY = 1
        private const val VIEW_FLIPPER_ERROR = 2
    }
}