package com.example.netronictesttask.presentation.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.netronictesttask.domain.model.User
import com.example.netronictesttask.presentation.viewholder.UsersViewHolder

class UsersAdapter(
    private val context: Context,
    private val userClick: (user: User) -> Unit
): Adapter<UsersViewHolder>() {
    private var listUsers: MutableList<User> = mutableListOf()

    fun setListUsers(listUsers: List<User>) {
        this.listUsers = listUsers.toMutableList()
        notifyItemRangeChanged(0, listUsers.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder =
        UsersViewHolder.from(parent, context, userClick)

    override fun getItemCount(): Int =
        listUsers.size

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        holder.bind(listUsers[position])
    }
}