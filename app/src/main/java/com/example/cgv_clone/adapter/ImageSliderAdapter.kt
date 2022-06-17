package com.example.cgv_clone.adapter

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cgv_clone.databinding.ItemSliderBinding
import com.example.cgv_clone.fragment.HomeFragment


class ImageSliderAdapter(
    private val context: Context,
    private val sliderImage: Array<Int>,
) :
    RecyclerView.Adapter<ImageSliderAdapter.MyViewHolder>() {

    var handler = Handler(Looper.getMainLooper())

    inner class MyViewHolder(val binding: ItemSliderBinding) :
        RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemSliderBinding.inflate(
            LayoutInflater.from(context), parent, false
        )
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        Glide.with(context).load(sliderImage[position]).into(holder.binding.imageSlider)
    }

    override fun getItemCount(): Int {
        return sliderImage.size
    }
}