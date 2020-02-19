package com.home.praxisdemo.common.injection.module

import android.content.Context
import com.home.praxisdemo.common.injection.qualifiers.ActivityContext
import com.home.praxisdemo.common.injection.scope.ActivityScope
import com.home.praxisdemo.list.view.ListActivity
import dagger.Binds
import dagger.Module
import dagger.android.support.DaggerAppCompatActivity

@Module(includes = [BaseActivityModule::class])
abstract class ShowJokeActivityModule {

  @Binds
  @ActivityContext
  abstract fun provideActivityContext(activity: ListActivity): Context

  @Binds
  @ActivityScope
  abstract fun provideActivity(showJokeActivity: ListActivity): DaggerAppCompatActivity
}
