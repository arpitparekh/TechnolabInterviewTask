package com.example.technolabinterviewtask

import android.content.Intent
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

class ShowQuestionsActivity : AppCompatActivity(), OnClickListener {
    lateinit var binding : ActivityShowQuestionsBinding
    lateinit var questionList : ArrayList<Question>
    lateinit var adapter : QuestionAdapter
    lateinit var viewModel: QuestionViewModel
    var counter = 0
    var currentPage = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShowQuestionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        questionList = ArrayList()

        val totalNumber = intent.getIntExtra("number",0)

        binding.rvQuestions.layoutManager = LinearLayoutManager(this)

        viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application).create(
            QuestionViewModel::class.java)

        viewModel.insert(intent.getIntExtra("number",0))

        viewModel.displayQuestions().observe(this, Observer {

            adapter = QuestionAdapter(Paginator(intent.getIntExtra("number",0),10,
                it as ArrayList<Question>
            ).generatePage(currentPage),this,this)

            questionList = it

            binding.rvQuestions.adapter = adapter

            if(Paginator.isDone) {

                binding.btnNext.text = "Submit"

            }
        })

        binding.btnNext.setOnClickListener {


            if(binding.btnNext.text=="Submit"){

                val intent = Intent(this,ResultActivity::class.java)
                intent.putExtra("totalNumber",totalNumber)
                intent.putExtra("counter",counter)
                startActivity(intent)


            }else{

                if(currentPage>=0){

                    currentPage += 1
                    adapter.onRefreshAdapter(Paginator(intent.getIntExtra("number",0),10,questionList).generatePage(currentPage))
                    if(Paginator.isDone){
                        binding.btnNext.text = "Submit"
                    }
                }
            }

        }
        binding.btnPrevious.setOnClickListener {

            if(currentPage>0){
                currentPage -= 1
                adapter.onRefreshAdapter(Paginator(intent.getIntExtra("number",0),10,questionList).generatePage(currentPage))
            }

        }
    }

    override fun onItemClick(checkedId: Int, position: Int) {

        if(!questionList[position].answered){
            var result = 0

            when(checkedId){

                R.id.radio1->{
                    result = 1
                    questionList[position].userAnswer=1
                    questionList[position].answered = true
                }
                R.id.radio2-> {
                    result = 2
                    questionList[position].userAnswer=2
                    questionList[position].answered = true
                }
                R.id.radio3-> {
                    result = 3
                    questionList[position].userAnswer=3
                    questionList[position].answered = true
                }
                R.id.radio4-> {
                    result = 4
                    questionList[position].userAnswer=4
                    questionList[position].answered = true
                }

            }

            if(result==questionList[position].answer){
                counter++
            }

        }
    }
}