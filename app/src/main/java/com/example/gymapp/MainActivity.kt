package com.example.gymapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    //Current fields
    private lateinit var userText : EditText
    private lateinit var btnSuggest : Button
    private lateinit var btnClear : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Assigning variables to there id
        val output = findViewById<TextView>(R.id.txtOutput)
        userText = findViewById(R.id.edtInput)
        btnSuggest = findViewById(R.id.btnSuggest)
        btnClear = findViewById(R.id.btnClear)

        btnSuggest.setOnClickListener {
            val userInput = userText.text.toString().trim().lowercase()

            if(userInput.isEmpty()){
                userText.error = "Please enter time of day"
                output.text = ""
            }else{
                val suggestFood = suggestRoutine   (userInput)
                output.text = "$suggestFood"
                userText.error = null
            }
        }
    }

    private fun suggestRoutine(userInput: String): String {
        return when(userInput) {
            "morning" -> "Jogging"
            "mid-morning" -> "Yoga"
            "afternoon" -> "Jogging"
            "mid-afternoon" -> "Cycling"
            "Evening" -> "Light Strength training"
            else -> "Invalid"
        }
    }
}