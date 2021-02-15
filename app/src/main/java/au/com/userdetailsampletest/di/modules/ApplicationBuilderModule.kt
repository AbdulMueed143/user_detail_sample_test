package au.com.userdetailsampletest.di.modules

import android.app.Application
import au.com.userdetailsampletest.network.UserInformationService
import au.com.userdetailsampletest.datasources.remote.UserRemoteDataSource
import au.com.userdetailsampletest.util.Constants
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApplicationBuilderModule {

    @Singleton
    @Provides
    fun provideGlideInstance(application: Application, requestOptions: RequestOptions) : RequestManager {
        return Glide.with(application).setDefaultRequestOptions(requestOptions)
    }


    @Singleton
    @Provides
    fun providesRetrofitInstance(application: Application) : Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    //User Information Service
    @Singleton
    @Provides
    fun providesUserService(retrofit: Retrofit) : UserInformationService = retrofit.create(UserInformationService::class.java)

    @Singleton
    @Provides
    fun providesUserRemoteDataSource(userInformationService: UserInformationService) = UserRemoteDataSource(userInformationService)


}