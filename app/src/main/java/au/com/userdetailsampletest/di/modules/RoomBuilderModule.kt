package au.com.userdetailsampletest.di.modules

import android.app.Application
import au.com.userdetailsampletest.database.AppDatabase
import au.com.userdetailsampletest.database.dao.AlbumDao
import au.com.userdetailsampletest.database.dao.UserDao
import au.com.userdetailsampletest.database.repositories.AlbumRepository
import au.com.userdetailsampletest.database.repositories.UserRepository
import au.com.userdetailsampletest.datasources.remote.AlbumRemoteDataSource
import au.com.userdetailsampletest.datasources.remote.UserRemoteDataSource
import au.com.userdetailsampletest.network.UserInformationService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class RoomBuilderModule {

    @Singleton
    @Provides
    fun providesAppDatabase(application: Application) : AppDatabase {
        return AppDatabase.getInstance(application.applicationContext)
    }

    @Singleton
    @Provides
    fun providesUserDao(appDatabase: AppDatabase) : UserDao {
        return appDatabase.userDao()
    }

    @Singleton
    @Provides
    fun providesAlbumDao(appDatabase: AppDatabase) : AlbumDao {
        return appDatabase.albumDao()
    }

    @Singleton
    @Provides
    fun providesUserRepository(userDao: UserDao, userRemoteDataSource: UserRemoteDataSource) : UserRepository {
        return UserRepository(userRemoteDataSource, userDao)
    }

    @Singleton
    @Provides
    fun providesAlbumRepository(albumDao: AlbumDao, albumRemoteDataSource: AlbumRemoteDataSource) : AlbumRepository {
        return AlbumRepository(albumRemoteDataSource, albumDao)
    }

}