package com.example.movielist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movielist.models.Movie

class MovieAdapter (
    private var context:Context,
    private val movies: List<Movie>

) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>(){

    class MovieViewHolder(view: View): RecyclerView.ViewHolder(view){
        var mtitle:TextView=itemView.findViewById(R.id.movie_title)
        var mdate:TextView=itemView.findViewById(R.id.movie_date_release)
        var mImage:ImageView=itemView.findViewById(R.id.movie_post)
//        fun bindMovie(movie : Movie){
//            itemView.movie_title.text = movie.title
//            itemView.movie_release_date.text = movie.release
//            Glide.with(itemView).load(IMAGE_BASE + movie.poster).into(itemView.movie_poster)
//        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.movie_layout, parent, false)
        )
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        // holder.bindMovie(movies.get(position))
        val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
        val currentMovie=movies[position]
        holder.mtitle.text=currentMovie.title
        holder.mdate.text=currentMovie.release

        Glide.with(context).load(IMAGE_BASE+ movies[position].poster).into(holder.mImage)
    }
}


