package com.example.touchtracker

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var tvCoordinates: TextView
    private lateinit var mainLayout: View

    @SuppressLint("ClickableViewAccessibility", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvCoordinates = findViewById(R.id.tvCoordinates)
        mainLayout = findViewById(R.id.mainLayout)

        mainLayout.setOnTouchListener { _, event ->
            val x = event.x.toInt()
            val y = event.y.toInt()
            when (event.action) {
                MotionEvent.ACTION_DOWN, MotionEvent.ACTION_MOVE -> {
                    tvCoordinates.text = "Координати на докосване:\nX: $x px\nY: $y px"
                }
                MotionEvent.ACTION_UP -> {
                    tvCoordinates.text = "Пръстът е вдигнат.\nПоследно докосване на X: $x, Y: $y"
                }
            }
            true

        }
    }
}