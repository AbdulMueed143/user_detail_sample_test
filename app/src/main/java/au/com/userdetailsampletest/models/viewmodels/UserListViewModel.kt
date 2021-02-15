package au.com.userdetailsampletest.models.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import au.com.userdetailsampletest.database.repositories.UserRepository
import au.com.userdetailsampletest.models.entitymodels.User
import au.com.userdetailsampletest.util.Event
import au.com.userdetailsampletest.util.Resource
import javax.inject.Inject

class UserListViewModel @Inject constructor(userRepository: UserRepository)  : ViewModel() {

    val _users : LiveData<Resource<List<User>>>  = userRepository.getAllUsers()
    var users : List<User>? = null

    private val _openAlbumEvent = MutableLiveData<Event<String>>()
    val openAlbumEvent: LiveData<Event<String>> = _openAlbumEvent

    fun openAlbum(id: Int) {
        //We should start that and open the
    }
}