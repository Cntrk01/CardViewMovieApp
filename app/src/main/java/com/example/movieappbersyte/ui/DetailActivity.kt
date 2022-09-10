package com.example.movieappbersyte.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import coil.load
import com.example.movieappbersyte.databinding.ActivityDetailBinding
import com.example.movieappbersyte.databinding.ActivityMainBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        var name=intent.getStringExtra("name")
        var image=intent.getStringExtra("image")
        var rating=intent.getDoubleExtra("rating",0.0)
        var language=intent.getStringExtra("language")
        var type=intent.getStringExtra("type")
        var summary=intent.getStringExtra("summary")

       binding.filmImage.load(image){
           crossfade(true)
           crossfade(1000)
       }
        binding.filmName.text = "${"Name:" +name}"
        binding.filmLanguage.text="${"Language:" +language}"
        binding.filmRating.text ="${"Rating:" +rating}"
        binding.filmType.text="${"Type:" +type}"
        binding.filmSummary.text="${"Summary:" +summary}"
    }
}