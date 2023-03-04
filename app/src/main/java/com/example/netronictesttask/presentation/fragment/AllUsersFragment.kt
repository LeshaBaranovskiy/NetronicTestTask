package com.example.netronictesttask.presentation.fragment

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat.checkSelfPermission
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.netronictesttask.R
import com.example.netronictesttask.common.util.Utils
import com.example.netronictesttask.data.result.asFailure
import com.example.netronictesttask.data.result.asSuccess
import com.example.netronictesttask.data.result.getErrorInfo
import com.example.netronictesttask.data.result.isSuccess
import com.example.netronictesttask.databinding.FragmentAllUsersBinding
import com.example.netronictesttask.domain.model.User
import com.example.netronictesttask.domain.params.RandomUsersParams
import com.example.netronictesttask.presentation.activity.MainActivity
import com.example.netronictesttask.presentation.adapter.UsersAdapter
import com.example.netronictesttask.presentation.navigation.FragmentNavigation
import com.example.netronictesttask.presentation.viewmodel.RandomUsersViewModel
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

@AndroidEntryPoint
class AllUsersFragment: BaseFragment(R.layout.fragment_all_users) {
    private lateinit var binding: FragmentAllUsersBinding

    private val viewModel: RandomUsersViewModel by viewModels()
    private lateinit var usersAdapter: UsersAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAllUsersBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as MainActivity).showBars()
        initAdapter()
        setOnClickListeners()
    }

    private fun setOnClickListeners() {
        binding.btnGenerateList.setOnClickListener {
            getUsers()
        }
    }

    private fun initAdapter() {
        usersAdapter = UsersAdapter(requireContext()) { user -> navigateToDetails(user) }
        binding.rvUsersList.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvUsersList.adapter = usersAdapter
    }

    private fun getUsers() {
        viewModel.getUsers(RandomUsersParams(20)).observe(viewLifecycleOwner) {
            when(it.isSuccess()) {
                true -> {
                    clearDatabaseAndInternalStorage(it.asSuccess().value)
                }
                false -> {
                    if (it.asFailure().getErrorInfo().message == "No connection!") {
                        noConnectionErrorHandle()
                    } else {
                        Toast.makeText(requireActivity().applicationContext, getString(R.string.something_went_wrong), Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }

    private fun clearDatabaseAndInternalStorage(list: List<User>) {
        viewModel.deleteAllUsersFromDb().observe(viewLifecycleOwner) {
            Log.d("DATABASE", "all data deleted")
            binding.btnGenerateList.visibility = View.GONE
            binding.rvUsersList.visibility = View.VISIBLE
            binding.ivNoConnection.visibility = View.GONE
            usersAdapter.setListUsers(list)
            saveUsersToDb(list)
        }

        Utils.deleteAllImagesFromInternalStorage(requireActivity().applicationContext)
    }

    private fun saveUsersToDb(users: List<User>) {
        viewModel.insertUsersToDb(users).observe(viewLifecycleOwner) {
            Log.i("DATABASE", "inserted")
        }
        if (isStoragePermissionGranted()) {
            users.forEach { user ->
                Picasso
                    .get()
                    .load(user.picture.large)
                    .into(object : com.squareup.picasso.Target {
                        override fun onBitmapLoaded(
                            bitmap: Bitmap?,
                            from: Picasso.LoadedFrom?
                        ) {
                            if (bitmap != null) {
                                Utils.saveImageToInternalStorage(
                                    bitmap,
                                    user.id.value,
                                    requireActivity().applicationContext,
                                    packageName = requireActivity().packageName
                                )
                            }
                        }

                        override fun onBitmapFailed(e: Exception?, errorDrawable: Drawable?) {}

                        override fun onPrepareLoad(placeHolderDrawable: Drawable?) {}

                    })
            }
        }
    }

    private fun noConnectionErrorHandle() {
        binding.btnGenerateList.visibility = View.VISIBLE
        binding.rvUsersList.visibility = View.GONE
        binding.ivNoConnection.visibility = View.VISIBLE
    }

    private fun navigateToDetails(user: User) {
        FragmentNavigation.navigateToSelectedUserFragment(parentFragmentManager, user)
    }

    private fun isStoragePermissionGranted(): Boolean {
        if (checkSelfPermission(requireActivity().applicationContext, Manifest.permission.WRITE_EXTERNAL_STORAGE)
            == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            ActivityCompat.requestPermissions(requireActivity(),
                arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), 2);
            return false;
        }
    }

    companion object {
        fun newInstance() =
            AllUsersFragment()
    }
}