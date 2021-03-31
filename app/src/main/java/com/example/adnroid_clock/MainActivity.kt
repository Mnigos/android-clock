package com.example.adnroid_clock

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    private fun getFirstDigit(num: Int): Int {
        return if (num > 9) num.toString().substring(0..1).toInt()
        else 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
