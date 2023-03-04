package com.example.netronictesttask.presentation.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.netronictesttask.R
import com.example.netronictesttask.databinding.FragmentSelectedUserBinding
import com.example.netronictesttask.domain.model.User

class SelectedUserFragment(
    private val user: User
): BaseFragment(R.layout.fragment_selected_user) {
    private lateinit var binding: FragmentSelectedUserBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSelectedUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
        setOnClickListeners()
    }

    @SuppressLint("SetTextI18n")
    private fun initData() {
        with(binding) {
            if (user.picture.large.contains("/")) {
                Glide
                    .with(requireActivity().applicationContext)
                    .load(user.picture.large)
                    .into(ivUserPicture)
            } else {
                Glide
                    .with(requireActivity().applicationContext)
                    .load(requireActivity().applicationContext.getExternalFilesDir(null)?.path + "/images/" + user.picture.large)
                    .into(ivUserPicture)
            }
            tvUserName.text = getString(R.string.user_details_name) + " " + user.name.title + " " + user.name.first + " " + user.name.last
            tvUserEmail.text = getString(R.string.user_details_email) + " " + user.email
            tvUserGender.text = getString(R.string.user_details_gender) + " " + user.gender
            tvUserNationality.text = getString(R.string.user_details_nationality) + " " + user.nat
            tvUserPhone.text = getString(R.string.user_details_phone) + " " + user.phone
        }
    }

    private fun setOnClickListeners() {
        binding.ivBackButton.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }

    companion object {
        fun newInstance(user: User) =
            SelectedUserFragment(user)
    }
}