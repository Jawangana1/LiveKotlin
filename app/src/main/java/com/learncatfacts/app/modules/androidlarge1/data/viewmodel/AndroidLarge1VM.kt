package com.learncatfacts.app.modules.androidlarge1.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.learncatfacts.app.modules.androidlarge1.`data`.model.AndroidLarge1Model

public class AndroidLarge1VM : ViewModel() {
  public val androidLarge1Model: MutableLiveData<AndroidLarge1Model> =
      MutableLiveData(AndroidLarge1Model())

  public var navArguments: Bundle? = null
}
