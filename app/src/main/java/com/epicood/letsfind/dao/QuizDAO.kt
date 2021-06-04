package com.epicood.letsfind.dao

import androidx.room.*
import com.epicood.letsfind.model.Rating

//@Dao
//interface QuizDAO {
//
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertRating(vararg rating: Rating)
//
//    @Transaction
//    @Query("SELECT * FROM rating")
//    suspend fun getAllRating(): List<Rating>
//
//    @Transaction
//    @Query("DELETE FROM rating")
//    suspend fun deleteAllRating()
//
////    @Query("SELECT * FROM rating WHERE androidID == ")
////    suspend fun checkAndroidID
//
//
//}