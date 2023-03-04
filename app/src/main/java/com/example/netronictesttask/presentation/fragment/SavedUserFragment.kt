package com.example.netronictesttask.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.netronictesttask.R
import com.example.netronictesttask.data.result.asFailure
import com.example.netronictesttask.data.result.asSuccess
import com.example.netronictesttask.data.result.getErrorInfo
import com.example.netronictesttask.data.result.isSuccess
import com.example.netronictesttask.databinding.FragmentSavedUsersBinding
import com.example.netronictesttask.domain.model.User
import com.example.netronictesttask.domain.params.RandomUsersParams
import com.example.netronictesttask.presentation.adapter.UsersAdapter
import com.example.netronictesttask.presentation.navigation.FragmentNavigation
import com.example.netronictesttask.presentation.viewmodel.RandomUsersViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SavedUserFragment: BaseFragment(R.layout.fragment_saved_users) {
    private lateinit var binding: FragmentSavedUsersBinding

    private lateinit var usersAdapter: UsersAdapter
    private val viewModel: RandomUsersViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSavedUsersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()
        getUsers()
    }

    private fun initAdapter() {
        usersAdapter = UsersAdapter(requireContext()) { user -> navigateToDetails(user) }
        binding.rvSavedUsersList.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvSavedUsersList.adapter = usersAdapter
    }

    private fun getUsers() {
        viewModel.getAllUsersFromDb().observe(viewLifecycleOwner) {
            if (it.isEmpty()) {
                binding.llStorageEmpty.visibility = View.VISIBLE
                binding.rvSavedUsersList.visibility = View.GONE
            } else {
                binding.rvSavedUsersList.visibility = View.VISIBLE
                binding.llStorageEmpty.visibility = View.GONE
                usersAdapter.setListUsers(it)
            }
        }
    }

    private fun navigateToDetails(user: User) {
        FragmentNavigation.navigateToSelectedUserFragment(parentFragmentManager, user)
    }

    companion object {
        fun newInstance() =
            SavedUserFragment()
    }
}