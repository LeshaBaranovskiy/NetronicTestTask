package com.example.netronictesttask.presentation.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.netronictesttask.R

open class Navigation {
    fun navigateTo(
        fragmentManager: FragmentManager,
        fragment: Fragment,
        tag: String
    ) {
        saveFragmentToBackStackAndReplace(fragmentManager, fragment, tag, R.id.fragment_container)
    }

    fun navigateToWithAdding(
        fragmentManager: FragmentManager,
        fragment: Fragment,
        tag: String
    ) {
        saveFragmentToBackStackAndAdd(fragmentManager, fragment, tag, R.id.fragment_container)
    }

    private fun saveFragmentToBackStackAndReplace(
        fragmentManager: FragmentManager,
        fragment: Fragment,
        tag: String,
        fragmentContainer: Int
    ) {
        fragmentManager
            .beginTransaction()
            .replace(fragmentContainer, fragment, tag)
            .addToBackStack(tag)
            .commit()
    }

    private fun saveFragmentToBackStackAndAdd(
        fragmentManager: FragmentManager,
        fragment: Fragment,
        tag: String,
        fragmentContainer: Int
    ) {
        fragmentManager
            .beginTransaction()
            .add(fragmentContainer, fragment, tag)
            .addToBackStack(tag)
            .commit()
    }
}