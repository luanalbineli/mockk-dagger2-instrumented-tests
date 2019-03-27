package com.mockkdagger.di

import com.mockkdagger.repository.MainRepository
import dagger.Module
import dagger.Provides
import io.mockk.mockk
import javax.inject.Singleton

@Module
object RepositoryModuleTest {
    @Provides
    @JvmStatic
    @Singleton
    fun mainRepository(): MainRepository = mockk()
}