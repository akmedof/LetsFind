package com.epicood.letsfind.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.epicood.letsfind.model.Rating
import com.google.firebase.database.*

class RatingViewModel: ViewModel() {

    private lateinit var mDatabase : DatabaseReference
    val ratings = MutableLiveData<List<Rating>>()

    fun getData(){
        mDatabase = FirebaseDatabase.getInstance().reference
        var getData = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val list = arrayListOf<Rating>()
                for (i in snapshot.children) {
                    var usename = i.child("username").getValue()
                    var point = i.child("point").getValue()
                    var androidID = i.child("androidID").getValue()
//                    Log.i("andID", androidID)
                    list.add(Rating(androidID.toString(), usename.toString(), point.toString()))
                }
                ratings.value = list
            }
            override fun onCancelled(error: DatabaseError) {
            }
        }
        mDatabase.addValueEventListener(getData)
    }

    fun androidIDCheck(androidID: String): Boolean{
        var check = false
        mDatabase = FirebaseDatabase.getInstance().reference
        var getData = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val list = arrayListOf<Rating>()
                for (i in snapshot.children) {
                    check = i.key.toString() == androidID
                }
                ratings.value = list
            }
            override fun onCancelled(error: DatabaseError) {
            }
        }
//        mDatabase.addValueEventListener(getData)
        return true
    }



}