package com.mockkdagger.di

import com.mockkdagger.MainActivityTest
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    RepositoryModuleTest::class
])
interface AppComponentTest: AppComponent {
    @Component.Builder
    interface Builder {
        fun build(): AppComponentTest
    }

    fun inject(test: MainActivityTest)
}