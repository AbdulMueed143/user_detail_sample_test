package au.com.userdetailsampletest.models.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import au.com.userdetailsampletest.database.repositories.AlbumRepository
import au.com.userdetailsampletest.models.entitymodels.Album
import au.com.userdetailsampletest.util.Event
import au.com.userdetailsampletest.util.Resource
import javax.inject.Inject

class AlbumListViewModel @Inject constructor(private val albumRepository: AlbumRepository)  : ViewModel() {

    var _albums : LiveData<Resource<List<Album>>>? = null
    var albums : List<Album>? = null

    private val _openImageEvent = MutableLiveData<Event<Int>>()
    val openImageEvent: LiveData<Event<Int>> = _openImageEvent

    fun loadAlbumsForUser(userId: Int) {
        _albums = albumRepository.getAlbums(userId)
    }

    fun openImage(id: Int) {
        _openImageEvent.value = Event(id)
    }

    fun getAlbumWithId(id : Int) : Album? {
        albums?.forEach {
            if (it.id == id)
                return it
        }

        return null
    }

}