package com.learncatfacts.app.network.repository

import android.util.Log
import com.learncatfacts.app.R
import com.learncatfacts.app.appcomponents.di.MyApp
import com.learncatfacts.app.extensions.NoInternetConnection
import com.learncatfacts.app.extensions.isOnline
import com.learncatfacts.app.network.RetrofitServices
import com.learncatfacts.app.network.models.fetchfact.FetchFactResponse
import com.learncatfacts.app.network.resources.ErrorResponse
import com.learncatfacts.app.network.resources.Response
import com.learncatfacts.app.network.resources.SuccessResponse
import java.lang.Exception
import kotlin.String
import org.koin.core.KoinComponent
import org.koin.core.inject

public class NetworkRepository : KoinComponent {
  private val retrofitServices: RetrofitServices by inject()

  private val errorMessage: String = "Something went wrong."

  public suspend fun fetchFact(): Response<FetchFactResponse> {
    Log.d("fetchFact", "Network call")
    return try {
      val isOnline = MyApp.getInstance().isOnline()
      if(isOnline) {
        SuccessResponse(retrofitServices.fetchFact())
      } else {
        val internetException =
            NoInternetConnection(MyApp.getInstance().getString(R.string.no_internet_connection))
        ErrorResponse(internetException.message ?:errorMessage, internetException)
      }
    } catch(e:Exception) {
      e.printStackTrace()
      ErrorResponse(e.message ?:errorMessage, e)
    }
  }
}
