package com.epicood.letsfind.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.epicood.letsfind.model.Rating
import com.google.firebase.database.*
import kotlinx.coroutines.launch

class RatingViewModel(application: Application) : BaseViewModel(application) {

    private lateinit var mDatabase : DatabaseReference
    val ratings = MutableLiveData<List<Rating>>()
    val androidIDList = MutableLiveData<List<String>>()
//    private val dao = QuizDatabase(getApplication()).quizDAO

//    fun insertRating(rating: Rating){
//        launch {
//            dao.insertRating(rating)
//        }
//    }
//
//    fun getData(){
//        launch {
//            val list: List<Rating> = dao.getAllRating()
//            ratings.value = list
//        }
//    }
//
//    fun deleteAll(){
//        launch {
//            dao.deleteAllRating()
//        }
//    }

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

    fun getAllAndroidID(){
        mDatabase = FirebaseDatabase.getInstance().reference
        var getData = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val list = arrayListOf<String>()
                for (i in snapshot.children) {
                    var androidID = i.child("androidID").getValue()
                    Log.i("andID", androidID.toString())
                    list.add(androidID.toString())
                }
                Log.i("ggg", list.size.toString())
                androidIDList.value = list
            }
            override fun onCancelled(error: DatabaseError) {
            }
        }
        mDatabase.addListenerForSingleValueEvent(getData)
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

    override fun onCleared() {
        super.onCleared()
        mDatabase.onDisconnect()
    }



}