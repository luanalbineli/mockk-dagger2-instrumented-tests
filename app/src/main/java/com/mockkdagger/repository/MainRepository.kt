package com.mockkdagger.repository

import androidx.lifecycle.MutableLiveData
import javax.inject.Inject

class MainRepository @Inject constructor(private val repositoryDependency: RepositoryDependency) {
    fun getValue() = MutableLiveData<String>().also {
        it.value = "MainRepository_${repositoryDependency.dependencyValue()}"
    }
}