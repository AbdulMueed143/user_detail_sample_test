package au.com.userdetailsampletest.models.entitymodels

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Serialize name is the name json parser will use when parsing objects from json response
 * ColumInfo is the name that table will use
 * We can use Ignore annotations to ignore if any of the variable needs to be not used in any of these
 * but since this is simple use case this works
 * */

@Entity(tableName = User.TABLE_NAME)
data class User(
    @PrimaryKey
    @ColumnInfo(name = COL_ID)
    @SerializedName(COL_ID)
    val id: Int,

    @ColumnInfo(name = COL_NAME)
    @SerializedName(COL_NAME)
    val name: String,

    @ColumnInfo(name = COL_EMAIL)
    @SerializedName(COL_EMAIL)
    val email: String,

    @ColumnInfo(name = COL_PHONE)
    @SerializedName(COL_PHONE)
    val phone: String,

) : Cloneable {

    @Ignore
    var idAsString : String = ""
        get() {
            return id.toString()
        }

    companion object {
        const val TABLE_NAME = "user"

        const val COL_ID = "id"
        const val COL_NAME = "name"
        const val COL_EMAIL = "email"
        const val COL_PHONE = "phone"
    }
}