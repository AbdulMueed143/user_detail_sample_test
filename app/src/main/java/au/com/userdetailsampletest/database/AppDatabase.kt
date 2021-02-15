package au.com.userdetailsampletest.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import au.com.userdetailsampletest.database.dao.UserDao
import au.com.userdetailsampletest.models.entitymodels.Album
import au.com.userdetailsampletest.models.entitymodels.User
import au.com.userdetailsampletest.util.Constants

@Database(entities = [User::class, Album::class], version = Constants.DATABASE_VERSION, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao() : UserDao

    companion object {

        private var instance : AppDatabase? = null

        fun getInstance(context: Context) : AppDatabase {

            if (instance == null) {
                synchronized(AppDatabase::class) {
                    instance = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, Constants.DATABASE_NAME)
                        .fallbackToDestructiveMigration().build()
                }
            }

            return instance!!
        }
    }
}