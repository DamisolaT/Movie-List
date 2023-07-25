package com.example.movielist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movielist.models.Movie
import com.example.movielist.models.MovieResponse
import com.example.movielist.databinding.ActivityMainBinding
import com.example.movielist.Service.MovieApiInterface
import com.example.movielist.Service.MovieApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class MainActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        
        binding.rvMovies.layoutManager= LinearLayoutManager(this)
        binding.rvMovies.setHasFixedSize(true)
        getMovieData { movies: List<Movie> ->
            binding.rvMovies.adapter= MovieAdapter(applicationContext,movies)
        }

    }

    private  fun getMovieData(callback:(List<Movie>) ->Unit){
        val apiService = MovieApiService.getInstance().create(MovieApiInterface::class.java)
        apiService.getMovieList().enqueue(object :Callback<MovieResponse>{
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                return callback(response.body()!!.movies)
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {

            }

        })

    }

    }


