package com.app.clean_architecture_kotlin.presentation.ui.viewholder

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.app.clean_architecture_kotlin.R
import com.app.clean_architecture_kotlin.data.model.User
import com.app.clean_architecture_kotlin.databinding.UserItemBinding

class AllUserViewHolder(val binding: UserItemBinding) : RecyclerView.ViewHolder(binding.root) {

    @SuppressLint("SetTextI18n")
    fun onBind(user: User, position: Int) {
        binding.email.text = user.email
        binding.name.text = "${user.firstName} ${user.lastName}"

        binding.userImage.load(user.image) {
            crossfade(true)
            placeholder(R.drawable.ic_user)
            transformations(CircleCropTransformation())
        }
    }
}