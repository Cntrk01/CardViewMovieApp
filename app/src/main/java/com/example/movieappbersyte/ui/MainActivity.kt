package com.example.movieappbersyte.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieappbersyte.adapter.TvShowAdapter
import com.example.movieappbersyte.adapter.UpComingAdapter
import com.example.movieappbersyte.databinding.ActivityMainBinding
import com.example.movieappbersyte.viewmodel.TvShowViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var  binding:ActivityMainBinding
    private val viewModel:TvShowViewModel by viewModels()
    private lateinit var tvShowAdapter: TvShowAdapter
    private lateinit var upComingAdapter: UpComingAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        setUpRv()
    }
    private fun setUpRv(){
        tvShowAdapter= TvShowAdapter()
        upComingAdapter= UpComingAdapter()
        binding.recyclerView.apply {
            adapter=tvShowAdapter
            layoutManager=LinearLayoutManager(this@MainActivity,LinearLayoutManager.HORIZONTAL,false)
            setHasFixedSize(true)
        }
        binding.rvEpisodes.apply {
            adapter=tvShowAdapter
            layoutManager=LinearLayoutManager(this@MainActivity,LinearLayoutManager.HORIZONTAL,false)
            setHasFixedSize(true)
        }
        binding.rvRecentlyAdded.apply {
            adapter=tvShowAdapter
            layoutManager=LinearLayoutManager(this@MainActivity,LinearLayoutManager.HORIZONTAL,false)
            setHasFixedSize(true)
        }

        viewModel._responseTvShow.observe(this, Observer {
                tvShowAdapter.tvShows=it
        })



    }

}