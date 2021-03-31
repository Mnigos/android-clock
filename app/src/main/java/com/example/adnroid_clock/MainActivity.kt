package com.example.adnroid_clock

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    private var hours = 0
    private var minutes = 0
    private var seconds = 0

    private var firstNum = 0
    private var secondNum = 0
    private var thirdNum = 0
    private var fourthNum = 0
    private var fifthNum = 0
    private var sixthNum = 0

    private lateinit var imageFirst: ImageView
    private lateinit var imageSecond: ImageView
    private lateinit var imageThird: ImageView
    private lateinit var imageFourth: ImageView
    private lateinit var imageFifth: ImageView
    private lateinit var imageSixth: ImageView

    private fun getFirstDigit(num: Int): Int {
        return if (num > 9) num.toString()[0].toString().toInt()
        else 0
    }

    private fun getSecondDigit(num: Int): Int {
        return if (num > 9) num.toString()[1].toString().toInt()
        else num
    }

    private fun getImage(num: Int): Int = when (num) {
        0 -> R.drawable.zero
        1 -> R.drawable.one
        2 -> R.drawable.two
        3 -> R.drawable.three
        4 -> R.drawable.four
        5 -> R.drawable.five
        6 -> R.drawable.six
        7 -> R.drawable.seven
        8 -> R.drawable.eight
        9 -> R.drawable.nine
        else -> 0
    }

    private fun updateDigits() {
        firstNum = getFirstDigit(hours)
        secondNum = getSecondDigit(hours)

        thirdNum = getFirstDigit(minutes)
        fourthNum = getSecondDigit(minutes)

        fifthNum = getFirstDigit(seconds)
        sixthNum = getSecondDigit(seconds)
    }

    private fun updateTime() {
        val calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC+3"))

        hours = calendar[Calendar.HOUR_OF_DAY]
        minutes = calendar[Calendar.MINUTE]
        seconds = calendar[Calendar.SECOND]
    }

    private fun setImages() {
        imageFirst.setImageResource(getImage(firstNum))
        imageSecond.setImageResource(getImage(secondNum))
        imageThird.setImageResource(getImage(thirdNum))
        imageFourth.setImageResource(getImage(fourthNum))
        imageFifth.setImageResource(getImage(fifthNum))
        imageSixth.setImageResource(getImage(sixthNum))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageFirst = findViewById(R.id.imageFirst)
        imageSecond = findViewById(R.id.imageSecond)
        imageThird = findViewById(R.id.imageThird)
        imageFourth = findViewById(R.id.imageFourth)
        imageFifth = findViewById(R.id.imageFifth)
        imageSixth = findViewById(R.id.imageSixth)

        Timer().scheduleAtFixedRate(
            object : TimerTask() {
                override fun run() {
                    updateTime()
                    updateDigits()

                    runOnUiThread { setImages() }
                }
            },
            0, 1000
        )
    }
}
