package com.example.technolabinterviewtask

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.technolabinterviewtask.databinding.QuestionRowItemBinding
import com.example.technolabinterviewtask.room.Question

class QuestionAdapter(var questionList: ArrayList<Question>, val context : Context,val listener: OnClickListener) : RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder>() {

    class QuestionViewHolder(val binding:QuestionRowItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        val binding = QuestionRowItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return QuestionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {

        holder.binding.obj = questionList[position]


        holder.binding.rg.setOnCheckedChangeListener { group, checkedId ->
            listener.onItemClick(checkedId,position)
        }
    }
    override fun getItemCount() = questionList.size

    fun onRefreshAdapter(yourList : ArrayList<Question>) {
        questionList = yourList
        notifyDataSetChanged();

    }
}