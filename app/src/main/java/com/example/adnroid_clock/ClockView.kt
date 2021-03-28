package com.example.adnroid_clock

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import java.util.*

class ClockView(c: Context, attrs: AttributeSet?) : View(c, attrs) {
    private val paint = Paint()

    init {
        paint.color = Color.BLACK
        paint.style = Paint.Style.FILL
        paint.textSize = 60F
        paint.isAntiAlias = true
    }

    private fun getImage(num: String) {
        for (char in num) {
            when(char) {
                '0'
            }
        }
    }

    override fun onDraw(canvas: Canvas?) {
        val calendar = Calendar.getInstance()
        val hour: String = calendar.get(Calendar.HOUR_OF_DAY).toString()
        val minute: String = calendar.get(Calendar.MINUTE).toString()
        val second: String = calendar.get(Calendar.SECOND).toString()

        canvas?.drawColor(Color.WHITE)
        canvas?.drawText(hour, width / 2F - 200F, height / 2F, paint)
        canvas?.drawText(minute, width / 2F - 100F, height / 2F, paint)
        canvas?.drawText(second, width / 2F, height / 2F, paint)

        postInvalidateDelayed(500)
        invalidate()

        super.onDraw(canvas)
    }
}
