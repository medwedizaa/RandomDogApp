package com.example.randomdogapp.network

import retrofit2.Call
import retrofit2.http.GET

interface DogApiService {
    @GET("breeds/image/random")
    fun getRandomDog(): Call<RandomDogAnswer>
}