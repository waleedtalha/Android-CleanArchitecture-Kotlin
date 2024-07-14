package com.app.clean_architecture_kotlin.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.clean_architecture_kotlin.data.model.User
import com.app.clean_architecture_kotlin.databinding.UserItemBinding
import com.app.clean_architecture_kotlin.presentation.ui.viewholder.AllUserViewHolder

class UserAdapter(
    private val data: ArrayList<User>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return AllUserViewHolder(getView(parent))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as AllUserViewHolder).onBind(data[position], position)
    }

    override fun getItemCount(): Int = data.size

    private fun getView(parent: ViewGroup?): UserItemBinding {
        return UserItemBinding.inflate(LayoutInflater.from(parent?.context), parent, false)
    }
}