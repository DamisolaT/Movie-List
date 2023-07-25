package com.example.movielist.Service

import com.example.movielist.models.MovieResponse
import retrofit2.Call
import retrofit2.http.GET

interface MovieApiInterface {
    @GET("/3/movie/popular?api_key=230c9ea7bc88c3bc90f267fc39180809")
    fun getMovieList(): Call<MovieResponse>
}