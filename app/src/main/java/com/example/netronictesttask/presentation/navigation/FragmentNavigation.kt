package com.example.netronictesttask.presentation.navigation

import androidx.fragment.app.FragmentManager
import com.example.netronictesttask.domain.model.User
import com.example.netronictesttask.presentation.fragment.AllUsersFragment
import com.example.netronictesttask.presentation.fragment.SavedUserFragment
import com.example.netronictesttask.presentation.fragment.SelectedUserFragment
import com.example.netronictesttask.presentation.fragment.SplashFragment

object FragmentNavigation: Navigation() {
    const val TAG_SPLASH_FRAGMENT = "TAG_SPLASH_FRAGMENT"
    const val TAG_RANDOM_USERS = "TAG_RANDOM_USERS"
    const val TAG_SAVED_USERS = "TAG_SAVED_USERS"
    const val TAG_SELECTED_USER = "TAG_SELECTED_USER"

    fun navigateToSplashFragment(
        fragmentManager: FragmentManager
    ) {
        navigateTo(
            fragmentManager,
            SplashFragment.newInstance(),
            TAG_SPLASH_FRAGMENT
        )
    }

    fun navigateToAllUsersFragment(
        fragmentManager: FragmentManager
    ) {
        navigateTo(
            fragmentManager,
            AllUsersFragment.newInstance(),
            TAG_RANDOM_USERS
        )
    }

    fun navigateToSavedUsersFragment(
        fragmentManager: FragmentManager
    ) {
        navigateTo(
            fragmentManager,
            SavedUserFragment.newInstance(),
            TAG_SAVED_USERS
        )
    }

    fun navigateToSelectedUserFragment(
        fragmentManager: FragmentManager,
        user: User
    ) {
        navigateToWithAdding(
            fragmentManager,
            SelectedUserFragment.newInstance(user),
            TAG_SELECTED_USER
        )
    }
}