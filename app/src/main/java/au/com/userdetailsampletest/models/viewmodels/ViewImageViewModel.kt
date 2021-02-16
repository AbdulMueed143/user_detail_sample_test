package au.com.userdetailsampletest.models.viewmodels

import androidx.lifecycle.ViewModel
import au.com.userdetailsampletest.models.entitymodels.Album
import javax.inject.Inject

class ViewImageViewModel @Inject constructor()  : ViewModel() {
    var album : Album? = null
}