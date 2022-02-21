package com.learncatfacts.app.network

import com.learncatfacts.app.network.models.fetchfact.FetchFactResponse
import kotlin.String
import retrofit2.http.GET

public interface RetrofitServices {
  @GET("/fact")
  public suspend fun fetchFact(): FetchFactResponse
}

public const val BASE_URL: String = "https://catfact.ninja"
