package com.stationhead.rxjava_fizzbuzz.ui

import androidx.lifecycle.ViewModel
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.BehaviorSubject
import java.util.concurrent.TimeUnit

class MainActivityViewModel : ViewModel() {

    val fizzCount = BehaviorSubject.create<Int>()
    val buzzCount = BehaviorSubject.create<Int>()

    public override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }

    val leftPickerValueUpdated = fizzCount::onNext

    val rightPickerValueUpdated  = buzzCount::onNext
    private val disposables by lazy { CompositeDisposable() }

    val ticker: Observable<FlashState> = Observable.interval(1, TimeUnit.SECONDS).flash()

    private fun Observable<*>.flash() = flatMap { _ ->
        Observable.just(FlashState.ON)
            .mergeWith(Observable.timer(400, TimeUnit.MILLISECONDS).map { _ -> FlashState.OFF })
    }

    enum class FlashState {ON, OFF}
}