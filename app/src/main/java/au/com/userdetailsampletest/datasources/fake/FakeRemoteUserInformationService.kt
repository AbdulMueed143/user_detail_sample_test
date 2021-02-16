package au.com.userdetailsampletest.datasources.fake

import au.com.userdetailsampletest.network.UserInformationService
import au.com.userdetailsampletest.util.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FakeRemoteUserInformationService {

    fun getService() : UserInformationService {
        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(UserInformationService::class.java)
    }
}