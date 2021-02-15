package au.com.userdetailsampletest.network

import au.com.userdetailsampletest.models.entitymodels.Album
import au.com.userdetailsampletest.models.entitymodels.User
import retrofit2.Response
import retrofit2.http.GET

interface UserInformationService {

    @GET("users")
    suspend fun getAllUsers() : Response<List<User>>

    @GET
    suspend fun getAlbums() : Response<List<Album>>

}