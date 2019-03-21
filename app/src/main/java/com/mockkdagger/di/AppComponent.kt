package com.mockkdagger.di

import com.mockkdagger.MainActivity
import dagger.Component

import javax.inject.Singleton

@Singleton
@Component
interface AppComponent {
    @Component.Builder
    interface Builder {
        fun build(): AppComponent
    }

    fun inject(mainActivity: MainActivity)
}
    