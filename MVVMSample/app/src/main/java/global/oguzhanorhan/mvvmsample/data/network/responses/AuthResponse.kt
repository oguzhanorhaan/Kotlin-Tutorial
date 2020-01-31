package global.oguzhanorhan.mvvmsample.data.network.responses

import global.oguzhanorhan.mvvmsample.data.db.entities.User

data class AuthResponse (
    val isSuccess: Boolean?,
    val message: String?,
    val user: User?
)