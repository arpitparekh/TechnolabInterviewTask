package com.example.technolabinterviewtask

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.technolabinterviewtask.databinding.QuestionRowItemBinding
import com.example.technolabinterviewtask.room.Question

class QuestionAdapter(val questionList: List<Question>,val context : Context) : RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder>() {

    class QuestionViewHolder(val binding:QuestionRowItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        val binding = QuestionRowItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return QuestionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
       holder.binding.obj = questionList[position]
    }

    override fun getItemCount() = questionList.size
}