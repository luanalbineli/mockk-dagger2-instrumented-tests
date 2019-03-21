package com.mockkdagger.repository

import javax.inject.Inject

class RepositoryDependency @Inject constructor() {
    fun dependencyValue() = "RepositoryDependency"
}