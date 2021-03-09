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

    val ticker: Observable<Unit> = Observable.interval(1, TimeUnit.SECONDS).map { _ -> Unit }


}