package com.example.netronictesttask.presentation.viewholder

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.netronictesttask.databinding.ItemUserBinding
import com.example.netronictesttask.domain.model.User

class UsersViewHolder(
    private val binding: ItemUserBinding,
    private val context: Context,
    private val userClick: (user: User) -> Unit
): ViewHolder(binding.root) {

    fun bind(user: User) {
        with(binding) {
            if (user.picture.large.contains("/")) {
                Glide
                    .with(context)
                    .load(user.picture.large)
                    .into(ivUserPicture)
            } else {
                Glide
                    .with(context)
                    .load(context.getExternalFilesDir(null)?.path + "/images/" + user.picture.large)
                    .into(ivUserPicture)
            }
            ivUserPicture.clipToOutline = true
            tvUserName.text = user.name.title + " " + user.name.first + " " + user.name.last

            llUserCard.setOnClickListener {
                userClick(user)
            }
        }
    }

    companion object {
        fun from(parent: ViewGroup, context: Context, userClick: (user: User) -> Unit): UsersViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = ItemUserBinding.inflate(inflater, parent, false)
            return UsersViewHolder(binding, context, userClick)
        }
    }
}