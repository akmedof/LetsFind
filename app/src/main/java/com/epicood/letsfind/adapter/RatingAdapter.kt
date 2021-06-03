package com.epicood.letsfind.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.epicood.letsfind.databinding.RatingRowItemBinding
import com.epicood.letsfind.model.Rating
import com.epicood.letsfind.util.RatingDiffUtil

class RatingAdapter : RecyclerView.Adapter<RatingAdapter.RatingViewHolder>() {

    private var ratings = emptyList<Rating>()

    class RatingViewHolder(private var binding: RatingRowItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(rating: Rating){
            binding.rating = rating
            binding.executePendingBindings()
        }
        companion object{
            fun from(parent: ViewGroup): RatingViewHolder{
                val inflater = LayoutInflater.from(parent.context)
                val view = RatingRowItemBinding.inflate(inflater, parent, false)
                return RatingViewHolder(view)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RatingViewHolder {
        return RatingViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: RatingViewHolder, position: Int) {
        val rating = ratings[position]
        holder.bind(rating)
    }

    override fun getItemCount(): Int {
        return ratings.size
    }

    fun updateFavoriteList(newData: List<Rating>) {
        val topDiffUtil = RatingDiffUtil(ratings, newData)
        val diffUtilTop = DiffUtil.calculateDiff(topDiffUtil)
        ratings = newData
        diffUtilTop.dispatchUpdatesTo(this)
    }
}