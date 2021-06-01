package com.epicood.letsfind.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.epicood.letsfind.model.Quiz

class QuizViewModel: ViewModel() {

    val quizs = MutableLiveData<List<Quiz>>()

    fun getData(){
        val q1 = Quiz("Dünyadakı ən ciddi problem hansıdır?", "Təhsil", "Aclıq", "Epidemiyalar", "Ətraf mühitin çirklənməsi", "Təhsil")
        val q2 = Quiz("Ən sevimli nağıl qəhrəmanı kimdir", "Tık-tık xanım", "Cırtdan", "Simurq quşu", "Məlikməmməd", "Cırtdan")
        val q3 = Quiz("Uşaq istismarı ......... şiddət, irqçilik isə ......... şiddətə nümunədir.", "quruluşçu, təcavüzkar", "fiziki, quruluşçu", "fiziki, psixoloji", "psixoloji, quruluşçu", "fiziki, psixoloji")
        val q4 = Quiz("Aşağıdakılardan hansı Çingiz xanın ölümündən sonra qurulan dövlətlərdən biri deyil?", "Qızıl Ordu", "Çağatay", "Kubilay", "Ağqoyunlu", "Kubilay")
        val q5 = Quiz("Hansı yaşlar fiziki aktivliyin ən yüksək həddə çatdığı dövrdür? ", "11-15", "13-19", "24-32", "32-dən yuxarı", "24-32")

        val list = arrayListOf(q1, q2, q3, q4, q5)
        quizs.value = list
    }

}