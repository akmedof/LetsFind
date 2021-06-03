package com.epicood.letsfind.util

import androidx.recyclerview.widget.DiffUtil
import com.epicood.letsfind.model.Rating
class RatingDiffUtil(
    private val oldList : List<Rating>,
    private val newList : List<Rating>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] === newList[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] === newList[newItemPosition]
    }
}