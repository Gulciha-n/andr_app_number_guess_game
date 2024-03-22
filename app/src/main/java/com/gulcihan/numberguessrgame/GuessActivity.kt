package com.gulcihan.numberguessrgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.gulcihan.numberguessrgame.databinding.ActivityGuessBinding
import kotlin.random.Random

class GuessActivity : AppCompatActivity() {
    private lateinit var binding : ActivityGuessBinding

    private var randomNumber = 0
    private var counter = 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGuessBinding.inflate(layoutInflater)
        setContentView(binding.root)

        randomNumber = Random.nextInt(11)
        Log.e("Random number",randomNumber.toString())


        binding.buttonGuess.setOnClickListener {

            counter -= 1

            val guess = binding.editTextInput.text.toString().toInt()

            if(guess == randomNumber){
                val intent = Intent(this@GuessActivity,ResultActivity::class.java)
                intent.putExtra("Result",true)
                finish() //delete GuessActivity page from backstack
                startActivity(intent)

                return@setOnClickListener //if guess is true, stop button Guess.setOnClickListener (Break)
            }
            if(guess > randomNumber){
                binding.textViewHelp.text = "Decrease!"
                binding.textViewRemainRight.text = "Remaing Right : $counter"
            }

            if(guess < randomNumber){
                binding.textViewHelp.text = "Increase!"
                binding.textViewRemainRight.text = "Remaing Right : $counter"
            }

            if(counter == 0){
                val intent = Intent(this@GuessActivity,ResultActivity::class.java)
                intent.putExtra("Result",false)
                finish() //delete GuessActivity page from backstack
                startActivity(intent)

            }

            binding.editTextInput.setText("") //delete the last input

        }
    }
}