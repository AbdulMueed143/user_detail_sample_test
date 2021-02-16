package au.com.userdetailsampletest.util

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import au.com.userdetailsampletest.R
import au.com.userdetailsampletest.adapters.AlbumAdapter
import au.com.userdetailsampletest.adapters.UsersAdapter
import au.com.userdetailsampletest.models.entitymodels.Album
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_album.*


@BindingAdapter("app:items")
fun setItems(listView: RecyclerView, items: List<Album>?) {
    items?.let {
        (listView.adapter as AlbumAdapter).notifyDataSetChanged()
    }
}

@BindingAdapter("bind:imageUrl")
fun setImageUrl(view: ImageView, url: String?) {
    Picasso.get().load(url).into(view)
}