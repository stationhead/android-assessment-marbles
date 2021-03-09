package com.stationhead.rxjava_fizzbuzz.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.stationhead.rxjava_fizzbuzz.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val model: MainActivityViewModel by lazy { ViewModelProvider(this).get(
        MainActivityViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupPickers()
    }

    private fun setupPickers() {
        leftPicker.minValue = 3
        leftPicker.maxValue = 9
        leftPicker.wrapSelectorWheel = false

        rightPicker.minValue = 5
        rightPicker.maxValue = 13
        rightPicker.wrapSelectorWheel = false

        leftPicker.setOnValueChangedListener { _, _, newVal ->
            model.leftPickerValueUpdated(newVal)
        }
        rightPicker.setOnValueChangedListener { _, _, newVal ->
            model.rightPickerValueUpdated(newVal)
        }
    }
}
