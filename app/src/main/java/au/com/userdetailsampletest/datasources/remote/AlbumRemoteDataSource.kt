package au.com.userdetailsampletest.datasources.remote

import au.com.userdetailsampletest.datasources.BaseDataSource
import au.com.userdetailsampletest.network.UserInformationService

class AlbumRemoteDataSource(private val userInformationService: UserInformationService) : BaseDataSource() {

    suspend fun getAlbums() = getResult {
        userInformationService.getAlbums()
    }
}