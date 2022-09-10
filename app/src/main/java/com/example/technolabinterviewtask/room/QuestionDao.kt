package com.example.technolabinterviewtask.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface QuestionDao {

    @Query("select * from Question")
    fun getAllQuestions() : LiveData<List<Question>>

    @Insert
    fun insertQuestions(question: Question)

    @Query("DELETE FROM Question")
    fun delete()

    @Query("SELECT EXISTS(SELECT * FROM Question)")
    fun isExists(): Boolean
}