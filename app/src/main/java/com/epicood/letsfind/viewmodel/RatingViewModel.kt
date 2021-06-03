package com.epicood.letsfind.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.epicood.letsfind.model.Rating

class RatingViewModel: ViewModel() {

    val ratings = MutableLiveData<List<Rating>>()

    fun getData(){

        val r1 = Rating("Aslan", "45250")
        val r2 = Rating("Ferzin", "500000")
        val r3 = Rating("Resul", "78500")
        val r4 = Rating("Asif", "879296")
        val r5 = Rating("Malik", "1622")

        val list = arrayListOf<Rating>(r1, r2, r3, r4, r5)
        ratings.value = list

    }

}