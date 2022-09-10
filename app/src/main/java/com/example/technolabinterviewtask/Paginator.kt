package com.example.technolabinterviewtask

import com.example.technolabinterviewtask.room.Question

data class Paginator(final val totalItems : Int,final val itemsPerPage : Int,val questionList: List<Question>) {


    final val itemRemains = totalItems % itemsPerPage
    final val lastPage = totalItems / itemsPerPage

    fun generatePage(currentPage : Int) : ArrayList<Question>{

        val startItem = currentPage*itemsPerPage+1
        val numberOfData = itemsPerPage

        val pageData = ArrayList<Question>()

        if(currentPage == lastPage && itemRemains>0){

            for(i in startItem until startItem+itemRemains){
                pageData.add(questionList[i])
            }

            return pageData

        }else{

            for(i in startItem until startItem+numberOfData){

                if(startItem+numberOfData<questionList.size){
                    pageData.add(questionList[i])
                }


            }

            return pageData

        }

}

}