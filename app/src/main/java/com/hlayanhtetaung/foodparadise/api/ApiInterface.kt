package com.hlayanhtetaung.foodparadise.api

import com.hlayanhtetaung.foodparadise.model.modelAtoZ.FirstLetter
import com.hlayanhtetaung.foodparadise.model.Category
import com.hlayanhtetaung.foodparadise.model.Random
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("categories.php")
    fun getCategory(): Call<Category>

    @GET("random.php")
    fun getRandom(): Call<Random>

    @GET("search.php")
    fun getFirstLetter(
        @Query("f") letter: String
    ): Call<FirstLetter>

}