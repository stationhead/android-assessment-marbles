package com.stationhead.rxjava_fizzbuzz.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.stationhead.rxjava_fizzbuzz.R
import com.trello.rxlifecycle2.android.lifecycle.kotlin.bindToLifecycle
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private val model: MainActivityViewModel by lazy { ViewModelProvider(this).get(
        MainActivityViewModel::class.java) }

    // Phase-1 objective:
    // Amber light should turn on every 3 seconds
    // Green light should turn on every 5 seconds
    // Lights will turn when `isActivated` is true

    // Phase-2 objective:
    // integrate flash functionality.
    // update status label to read:
    //    "Fizz" when the amber light flashes,
    //    "Buzz" when the green light flashes,
    //    "FizzBuzz" when both lights flashes, and
    //    nothing ("") when neither light flashes.

    //Phase-3 objective:
    // Integrate Spinners to let user select rate of flashes.

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