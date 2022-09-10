package com.example.technolabinterviewtask.repo_viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.technolabinterviewtask.room.Question
import com.example.technolabinterviewtask.room.QuestionDao
import com.example.technolabinterviewtask.room.QuestionDatabase
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class QuestionRepo(application: Application) {

    var questionLiveData : LiveData<List<Question>>
    var executor : Executor
    var dao : QuestionDao
    init {
        val questionDatabase = QuestionDatabase.getDatabase(application)
        dao = questionDatabase!!.getDao()
        questionLiveData = questionDatabase.getDao().getAllQuestions()
        executor = Executors.newSingleThreadExecutor()
    }

    fun displayQuestions() : LiveData<List<Question>>{

        return questionLiveData

    }

    fun insertQuestions(number : Int){

        executor.execute(Runnable {

            val questionList = ArrayList<Question>()

            for(i in 0 until number){

                val ans =(1..4).random()
                questionList.add(Question("question : ${i+1}","option 1","option 2","option 3","option 4",ans,false,0))
                dao.insertQuestions(questionList[i])

            }
        })

    }

    fun checkData() : Boolean{
            return dao.isExists()
    }

    fun deleteTable(){
        dao.delete()
    }

}