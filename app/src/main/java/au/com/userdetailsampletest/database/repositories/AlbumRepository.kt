package au.com.userdetailsampletest.database.repositories

import android.util.Log
import au.com.userdetailsampletest.database.dao.AlbumDao
import au.com.userdetailsampletest.datasources.remote.AlbumRemoteDataSource
import au.com.userdetailsampletest.util.performGetOperation
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AlbumRepository @Inject constructor(private val remoteDataSource: AlbumRemoteDataSource,
                                          private val localDataSource: AlbumDao
) {
    fun getAlbums(userId: Int) = performGetOperation(
        databaseQuery = {
            localDataSource.getAlbums(userId)
        },
        networkCall = {
            remoteDataSource.getAlbums()
        },
        saveCallResult = {
            localDataSource.insertAll(it).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe({

                }, {
                    Log.e("Qeury Error", "Error MEssage")
                })
        }
    )
}