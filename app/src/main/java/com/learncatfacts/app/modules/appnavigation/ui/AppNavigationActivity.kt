package com.learncatfacts.app.modules.appnavigation.ui

import androidx.activity.viewModels
import com.learncatfacts.app.R
import com.learncatfacts.app.appcomponents.base.BaseActivity
import com.learncatfacts.app.databinding.ActivityAppNavigationBinding
import com.learncatfacts.app.modules.androidlarge1.ui.AndroidLarge1Activity
import com.learncatfacts.app.modules.appnavigation.`data`.viewmodel.AppNavigationVM
import kotlin.String
import kotlin.Unit

public class AppNavigationActivity :
    BaseActivity<ActivityAppNavigationBinding>(R.layout.activity_app_navigation) {
  private val viewModel: AppNavigationVM by viewModels<AppNavigationVM>()

  public override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras
    binding.appNavigationVM = viewModel
  }

  public override fun setUpClicks(): Unit {
    binding.linearAndroidLarge1.setOnClickListener {
      val destIntent = AndroidLarge1Activity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  public companion object {
    public const val TAG: String = "APP_NAVIGATION_ACTIVITY"
  }
}
