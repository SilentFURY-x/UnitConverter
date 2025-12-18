package com.fury.unitconverter

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val inputEdit : EditText = findViewById(R.id.editTextText)
        val convertButton : Button = findViewById(R.id.button)
        val resultText : TextView = findViewById(R.id.textView)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        convertButton.setOnClickListener {
            Toast.makeText(this, "Converted", Toast.LENGTH_SHORT).show()

            val kgsString = inputEdit.text.toString()

            // 2. Convert that text (String) into a number (Double)
            // We use toDoubleOrNull() to prevent crashing if the box is empty
            val kgs = kgsString.toDoubleOrNull()

            if (kgs != null) {
                // 3. Do the math (1 Kg = 2.20462 Pounds)
                val pounds = kgs * 2.20462

                // 4. Display the result in the TextView
                resultText.text = "$pounds Pounds"
            } else {
                // If the user typed nothing or non-numbers
                resultText.text = "Please enter a valid number"
            }
        }
    }
}