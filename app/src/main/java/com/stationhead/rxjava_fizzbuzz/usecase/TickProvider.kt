package com.stationhead.rxjava_fizzbuzz.usecase

import io.reactivex.Observable
import java.util.concurrent.TimeUnit

class TickProvider {
    public  fun getTicks() = Observable.interval(1, TimeUnit.SECONDS).map { _ -> Unit }
}