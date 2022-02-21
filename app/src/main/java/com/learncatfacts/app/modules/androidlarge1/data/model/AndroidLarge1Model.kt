package com.learncatfacts.app.modules.androidlarge1.`data`.model

import com.learncatfacts.app.R
import com.learncatfacts.app.appcomponents.di.MyApp
import kotlin.String

public data class AndroidLarge1Model(
  /**
   * TODO Replace with dynamic value
   */
  public var txt75: String? = MyApp.getInstance().resources.getString(R.string.lbl_75)
  ,
  /**
   * TODO Replace with dynamic value
   */
  public var txtNeuteringacat: String? =
      MyApp.getInstance().resources.getString(R.string.msg_neutering_a_cat)

)
