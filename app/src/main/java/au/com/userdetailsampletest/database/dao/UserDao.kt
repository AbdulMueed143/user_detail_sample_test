package au.com.userdetailsampletest.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import au.com.userdetailsampletest.models.entitymodels.User

@Dao
interface UserDao : BaseDao<User> {

    @Query( "SELECT * FROM "+User.TABLE_NAME)
    fun getUsers() : LiveData<List<User>>
}