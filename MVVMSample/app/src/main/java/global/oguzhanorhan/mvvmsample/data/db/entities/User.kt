package global.oguzhanorhan.mvvmsample.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

const val CURRENT_USER_ID: Int = 0

@Entity
data class User(
    var id: Int? = null,
    var name: String? = null,
    var email: String? = null,
    var password: String? = null,
    var email_verified_on: String? = null,
    var created_on: String? = null,
    var updated_on: String? = null
) {
    @PrimaryKey(autoGenerate = false) //only one user in database, auto generated primary key option disabled
    var uid: Int = CURRENT_USER_ID
}