package com.example.adnroid_clock

import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class ClockView(c: Context, attrs: AttributeSet?, defStyleAttr: Int) : View(c, attrs, defStyleAttr) {
    private val paint = Paint()

    init {
        paint.color = Color.BLACK
        paint.style = Paint.Style.FILL
        paint.textSize = 60F
        paint.isAntiAlias = true
    }
}