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

    private val _openAlbumEvent = MutableLiveData<Event<Int>>()
    val openAlbumEvent: LiveData<Event<Int>> = _openAlbumEvent

    fun openAlbum(id: Int) {
        _openAlbumEvent.value = Event(id)
    }
}