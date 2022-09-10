package com.example.technolabinterviewtask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.technolabinterviewtask.databinding.ActivityAddNumberBinding
import com.example.technolabinterviewtask.repo_viewmodel.QuestionViewModel

class AddNumberActivity : AppCompatActivity() {
    lateinit var binding : ActivityAddNumberBinding
    lateinit var viewModel: QuestionViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNumberBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application).create(
            QuestionViewModel::class.java)

        binding.btnGoNext.setOnClickListener {

            if(viewModel.checkData()){

                viewModel.deleteTable()

            }

            val number = Integer.parseInt(binding.edtNumber.text.toString())

            if(number>=50){
                val intent = Intent(this,ShowQuestionsActivity::class.java)
                intent.putExtra("number",number)
                startActivity(intent)
            }

        }

    }
}