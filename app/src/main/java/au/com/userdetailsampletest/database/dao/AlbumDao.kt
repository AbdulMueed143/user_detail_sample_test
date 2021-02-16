package au.com.userdetailsampletest.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import au.com.userdetailsampletest.models.entitymodels.Album

@Dao
interface AlbumDao : BaseDao<Album> {

    @Query( "SELECT * FROM "+ Album.TABLE_NAME +" WHERE "+Album.COL_ALBUM_ID+"=:userId")
    fun getAlbums(userId: Int) : LiveData<List<Album>>

}