package com.example.movieapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import coil.load
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var titleInput = findViewById<EditText>(R.id.titleInput)
        var submitButton = findViewById<Button>(R.id.submitButton)
        var titleText = findViewById<TextView>(R.id.titleText)
        var yearReleased = findViewById<TextView>(R.id.yearReleased)
        var poster = findViewById<ImageView>(R.id.moviePoster)


        submitButton.setOnClickListener(){
            var currTitle = titleInput.text

            val call = api.getMovie(currTitle)
            call.enqueue(object: Callback<MovieResponse> {
                override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                    if (response.isSuccessful) {
                        val movieResponse = response.body()
                        if (movieResponse != null) {
                            poster.load("${movieResponse.Poster}")
                            titleText.text = "Title: ${movieResponse.Title}"
                            yearReleased.text = "Year Released: ${movieResponse.Year}"

                        } else {
                            // Handle null response
                        }
                    } else {
                        // Handle unsuccessful response
                    }
                }

                override fun onFailure(call: Call<MovieResponse>?, t: Throwable?) {

                }
            })
        }
    }
}








