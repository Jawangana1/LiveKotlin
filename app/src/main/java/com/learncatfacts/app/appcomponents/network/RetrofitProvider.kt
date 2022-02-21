package com.learncatfacts.app.appcomponents.network

import com.learncatfacts.app.BuildConfig
import com.learncatfacts.app.network.BASE_URL
import com.learncatfacts.app.network.RetrofitServices
import java.util.concurrent.TimeUnit
import kotlin.String
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

public class RetrofitProvider {
  private fun provideRetrofit(serviceBaseUrl: String, okHttpClient: OkHttpClient): Retrofit =
      Retrofit.Builder()
              .baseUrl(serviceBaseUrl)
              .client(okHttpClient)
              .addConverterFactory(GsonConverterFactory.create())
              .build()

  public fun getService(): RetrofitServices =
      provideRetrofit(BASE_URL,provideOkHttpClient()).create(RetrofitServices::class.java)

  /**
   * method which returns [OkHttpClient] used to build retrofit service
   *       @return [OkHttpClient]
   */
  private fun provideOkHttpClient(): OkHttpClient {
    val builder = OkHttpClient().newBuilder()
    .connectTimeout(5, TimeUnit.MINUTES)
    .callTimeout(5, TimeUnit.MINUTES)
    .readTimeout(1, TimeUnit.MINUTES)
    .writeTimeout(1, TimeUnit.MINUTES)
    if (BuildConfig.DEBUG) {
      builder.addInterceptor(HttpLoggingInterceptor().apply {
        this.level = HttpLoggingInterceptor.Level.BODY
        })
      }
      return builder.build()
    }
  }
