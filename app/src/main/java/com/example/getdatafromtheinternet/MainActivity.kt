package com.example.getdatafromtheinternet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.getdatafromtheinternet.model.MovieDbClient
import com.example.getdatafromtheinternet.model.TheMovieDbService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import kotlin.concurrent.thread


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            thread {
                val popularMovies = MovieDbClient.service.listPopularMovies(getString(R.string.api_key))
                val body = popularMovies.execute().body()
                if (body != null) {
                    Log.i("MainActivity: ", "Movie count: ${body.results.size}")
                }
            }
        }
    }
}