package com.epicood.letsfind.dao

import android.content.Context
import androidx.room.*
import com.epicood.letsfind.model.Rating


//@Database(entities = [RatingEntity::class], version = 1)
//abstract class QuizDatabase : RoomDatabase() {
//
//    abstract val quizDAO: QuizDAO
//
//    companion object{
//        @Volatile private var instance : QuizDatabase? = null
//        private val lock = Any()
//
//        operator fun invoke(context: Context) = instance ?: synchronized(lock){
//            instance ?: makeDatabase(context).also {
//                instance = it
//            }
//        }
//
//        private fun makeDatabase(context: Context) = Room.databaseBuilder(
//            context.applicationContext, QuizDatabase::class.java, "quiz_database"
//        ).build()
//    }
//
//}