package global.oguzhanorhan.mvvmsample.data.repositories

import global.oguzhanorhan.mvvmsample.data.db.AppDatabase
import global.oguzhanorhan.mvvmsample.data.db.entities.User
import global.oguzhanorhan.mvvmsample.data.network.MyAPI
import global.oguzhanorhan.mvvmsample.data.network.SafeApiRequest
import global.oguzhanorhan.mvvmsample.data.network.responses.AuthResponse


class UserRepository(
    private val myAPI: MyAPI,
    private val db: AppDatabase
) : SafeApiRequest(){

    suspend fun userLogin(email: String, password: String): AuthResponse{
        return apiRequest { myAPI.userLogin(email, password) }
    }

    suspend fun saveUserToDb(user: User) = db.getUserDao().upsert(user)

    fun getUser() = db.getUserDao().getUser()

    suspend fun userSignup(
        name: String,
        email: String,
        password: String
    ) : AuthResponse {
        return apiRequest{ myAPI.userSignup(name, email, password)}
    }
}