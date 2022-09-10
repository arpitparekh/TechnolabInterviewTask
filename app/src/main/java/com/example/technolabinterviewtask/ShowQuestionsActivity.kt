package com.example.technolabinterviewtask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.technolabinterviewtask.databinding.ActivityShowQuestionsBinding
import com.example.technolabinterviewtask.repo_viewmodel.QuestionViewModel
import com.example.technolabinterviewtask.room.Question

class ShowQuestionsActivity : AppCompatActivity() {
    lateinit var binding : ActivityShowQuestionsBinding
    lateinit var questionList : ArrayList<Question>
    lateinit var viewModel: QuestionViewModel
    lateinit var adapter: QuestionAdapter
    var currentPage = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShowQuestionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        questionList = ArrayList()

        binding.rvQuestions.layoutManager = LinearLayoutManager(this)

        viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application).create(
            QuestionViewModel::class.java)

        viewModel.insert(intent.getIntExtra("number",0))

        viewModel.displayQuestions().observe(this, Observer {

            adapter = QuestionAdapter(Paginator(intent.getIntExtra("number",0),10,it).generatePage(currentPage),this)

            binding.rvQuestions.adapter = adapter


        })

        binding.btnNext.setOnClickListener {

            currentPage += 1

            adapter = QuestionAdapter(Paginator(intent.getIntExtra("number",0),10,questionList).generatePage(currentPage),this)
            adapter.notifyDataSetChanged()

        }

        binding.btnPrevious.setOnClickListener {

            currentPage -= 1

            adapter = QuestionAdapter(Paginator(intent.getIntExtra("number",0),10,questionList).generatePage(currentPage),this)
            adapter.notifyDataSetChanged()

        }
    }
}