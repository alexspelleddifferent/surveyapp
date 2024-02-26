package com.example.surveyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private val countsViewModel: CountsViewModel by lazy {
        ViewModelProvider(this).get(CountsViewModel::class.java)
    }

    lateinit var buttonLeft: Button
    lateinit var buttonRight: Button
    lateinit var buttonReset: Button
    lateinit var countLeft: TextView
    lateinit var countRight: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonLeft = findViewById(R.id.button_left)
        buttonRight = findViewById(R.id.button_right)
        buttonReset = findViewById(R.id.reset_button)
        countLeft = findViewById(R.id.count_left)
        countRight = findViewById(R.id.count_right)

        updateBoth()

        buttonLeft.setOnClickListener {
            countsViewModel.updateLeft()
            countLeft.text = countsViewModel.getLeftCount().toString()
        }

        buttonRight.setOnClickListener {
            countsViewModel.updateRight()
            countRight.text = countsViewModel.getRightCount().toString()
        }

        buttonReset.setOnClickListener {
            countsViewModel.reset()
            updateBoth()
        }
    }
    fun updateBoth() {
        countLeft.text = countsViewModel.getLeftCount().toString()
        countRight.text = countsViewModel.getRightCount().toString()
    }
}