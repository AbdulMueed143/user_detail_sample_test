package au.com.userdetailsampletest.di.modules

import au.com.userdetailsampletest.fragments.AlbumListFragment
import au.com.userdetailsampletest.fragments.UserListFragment
import au.com.userdetailsampletest.fragments.ViewImageFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilderModule {

    @ContributesAndroidInjector
    abstract fun contributesAlbumListFragment() : AlbumListFragment

    @ContributesAndroidInjector
    abstract fun contributesUserListFragment() : UserListFragment

    @ContributesAndroidInjector
    abstract fun contributesViewImageFRagment() : ViewImageFragment

}