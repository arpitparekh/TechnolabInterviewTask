package com.example.technolabinterviewtask

import com.example.technolabinterviewtask.room.Question
import kotlin.math.ceil

data class Paginator(var _totalItems : Int, var _itemsPerPage : Int, val _questionList: ArrayList<Question>) {

    companion object{

        var itemRemains :Int = 0
        var lastPage : Int = 0
        var itemsPerPage : Int = 0
        var totalItems : Int = 0
        lateinit var questionList : ArrayList<Question>
        var isDone : Boolean = false
    }

    fun generatePage(currentPage : Int) : ArrayList<Question>{

        val startItem = currentPage*itemsPerPage
        val numberOfData = itemsPerPage

        val pageData = ArrayList<Question>()

        if(currentPage == lastPage && itemRemains>0){

            isDone = true

            for(i in startItem until startItem+itemRemains){
                pageData.add(questionList[i])
            }
            return pageData
        }else{

            for(i in startItem until startItem+numberOfData){

                if(startItem+numberOfData<questionList.size && startItem>=0){
                    pageData.add(questionList[i])
                }
            }
            return pageData
        }
    }

    init {  // 6

        itemRemains =_totalItems % _itemsPerPage
        lastPage = _totalItems/_itemsPerPage
        itemsPerPage = _itemsPerPage
        totalItems = _totalItems
        questionList = _questionList

    }
}