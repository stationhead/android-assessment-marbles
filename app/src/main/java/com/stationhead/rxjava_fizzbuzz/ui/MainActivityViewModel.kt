package com.stationhead.rxjava_fizzbuzz.ui

import androidx.lifecycle.ViewModel
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import java.util.concurrent.TimeUnit

class MainActivityViewModel : ViewModel() {

    public override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }

    private val disposables by lazy { CompositeDisposable() }

    val ticker: Observable<Unit> = Observable.interval(1, TimeUnit.SECONDS).map { _ -> Unit }


}