package com.mockkdagger.di

import com.mockkdagger.MainActivityTest
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    RepositoryModule::class
])
interface TestAppComponent: AppComponent {
    @Component.Builder
    interface Builder {
        fun build(): TestAppComponent
    }

    fun inject(test: MainActivityTest)
}