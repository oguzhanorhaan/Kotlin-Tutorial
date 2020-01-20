package com.oguzhanorhan.moviesapp.ClientUtils


import io.reactivex.Observable
import retrofit2.http.GET

interface MoviesService {
    @GET("/filippella/Sample-API-Files/master/json/movies-api.json")
    fun getMovies() : Observable<MovieResponse>
}