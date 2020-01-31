package global.oguzhanorhan.mvvmsample.data.db

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import global.oguzhanorhan.mvvmsample.data.db.entities.UserDao

abstract class AppDatabase : RoomDatabase() {

    abstract fun getUserDao() : UserDao

    companion object {

        @Volatile //@Volatile annotation means this variable immediately visible to all the threads
        private var instance: AppDatabase?= null
        private var LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "MyDatabase.db")
                .build()
    }
}