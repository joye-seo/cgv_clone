package com.example.cgv_clone.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cgv_clone.databinding.ItemMovieChartBinding
import com.example.cgv_clone.fragment.Movies


class MovieAdapter(private val context: Context, private var MoviesArrayList: ArrayList<Movies>) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    var dataList: ArrayList<Movies> = MoviesArrayList

    class ViewHolder(val binding: ItemMovieChartBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: Movies) {
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding = ItemMovieChartBinding.inflate(
            LayoutInflater.from(context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvName.text = dataList[position].name
        val url = "https://image.tmdb.org/t/p/w500" + dataList[position].img
        Glide.with(context)
            .load(url)
            .into(holder.binding.ivPoster)

        holder.binding.tvPopular.text = dataList[position].popular
        holder.binding.tvRatio.text = dataList[position].ratio
        holder.binding.tvEgg.text = dataList[position].egg_per
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

}