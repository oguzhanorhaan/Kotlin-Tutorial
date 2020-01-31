package global.oguzhanorhan.mvvmsample.data.db.entities

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao //data access object
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE) // replaces when conflict occurred and updates with new value
    suspend fun upsert(user: User) : Long

    @Query("SELECT * FROM user WHERE uid=$CURRENT_USER_ID")
    fun getUser(): LiveData<User>
 }