package au.com.userdetailsampletest.di.modules

import au.com.userdetailsampletest.ActivityAlbum
import au.com.userdetailsampletest.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector
    abstract fun contributesMainActivity() : MainActivity

    @ContributesAndroidInjector
    abstract fun contributesAlbumActivity() : ActivityAlbum
}