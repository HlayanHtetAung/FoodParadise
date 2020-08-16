package com.hlayanhtetaung.foodparadise.api

import com.hlayanhtetaung.foodparadise.model.modelAtoZ.FirstLetter
import com.hlayanhtetaung.foodparadise.model.Category
import com.hlayanhtetaung.foodparadise.model.Random
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    private val baseUrl = "https://www.themealdb.com/api/json/v1/1/"
    private var apiInterface: ApiInterface

    init {

        apiInterface =
            Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create())
                .build().create(ApiInterface::class.java)
    }

    fun getCategories(): Call<Category> {
        return apiInterface.getCategory()
    }

    fun getRandoms(): Call<Random> {
        return apiInterface.getRandom()
    }

    fun getFirstLetter(letter: String): Call<FirstLetter> {
        return apiInterface.getFirstLetter(letter)
    }
}