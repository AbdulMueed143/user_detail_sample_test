package au.com.userdetailsampletest.datasources.remote

import au.com.userdetailsampletest.datasources.BaseDataSource
import au.com.userdetailsampletest.network.UserInformationService

class UserRemoteDataSource(private val userInformationService: UserInformationService) :
    BaseDataSource {

    suspend fun getUsers() = getResult {
        userInformationService.getAllUsers()
    }
}