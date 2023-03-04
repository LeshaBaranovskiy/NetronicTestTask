package com.example.netronictesttask.presentation.activity

import android.content.res.Configuration
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES
import com.example.netronictesttask.R
import com.example.netronictesttask.common.util.PrefsHelper
import com.example.netronictesttask.databinding.ActivityMainBinding
import com.example.netronictesttask.presentation.navigation.FragmentNavigation
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var prefsHelper: PrefsHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        checkCurrentMode()

        bottomNavigation()
        setOnClickListeners()
        if (prefsHelper.getIsRestoredBoolean()) {
            FragmentNavigation.navigateToAllUsersFragment(supportFragmentManager)
        } else {
            FragmentNavigation.navigateToSplashFragment(supportFragmentManager)
        }
        prefsHelper.putIsRestoredBoolean(false)
    }

    fun hideBars() {
        binding.bottomBar.visibility = View.GONE
        binding.llSwitcher.visibility = View.GONE
    }

    fun showBars() {
        binding.bottomBar.visibility = View.VISIBLE
        binding.llSwitcher.visibility = View.VISIBLE
    }

    private fun setOnClickListeners() {
        binding.switcherNightMode.setOnCheckedChangeListener { _, isChecked ->
            if (!isChecked) {
                AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_NO)
                prefsHelper.putIsInDarkModeBoolean(false)
                prefsHelper.putIsRestoredBoolean(true)
            } else {
                AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_YES)
                prefsHelper.putIsInDarkModeBoolean(true)
                prefsHelper.putIsRestoredBoolean(true)
            }
        }
    }

    private fun checkCurrentMode() {
        if (prefsHelper.getIsInDarkModeBoolean()) {
            AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_YES)
            binding.switcherNightMode.isChecked = true
        } else {
            AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_NO)
            binding.switcherNightMode.isChecked = false
        }
    }

    private fun bottomNavigation() {
        binding.bottomBar.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.ll_users_list -> {
                    FragmentNavigation.navigateToAllUsersFragment(supportFragmentManager)
                }
                R.id.ll_saved_users_list -> {
                    FragmentNavigation.navigateToSavedUsersFragment(supportFragmentManager)
                }
            }
            return@setOnItemSelectedListener true
        }
    }

}