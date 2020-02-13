package com.seleznov.randome.remote

import com.seleznov.randome.remote.dto.ResultModel
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("api")
    fun getPersons(@Query("page") page: Int, @Query("results") count: Int, @Query("seed") seed: String): Single<ResultModel>

    companion object {
        fun getService(): ApiService {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://randomuser.me/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(ApiService::class.java)
        }
    }
}