package com.example.stopwatchwithchronometer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import android.widget.Chronometer

class MainActivity : AppCompatActivity() {

    private var isRunning = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val start_button = findViewById<Button>(R.id.start_button)
        val stop_button = findViewById<Button>(R.id.stop_button)
        val chronometer = findViewById<Chronometer>(R.id.chronometer)

        start_button.setOnClickListener {
            if (!isRunning) {
                chronometer.base = SystemClock.elapsedRealtime()
                chronometer.start()
                isRunning = true
            }
        }

        stop_button.setOnClickListener {
            if (isRunning) {
                chronometer.stop()
                isRunning = false
            }
        }
    }
}