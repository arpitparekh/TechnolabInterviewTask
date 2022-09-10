package com.example.technolabinterviewtask.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Question::class], version = 1, exportSchema = false)
abstract class QuestionDatabase  : RoomDatabase(){

    abstract fun getDao() : QuestionDao

    companion object{

        var questionDatabase : QuestionDatabase? = null

        fun getDatabase(context : Context) : QuestionDatabase?{

            if(questionDatabase ==null){

                questionDatabase = Room.databaseBuilder(context, QuestionDatabase::class.java,"questionDatabase")
                    .allowMainThreadQueries()
                    .build()

                return questionDatabase

            }

            return questionDatabase

        }

    }
}