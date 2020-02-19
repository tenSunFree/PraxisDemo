package com.home.praxisdemo.common.utils

import io.reactivex.Scheduler

interface IRxSchedulers {
  fun main(): Scheduler
  fun io(): Scheduler
}