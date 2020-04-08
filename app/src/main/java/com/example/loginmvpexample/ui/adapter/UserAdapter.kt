package com.example.loginmvpexample.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.loginmvpexample.R
import com.example.loginmvpexample.data.model.User
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.single_list_item.view.*

class UserAdapter(private var items: List<User> = ArrayList(),
                  private var context: Context
) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(LayoutInflater.from(context).inflate(R.layout.single_list_item, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class UserViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val email: TextView = itemView.text_email
        val password: TextView = itemView.text_password
        public fun bind(user: User){
            email.text = user.email
            password.text = user.password
        }
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(items[position])
    }

}
