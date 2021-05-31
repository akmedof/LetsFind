package com.epicood.letsfind.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.epicood.letsfind.model.Quiz

class QuizViewModel: ViewModel() {

    val quizs = MutableLiveData<List<Quiz>>()

    fun getData(){
//        val q1 = Quiz()
//        val q2 = Quiz()
//        val q3 = Quiz()
//        val q4= Quiz()
//        val q5 = Quiz()

//        val list = arrayListOf<Quiz>(q1, q2, q3, q4, q5)
//        quizs.value = list
    }

}