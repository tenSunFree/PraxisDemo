package com.home.praxisdemo.common.injection.component

import android.content.Context
import com.home.praxisdemo.common.BaseApplication
import com.home.praxisdemo.common.injection.module.ActivityBindingModule
import com.home.praxisdemo.common.injection.module.AppModule
import com.home.praxisdemo.common.injection.module.NetworkModule
import com.home.praxisdemo.common.injection.module.ViewModelFactoryModule
import com.home.praxisdemo.common.injection.qualifiers.ApplicationContext
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AppModule::class, ViewModelFactoryModule::class, AndroidSupportInjectionModule::class,
        ActivityBindingModule::class, NetworkModule::class]
)
interface AppComponent : AndroidInjector<BaseApplication> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<BaseApplication>() {
        @BindsInstance
        abstract fun appContext(@ApplicationContext context: Context)

        override fun seedInstance(instance: BaseApplication?) {
            appContext(instance!!.applicationContext)
        }
    }
}
