package com.home.praxisdemo.common.injection.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.home.praxisdemo.common.injection.scope.ViewModelScope
import com.home.praxisdemo.home.viewmodel.HomeViewModel
import com.home.praxisdemo.list.viewmodel.ListViewModel
import com.home.praxisdemo.common.utils.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelFactoryModule {

  @Binds
  @IntoMap
  @ViewModelScope(ListViewModel::class)
  abstract fun bindShowJokeViewModel(showJokeViewModel: ListViewModel): ViewModel

  @Binds
  @IntoMap
  @ViewModelScope(HomeViewModel::class)
  abstract fun bindHomeViewModel(homeViewModel: HomeViewModel): ViewModel

  @Binds
  internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

  // @Binds
  // @IntoMap
  // @ViewModelScope(AboutViewModel::class)
  // abstract fun bindAboutViewModel(aboutViewModel: AboutViewModel): ViewModel
}
