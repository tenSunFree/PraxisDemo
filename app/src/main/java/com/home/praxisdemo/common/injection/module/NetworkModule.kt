package com.home.praxisdemo.common.injection.module

import com.home.praxisdemo.BuildConfig
import com.home.praxisdemo.common.utils.AppConstants
import com.home.praxisdemo.home.model.HomeApiService
import com.home.praxisdemo.home.model.HomeRepository
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    internal fun provideOkHttpClient(): OkHttpClient {
        val httpBuilder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            httpBuilder.interceptors()
                .add(httpLoggingInterceptor)
        }
        return httpBuilder.build()
    }

    @Provides
    @Singleton
    internal fun provideCoroutineJokeRepo(rxApiService: HomeApiService): HomeRepository {
        return HomeRepository(rxApiService)
    }

    @Provides
    @Singleton
    @Named(AppConstants.RX_RETROFIT)
    internal fun provideRxRestAdapter(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    internal fun provideRxApiService(@Named(AppConstants.RX_RETROFIT) restAdapter: Retrofit): HomeApiService {
        return restAdapter.create(HomeApiService::class.java)
    }
}
