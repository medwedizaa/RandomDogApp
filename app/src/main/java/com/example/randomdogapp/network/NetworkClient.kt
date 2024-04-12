package com.example.randomdogapp.network

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkClient {
    private var service: DogApiService? = null
    private val logging: HttpLoggingInterceptor = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BASIC)

    fun initClient() {

        val httpClient: OkHttpClient.Builder
                = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build()

        service = retrofit.create(DogApiService::class.java)

    }

    fun getDog() {
        service?.getRandomDog()?.enqueue(object : Callback<RandomDogAnswer> {
            override fun onResponse(call: Call<RandomDogAnswer>, response: Response<RandomDogAnswer>) {
                val dogImageUrl = response.body()?.message
                Log.i("DOG APP DEBUG", "the dog image address is $dogImageUrl")
            }

            override fun onFailure(call: Call<RandomDogAnswer>, error: Throwable) {
                Log.e("DOG APP DEBUG", "It's an error while we were trying to get a dog image", error)
            }

        })
    }
}