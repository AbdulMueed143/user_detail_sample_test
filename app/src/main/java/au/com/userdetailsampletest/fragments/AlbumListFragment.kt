package au.com.userdetailsampletest.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import au.com.userdetailsampletest.R
import au.com.userdetailsampletest.adapters.AlbumAdapter
import au.com.userdetailsampletest.databinding.AlbumListFragmentBinding
import au.com.userdetailsampletest.databinding.BottomSheetImageViewBinding
import au.com.userdetailsampletest.di.ViewModelProviderFactory
import au.com.userdetailsampletest.models.viewmodels.AlbumListViewModel
import au.com.userdetailsampletest.models.viewmodels.ViewImageViewModel
import au.com.userdetailsampletest.util.EventObserver
import au.com.userdetailsampletest.util.Resource
import au.com.userdetailsampletest.util.setImageUrl
import com.google.android.material.bottomsheet.BottomSheetBehavior
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.bottom_sheet_image_view.*
import javax.inject.Inject

class AlbumListFragment : DaggerFragment() {

    @Inject lateinit var viewModelProviderFactory : ViewModelProviderFactory
    private lateinit var albumListFragmentBinding: AlbumListFragmentBinding
    private lateinit var viewModel : AlbumListViewModel
    var userId : Int?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelProviderFactory).get(AlbumListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        albumListFragmentBinding = AlbumListFragmentBinding.inflate(inflater, container, false).apply {
            albumListViewModel = viewModel
        }

        return albumListFragmentBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupRecyclerView()
        hideBottomSheet()
    }

    private fun hideBottomSheet() {
        BottomSheetBehavior.from(layoutBottomSheet).setPeekHeight(0)
        BottomSheetBehavior.from(layoutBottomSheet).state = BottomSheetBehavior.STATE_HIDDEN
    }

    private fun showBottomSheet() {
        BottomSheetBehavior.from(layoutBottomSheet).state = BottomSheetBehavior.STATE_EXPANDED
    }

    fun setUserId(id : Int) {
        userId = id
        userId?.let {
            viewModel.loadAlbumsForUser(it)
            setupObservers()
        }
    }

    private fun setupRecyclerView() {
        val vm = albumListFragmentBinding.albumListViewModel
        vm?.let {
            albumListFragmentBinding.rcyAlbums.adapter = AlbumAdapter(it)
        } ?: kotlin.run {
            //Else say something mate!
        }
    }

    private fun setupObservers() {

        viewModel._albums?.observe(viewLifecycleOwner, Observer {

            when(it.status) {

                Resource.Status.SUCCESS -> {
                    if (!it.data.isNullOrEmpty())
                        it.data.let {
                            viewModel.albums = it
                            albumListFragmentBinding.rcyAlbums.adapter?.notifyDataSetChanged()
                        }
                }

                Resource.Status.ERROR -> {
                    //We clear the data
                }

                Resource.Status.LOADING -> {
                    //We make sure there is loading bar
                }
            }
        })

        viewModel.openImageEvent.observe(this , EventObserver {
            openBottomSheetImageView(it)
        })
    }

    private fun openBottomSheetImageView(id: Int) {
        showBottomSheet()
        val album = viewModel.getAlbumWithId(id)
        title.setText(album?.title)
        setImageUrl(image, album?.url)
    }

}