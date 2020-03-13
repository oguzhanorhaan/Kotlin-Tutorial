package com.oguzhanorhan.dagger2codingwithmitchtutorial.network.auth;

import com.oguzhanorhan.dagger2codingwithmitchtutorial.model.User;

import io.reactivex.Flowable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AuthApi {

    // /users/id
    @GET("users/{id}")
    Flowable<User> getUser(
            @Path("id") int id
    );
}
