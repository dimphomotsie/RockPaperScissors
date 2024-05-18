package com.example.rockpaperscissors

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge

class MainActivity : AppCompatActivity() {

    //declare
    private lateinit var button: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var imageView: ImageView
    private lateinit var textView: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //initialise
        button = findViewById(R.id.button)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        imageView = findViewById(R.id.imageView)
        textView = findViewById(R.id.textView)

        attachOnClickListeners()
    }

    private fun attachOnClickListeners() {
        button.setOnClickListener { playGame ("rock") }
        button2.setOnClickListener { playGame ("paper") }
        button3.setOnClickListener { playGame ("scissors") }
    }

    private fun playGame(userChoice: String) {
        val computerChoice = arrayOf("rock", "paper", "scissors").random()
        displayComputerChoice(computerChoice)
        val result = determineWinner(userChoice, computerChoice)
        textView.text = result
    }

    private fun displayComputerChoice(computerChoice: String) {
        val resourseId= when (computerChoice) {
            "rock" -> R.drawable.rock
            "paper" -> R.drawable.paper
            "scissors" -> R.drawable.scissors
            else -> R.drawable.rock_paper_scissors
        }
        imageView.setImageResource(resourseId)

    }

private fun determineWinner(userChoice: String, computerChoice: String): String{
    return when {
        userChoice == computerChoice -> "It's a draw!"
        (userChoice == "rock" && computerChoice == "scissors") ||
                (userChoice == "paper" && computerChoice == "rock") ||
                (userChoice == "scissors" && computerChoice == "paper") -> "You win!"

        else -> "Computer wins!"

      }

    }
}