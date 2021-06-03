package com.epicood.letsfind

import android.annotation.SuppressLint
import android.content.Context
import android.provider.Settings
import android.util.Log
//
//fun main(){
//    val list = getRandom(4)
//    println("sss" + list)
//}

fun getRandom(count: Int): List<Int>{
    var c = count
    val list = arrayListOf<Int>()
    for (i in 0..c){
        val rand = (0..19).random()
        var t=0
        list.forEach {
            if (it == rand){
                t++
                c++
            }
        }
        if(t==0){
            list.add(rand)
        }
    }
    return list
}


fun getAndroidID(context: Context): String{
    @SuppressLint("HardwareIds")
    val androidID = Settings.Secure.getString(
        context?.getContentResolver(),
        Settings.Secure.ANDROID_ID
    )
    return androidID
}