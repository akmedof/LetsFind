package com.epicood.letsfind.viewmodel

import android.app.Application
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.epicood.letsfind.getAndroidID
import com.epicood.letsfind.model.Rating
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_result.*
import kotlinx.coroutines.launch

class RatingViewModel(application: Application) : BaseViewModel(application) {

    private lateinit var mDatabase : DatabaseReference
    val ratings = MutableLiveData<List<Rating>>()
    val androidIDList = MutableLiveData<List<String>>()


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

    fun updatePointByAndroidID(androidID: String, point: String, context: Context){
        mDatabase = FirebaseDatabase.getInstance().reference
        val quizP = mapOf<String, String>(
            "point" to point
        )

        mDatabase.child(androidID).updateChildren(quizP).addOnSuccessListener {
            Toast.makeText(context, "Successful Update", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener {
            Toast.makeText(context, "Failed to Update", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCleared() {
        super.onCleared()
        mDatabase.onDisconnect()
    }



}