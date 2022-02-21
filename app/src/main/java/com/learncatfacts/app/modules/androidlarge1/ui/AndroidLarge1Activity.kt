package com.learncatfacts.app.modules.androidlarge1.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.learncatfacts.app.R
import com.learncatfacts.app.appcomponents.base.BaseActivity
import com.learncatfacts.app.databinding.ActivityAndroidLarge1Binding
import com.learncatfacts.app.modules.androidlarge1.`data`.viewmodel.AndroidLarge1VM
import kotlin.String
import kotlin.Unit

public class AndroidLarge1Activity :
    BaseActivity<ActivityAndroidLarge1Binding>(R.layout.activity_android_large_1) {
  private val viewModel: AndroidLarge1VM by viewModels<AndroidLarge1VM>()

  public override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras
    binding.androidLarge1VM = viewModel
  }

  public override fun setUpClicks(): Unit {
  }

  public companion object {
    public const val TAG: String = "ANDROID_LARGE1ACTIVITY"

    public fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, AndroidLarge1Activity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
