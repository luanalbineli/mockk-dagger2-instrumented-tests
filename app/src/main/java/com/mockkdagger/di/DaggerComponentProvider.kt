package com.mockkdagger.di

import androidx.annotation.VisibleForTesting

interface DaggerComponentProvider {
    @set:VisibleForTesting
    var component: AppComponent
}