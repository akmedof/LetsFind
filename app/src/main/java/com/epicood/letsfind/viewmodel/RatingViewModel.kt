package com.epicood.letsfind.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.epicood.letsfind.model.Rating
import com.google.firebase.database.*

class RatingViewModel: ViewModel() {

    val ratings = MutableLiveData<List<Rating>>()

    fun getData(){
        var mDatabase = FirebaseDatabase.getInstance().reference
        var getData = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val list = arrayListOf<Rating>()
                for (i in snapshot.children) {
                    var usename = i.child("username").getValue()
                    var point = i.child("point").getValue()
                    var androidID = i.key.toString()
                    Log.i("andID", androidID)
                    list.add(Rating(androidID, usename.toString(), point.toString()))
                }
                ratings.value = list
            }
            override fun onCancelled(error: DatabaseError) {
            }
        }
        mDatabase.addValueEventListener(getData)
    }





}