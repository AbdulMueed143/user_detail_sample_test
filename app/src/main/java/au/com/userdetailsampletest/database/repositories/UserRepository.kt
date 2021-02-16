package au.com.userdetailsampletest.database.repositories

import au.com.userdetailsampletest.database.dao.UserDao
import au.com.userdetailsampletest.datasources.remote.UserRemoteDataSource
import au.com.userdetailsampletest.models.entitymodels.User
import au.com.userdetailsampletest.util.Resource
import au.com.userdetailsampletest.util.performGetOperation
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Dao Classes
 * Web services
 * Or Caching of data would be handled here
 * and related objects will be injected to the repository
 * */

class UserRepository @Inject constructor(
    private val remoteDataSource : UserRemoteDataSource,
    private val localDataSource: UserDao
)  {

    fun getAllUsers() = performGetOperation(
        databaseQuery = {
            localDataSource.getUsers()
        },
        networkCall = {
            remoteDataSource.getUsers()
        },
        saveCallResult = {
            localDataSource.insertAll(it).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe()
        }
    )
}