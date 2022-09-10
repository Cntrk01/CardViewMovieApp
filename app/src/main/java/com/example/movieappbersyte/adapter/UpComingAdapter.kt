package com.example.movieappbersyte.adapter

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.movieappbersyte.databinding.RecyclerRowBinding
import com.example.movieappbersyte.models.TvShowItem
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import coil.load
import com.example.movieappbersyte.ui.DetailActivity


class UpComingAdapter(private val ispopular:Boolean=true) : RecyclerView.Adapter<UpComingAdapter.MyViewHolder>() {
    inner class MyViewHolder(val binding: RecyclerRowBinding) :
        RecyclerView.ViewHolder(binding.root)

    private val diffcalback = object : DiffUtil.ItemCallback<TvShowItem>() {
        override fun areItemsTheSame(oldItem: TvShowItem, newItem: TvShowItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: TvShowItem, newItem: TvShowItem): Boolean {
            return newItem == oldItem
        }

    }

    private val differ = AsyncListDiffer(this, diffcalback)
    var upComingShows: List<TvShowItem>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            RecyclerRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentTvShow=upComingShows[position]
        holder.binding.apply {
            textView.text=currentTvShow.name

            imageView.load(currentTvShow.image!!.original){
                crossfade(true)
                crossfade(1000)
            }
        }

        holder.itemView.setOnClickListener {
            val contextA= holder.itemView.context
            val intent=Intent(contextA, DetailActivity::class.java)
            intent.putExtra("name",currentTvShow.name)
            intent.putExtra("image",currentTvShow.image!!.original)
            intent.putExtra("rating",currentTvShow.rating!!.average)
            intent.putExtra("language",currentTvShow.language)
            intent.putExtra("type",currentTvShow.type)
            intent.putExtra("summary",currentTvShow.summary)
            contextA.startActivity(intent)
//            Log.e("datacome",currentTvShow.rating!!.average.toString())
        }

    }

    override fun getItemCount(): Int {
        if(ispopular){
            return 4
        }else{
            return upComingShows.size
        }
    }


}