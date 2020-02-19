package com.home.praxisdemo.home.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.home.praxisdemo.common.base.BaseViewModel
import com.home.praxisdemo.common.base.NetworkResult
import com.home.praxisdemo.common.injection.scope.ActivityScope
import com.home.praxisdemo.home.model.HomeApiService
import com.home.praxisdemo.home.model.HomePojo
import com.home.praxisdemo.home.model.HomeRepository
import javax.inject.Inject

@ActivityScope
class HomeViewModel @Inject constructor() : BaseViewModel() {

    @Inject
    lateinit var repository: HomeRepository
    @Inject
    lateinit var apiService: HomeApiService

    var loadingLiveData: MutableLiveData<Boolean> = MutableLiveData()
    var homePojoLiveData: MutableLiveData<HomePojo> = MutableLiveData()

    fun loadHomePojo() {
        loadingLiveData.value = true
        addDisposable(repository.getHomePojoDisposable())
        repository.subscribe = {
            loadingLiveData.value = false
            when (it) {
                is NetworkResult.Success -> {
                    homePojoLiveData.value = it.body
                }
                is NetworkResult.Failure -> {
                    Log.d("HomeViewModel", "Failure: ${it.message}")
                }
            }
        }
    }
}