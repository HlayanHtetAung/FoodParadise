package com.hlayanhtetaung.foodparadise.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hlayanhtetaung.foodparadise.api.ApiClient
import com.hlayanhtetaung.foodparadise.model.Category
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelCategory : ViewModel() {

    private var resultCategory: MutableLiveData<Category> = MutableLiveData()

    fun getResultCategory(): LiveData<Category> = resultCategory

    fun loadResultCategory() {

        ApiClient().getCategories().enqueue(object : Callback<Category> {

            override fun onFailure(call: Call<Category>, t: Throwable) {}

            override fun onResponse(call: Call<Category>, response: Response<Category>) {
                resultCategory.value = response.body()

            }

        })

    }

}