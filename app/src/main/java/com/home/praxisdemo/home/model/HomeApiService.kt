package com.home.praxisdemo.home.model

import io.reactivex.Single
import retrofit2.http.GET

interface HomeApiService {

    @GET("opendata/datalist/apiAccess?scope=resourceAquire&rid=f18de02f-b6c9-47c0-8cda-50efad621c14")
    fun getHomePojo(): Single<HomePojo>
}