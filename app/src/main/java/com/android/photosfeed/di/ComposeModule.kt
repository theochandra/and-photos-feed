package com.android.photosfeed.di

import com.android.photosfeed.presentation.compose.ViewModelActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class ComposeModule {

    @ContributesAndroidInjector
    internal abstract fun contributeViewModelActivity(): ViewModelActivity

}