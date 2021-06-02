package com.epicood.letsfind

import android.util.Log
//
//fun main(){
//    val list = getRandom(4)
//    println("sss" + list)
//}

fun getRandom(count: Int): List<Int>{
    var c = count
    val rand = (0..19).random()
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