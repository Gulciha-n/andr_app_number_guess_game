package com.gulcihan.numberguessrgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gulcihan.numberguessrgame.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding : ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val result = intent.getBooleanExtra("Result",false)

        if(result){
            binding.textViewResult.text = "You Won"
            binding.imageViewResult.setImageResource(R.drawable.won_image)

        }else{
            binding.textViewResult.text = "You Lost"
            binding.imageViewResult.setImageResource(R.drawable.lose_image)
        }

        binding.buttonGuessAgain.setOnClickListener {
            val intent = Intent(this@ResultActivity,GuessActivity::class.java)
            finish()
            startActivity(intent)
        }
    }
}