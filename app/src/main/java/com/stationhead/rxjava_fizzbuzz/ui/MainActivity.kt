package com.stationhead.rxjava_fizzbuzz.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.stationhead.rxjava_fizzbuzz.R
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber

class MainActivity : AppCompatActivity() {

	private val model: MainActivityViewModel by lazy {
		ViewModelProvider(this).get(
        MainActivityViewModel::class.java)
	}

	// Phase-1 objective:
	// Amber light should turn on every 3 seconds
	// Green light should turn on every 5 seconds
	// Lights will turn when `isActivated` is true

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		model.filteredAmber
				.subscribeBy(
            onNext = {
              Log.i("Test","AmberLight: $it")
              amberLight.isActivated = true
            })

		model.filteredGreen
				.subscribeBy(
            onNext = {
              Log.i("Test","greenLight: $it")
              greenLight.isActivated = true
            })
	}
}
