package au.com.userdetailsampletest.database.dao

import androidx.room.*
import io.reactivex.Completable
import org.jetbrains.annotations.NotNull

@Dao
interface BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @NotNull
    fun insert(item : T) : Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @NotNull
    fun insertAll(itemList : List<T>) : Completable

    @Delete
    fun delete(item : T) : Completable

    @Delete
    fun deleteAll(item : MutableList<T>) : Completable

    @Update
    fun update(item : T) : Completable

    @Update
    fun updateAll(itemList : List<T>) : Completable

}