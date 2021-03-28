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

    private fun getImage(num: String): Int {
        var image = 0

        when (num) {
            "0" -> image = R.drawable.zero
            "1" -> image = R.drawable.one
            "2" -> image = R.drawable.two
            "3" -> image = R.drawable.three
            "4" -> image = R.drawable.four
            "5" -> image = R.drawable.five
            "6" -> image = R.drawable.six
            "7" -> image = R.drawable.seven
            "8" -> image = R.drawable.eight
            "9" -> image = R.drawable.nine
        }

        return image
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
