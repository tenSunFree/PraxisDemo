package com.home.praxisdemo.home.model

import com.home.praxisdemo.common.base.NetworkResult
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class HomeRepository constructor(private val apiService: HomeApiService) {

    var subscribe: ((networkResult: NetworkResult<HomePojo>) -> Unit)? = null

    fun getHomePojoDisposable(): Disposable {
        return apiService.getHomePojo()
            // 故意延遲2秒
            .delay(2, TimeUnit.SECONDS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                subscribe?.invoke(NetworkResult.Success(response))
            }, {
                subscribe?.invoke(NetworkResult.Failure(it.message.toString()))
            })
    }
}