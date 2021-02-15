package au.com.userdetailsampletest.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import au.com.userdetailsampletest.databinding.UserItemBinding
import au.com.userdetailsampletest.models.entitymodels.User
import au.com.userdetailsampletest.models.viewmodels.UserListViewModel

class UsersAdapter(private val viewModel: UserListViewModel) : RecyclerView.Adapter<UsersAdapter.ViewHolder>()  {

    class ViewHolder private constructor(val binding: UserItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(viewModel: UserListViewModel, item: User?) {
            binding.userListViewModel = viewModel
            binding.user = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = UserItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = viewModel.users?.get(position)
        holder.bind(viewModel, item)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int {
        return viewModel.users?.size ?: 0
    }

}