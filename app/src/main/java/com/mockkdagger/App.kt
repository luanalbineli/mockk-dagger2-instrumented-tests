package com.mockkdagger

import android.app.Application
import com.mockkdagger.di.AppComponent
import com.mockkdagger.di.DaggerAppComponent
import com.mockkdagger.di.DaggerComponentProvider

class App: Application(), DaggerComponentProvider {
    override var component: AppComponent = DaggerAppComponent
        .builder()
        .build()
}