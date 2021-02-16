package au.com.userdetailsampletest

import au.com.userdetailsampletest.datasources.fake.FakeRemoteUserInformationService
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnit

/**
 *
 * With Dagger this is bit tricky to test, we can either make fake classes or we add complex code
 * For now lets do it this way
 *
 * */

class ApiTest {

    val NUMBER_OF_USERS_API_RETURNS = 10
    val NUMBER_OF_PHOTOS_API_RETURNS = 5000

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
    }

    @get:Rule public var mokitoRule = MockitoJUnit.rule()

    @InjectMocks
    lateinit var service: FakeRemoteUserInformationService


    //Make sure the api call has been successful, and there are x users
    @Test
    fun test_UserAPICallSuccess()  {
        runBlocking {
            var userResult = service.getService().getAllUsers()
            assert(userResult.isSuccessful)
        }
    }

    @Test
    fun test_UserAPICallResultCount() {
        runBlocking {
            var userResult = service.getService().getAllUsers()
            assert(userResult.body()?.size == NUMBER_OF_USERS_API_RETURNS)
        }
    }

    @Test
    fun test_PhotosAPICallSuccess() {
        runBlocking {
            var userResult = service.getService().getAlbums()
            assert(userResult.isSuccessful)
        }
    }

    @Test
    fun test_PhotosAPICallResultCount() {
        runBlocking {
            var userResult = service.getService().getAlbums()
            assert(userResult.body()?.size == NUMBER_OF_PHOTOS_API_RETURNS)
        }
    }

}