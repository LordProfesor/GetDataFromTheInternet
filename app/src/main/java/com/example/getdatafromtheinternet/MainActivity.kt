package com.example.getdatafromtheinternet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
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
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://api.themoviedb.org/3/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                val service = retrofit.create(TheMovieDbService::class.java)
                val popularMovies = service.listPopularMovies(getString(R.string.api_key))
                val body = popularMovies.execute().body()
                if (body != null) {
                    Log.i("MainActivity: ", "Movie count: ${body.results.size}")
                }
            }
        }
    }
}