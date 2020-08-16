package com.hlayanhtetaung.foodparadise.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hlayanhtetaung.foodparadise.api.ApiClient
import com.hlayanhtetaung.foodparadise.model.Random
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelRandom : ViewModel() {
    private var resultRandom: MutableLiveData<Random> = MutableLiveData()

    fun getResultRandom(): LiveData<Random> = resultRandom

    fun loadResultRandom() {
        ApiClient().getRandoms().enqueue(object : Callback<Random> {

            override fun onFailure(call: Call<Random>, t: Throwable) {}

            override fun onResponse(call: Call<Random>, response: Response<Random>) {
                resultRandom.value = response.body()
            }
        })
    }
}