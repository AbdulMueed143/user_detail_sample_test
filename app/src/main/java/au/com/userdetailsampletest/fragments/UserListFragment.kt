package au.com.userdetailsampletest.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import au.com.userdetailsampletest.ActivityAlbum
import au.com.userdetailsampletest.adapters.UsersAdapter
import au.com.userdetailsampletest.databinding.UsersListFragmentBinding
import au.com.userdetailsampletest.di.ViewModelProviderFactory
import au.com.userdetailsampletest.models.entitymodels.Album
import au.com.userdetailsampletest.models.viewmodels.UserListViewModel
import au.com.userdetailsampletest.util.EventObserver
import au.com.userdetailsampletest.util.Resource
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class UserListFragment : DaggerFragment() {

    @Inject lateinit var viewModelProviderFactory : ViewModelProviderFactory
    private lateinit var userListFragmentBinding: UsersListFragmentBinding
    private lateinit var viewModel : UserListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelProviderFactory).get(UserListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        userListFragmentBinding = UsersListFragmentBinding.inflate(inflater, container, false).apply {
            usersListViewModel = viewModel
        }

        return userListFragmentBinding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        userListFragmentBinding.lifecycleOwner = this.viewLifecycleOwner
        setupRecyclerView()
        setupObservers()
    }


    private fun setupRecyclerView() {
        val vm = userListFragmentBinding.usersListViewModel
        vm?.let {
            userListFragmentBinding.rcyUsers.adapter = UsersAdapter(it)
        } ?: kotlin.run {
            //Else say something mate!
        }
    }

    private fun setupObservers() {

        viewModel._users.observe(viewLifecycleOwner, Observer {

            when(it.status) {

                Resource.Status.SUCCESS -> {
                    //We update the data

//                    viewModel.isLoading = false
                    if (!it.data.isNullOrEmpty())
                        it.data.let {
                            viewModel.users = it
                            userListFragmentBinding.rcyUsers.adapter?.notifyDataSetChanged()
                        }
                }

                Resource.Status.ERROR -> {
                    //We clear the data
//                    viewModel.isLoading = false
                }

                Resource.Status.LOADING -> {
                    //We make sure there is loading bar
//                    viewModel.isLoading = true
                }
            }
        })


        viewModel.openAlbumEvent.observe(this, EventObserver {
            openAlbum(it)
        })

    }

    private fun openAlbum(id: Int) {
        val intent = Intent(context, ActivityAlbum::class.java)
        intent.putExtra(Album.COL_ALBUM_ID, id)
        startActivity(intent)
    }

}