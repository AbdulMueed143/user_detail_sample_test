package au.com.userdetailsampletest.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import au.com.userdetailsampletest.databinding.AlbumItemBinding
import au.com.userdetailsampletest.models.entitymodels.Album
import au.com.userdetailsampletest.models.viewmodels.AlbumListViewModel

class AlbumAdapter(private val albumListViewModel: AlbumListViewModel) :
    RecyclerView.Adapter<AlbumAdapter.ViewHolder>() {

    class ViewHolder(val binding: AlbumItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(viewModel: AlbumListViewModel, item: Album?) {
            binding.albumListViewModel = viewModel
            binding.album = item
            binding.executePendingBindings()
        }

        companion object {

            fun from(parent: ViewGroup) : ViewHolder  {
                val inflater = LayoutInflater.from(parent.context)
                val binding = AlbumItemBinding.inflate(inflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = albumListViewModel.albums?.get(position)
        holder.bind(albumListViewModel, item)
    }

    override fun getItemCount(): Int  = albumListViewModel.albums?.size ?: 0

    override fun getItemViewType(position: Int): Int {
        return position
    }

}