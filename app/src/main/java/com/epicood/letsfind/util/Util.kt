package com.epicood.letsfind

import android.annotation.SuppressLint
import android.content.Context
import android.provider.Settings
import android.util.Log
import com.epicood.letsfind.model.Rating

fun main(){
//    val list = getRandom(4)
//    println("sss" + list)
    val list = arrayListOf<Rating>()
    list.addAll(arrayListOf(
        Rating("778545455", "Aslan", "500"),
        Rating("345435345", "Resul", "4222"),
        Rating("fg45tg4gg", "Asif", "20000"),
        Rating("23g45g45g45", "Ferzib", "20")
    ))
//    Collection.reversed(list)
    val list2 = arrayListOf<Rating>()
    list.forEach { i ->

        list.forEach { b ->
            var max=0
            if(b.point!!.toInt()>max){
                max = b.point.toInt()
            }
        }

    }

    println(list.toString())
}

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