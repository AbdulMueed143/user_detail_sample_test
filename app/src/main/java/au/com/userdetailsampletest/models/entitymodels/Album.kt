package au.com.userdetailsampletest.models.entitymodels

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


/**
 * Serialize name is the name json parser will use when parsing objects from json response
 * ColumInfo is the name that table will use
 * We can use Ignore annotations to ignore if any of the variable needs to be not used in any of these
 * but since this is simple use case this works
 *
 * There should be foreign key relationship but lets not add it for avoiding complexity and saving time for the test
 * */

@Entity(tableName = Album.TABLE_NAME)
data class Album(
    @ColumnInfo(name = COL_ALBUM_ID)
    @SerializedName(COL_ALBUM_ID)
    val albumId : Int,
    
    @PrimaryKey
    @ColumnInfo(name = COL_ID)
    @SerializedName(COL_ID)
    val id : Int,

    @ColumnInfo(name = COL_TITLE)
    @SerializedName(COL_TITLE)
    val title : String,

    @ColumnInfo(name = COL_URL)
    @SerializedName(COL_URL)
    val url : String,

    @ColumnInfo(name = COL_THUMBNAILURL)
    @SerializedName(COL_THUMBNAILURL)
    val thumbNailUrl : String,
) : Cloneable {

    companion object {
        const val TABLE_NAME = "album"

        const val COL_ALBUM_ID = "albumId"
        const val COL_ID = "id"
        const val COL_TITLE = "title"
        const val COL_URL = "url"
        const val COL_THUMBNAILURL = "thumbnailUrl"
    }
}