package au.com.userdetailsampletest

import au.com.userdetailsampletest.di.component.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

open class BaseApp : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        //Changing to dagger appplication
        return DaggerApplicationComponent.builder().application(this).build()
    }

    override fun onCreate() {
        super.onCreate()
        //Here we also initialize google places sdk or facebook sdk or others sometimes
    }
}
