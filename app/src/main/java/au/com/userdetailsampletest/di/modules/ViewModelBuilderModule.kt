package au.com.userdetailsampletest.di.modules

import androidx.lifecycle.ViewModel
import au.com.userdetailsampletest.di.annotations.ViewModelKey
import au.com.userdetailsampletest.models.viewmodels.AlbumListViewModel
import au.com.userdetailsampletest.models.viewmodels.UserListViewModel
import au.com.userdetailsampletest.models.viewmodels.ViewImageViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelBuilderModule {

    @Binds
    @IntoMap
    @ViewModelKey(AlbumListViewModel::class)
    abstract fun bindAlbumListViewModel(albumListViewModel: AlbumListViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(UserListViewModel::class)
    abstract fun bindUserListViewModel(userListViewModel: UserListViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ViewImageViewModel::class)
    abstract fun bindViewImageViewModel(viewImageViewModel: ViewImageViewModel) : ViewModel

}