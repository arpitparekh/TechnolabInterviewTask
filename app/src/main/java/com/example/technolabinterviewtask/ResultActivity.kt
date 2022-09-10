package com.example.technolabinterviewtask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.technolabinterviewtask.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    lateinit var binding : ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val totalNumber = intent.getIntExtra("totalNumber",0)
        val counter = intent.getIntExtra("counter",0)

        binding.result.text = "$counter / $totalNumber"

        binding.percentage.text = "${(counter/totalNumber)*100} %"

        if((counter/totalNumber)*100>70){
            binding.isPassed.text = "Passed"
        }else if((counter/totalNumber)*100 in 31..70){
            binding.isPassed.text = "InterMediate"
        }else{
            binding.isPassed.text = "Failed"
        }

    }
}