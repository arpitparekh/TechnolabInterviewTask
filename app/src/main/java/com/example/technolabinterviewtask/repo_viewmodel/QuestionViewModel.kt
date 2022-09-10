package com.example.technolabinterviewtask.repo_viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.technolabinterviewtask.room.Question

class QuestionViewModel(application: Application) : AndroidViewModel(application) {

    var repo : QuestionRepo
    var questionLiveData : LiveData<List<Question>>
    init {
        repo = QuestionRepo(application)
        questionLiveData = repo.displayQuestions()
    }
    fun displayQuestions() : LiveData<List<Question>>{
         return questionLiveData
    }
    fun insert(number : Int) {

        repo.insertQuestions(number)

    }

    fun checkData() : Boolean{
        return repo.checkData()
    }

    fun deleteTable(){
        repo.deleteTable()
    }

}