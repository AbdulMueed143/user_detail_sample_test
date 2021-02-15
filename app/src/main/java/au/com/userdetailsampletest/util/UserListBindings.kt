package au.com.userdetailsampletest.util

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import au.com.userdetailsampletest.adapters.UsersAdapter
import au.com.userdetailsampletest.models.entitymodels.User

@BindingAdapter("app:items")
fun setItems(listView: RecyclerView, items: List<User>?) {
    items?.let {
        (listView.adapter as UsersAdapter).notifyDataSetChanged()
    }
}