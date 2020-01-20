package com.oguzhanorhan.moviesapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.GsonBuilder
import com.oguzhanorhan.moviesapp.ClientUtils.MovieResponse
import com.oguzhanorhan.moviesapp.ClientUtils.MoviesService
import com.oguzhanorhan.moviesapp.Models.MovieDTO
import com.oguzhanorhan.moviesapp.Utils.Constants
import com.squareup.picasso.Picasso
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var moviesList : RecyclerView
    private lateinit var movieAdapter: MoviesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        movieAdapter = MoviesAdapter()
        initUI()
        getMovies()
    }

    private fun initUI() {
        moviesList = findViewById(R.id.movies_list)
        moviesList.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        moviesList.adapter = movieAdapter
    }

    @SuppressLint("CheckResult")
    fun getMovies() {
        val retrofitClient : Retrofit = Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        val moviesService = retrofitClient.create(MoviesService::class.java)

         moviesService.getMovies()
            .subscribeOn(Schedulers.io())
            .unsubscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                //success
                val response: MovieResponse = it
                movieAdapter.setMovies(response.data)

            }, {
                //error
                Toast.makeText(this@MainActivity, it.message, Toast.LENGTH_LONG).show()
            })
    }


    inner class MoviesAdapter : RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

        private val movies: MutableList<MovieDTO> = mutableListOf()

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
            return MovieViewHolder(layoutInflater.inflate(R.layout.movie_item_layout, parent, false))
        }

        override fun getItemCount(): Int {
            return movies.size
        }

        override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
            holder.bindModel(movies[position])
        }

        fun setMovies(data: List<MovieDTO>) {
            movies.addAll(data)
            notifyDataSetChanged()
        }

        inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            val movieTitleTxt : TextView = itemView.findViewById(R.id.movieTitle)
            val movieGenreTxt : TextView = itemView.findViewById(R.id.movieGenre)
            val movieYearTxt : TextView = itemView.findViewById(R.id.movieYear)
            val movieAvatarImage : ImageView = itemView.findViewById(R.id.movieAvatar)

            fun bindModel(movie: MovieDTO) {
                movieTitleTxt.text = movie.title
                movieGenreTxt.text = movie.genre
                movieYearTxt.text = movie.year
                Picasso.get().load(movie.poster).into(movieAvatarImage)
            }
        }
    }
}
