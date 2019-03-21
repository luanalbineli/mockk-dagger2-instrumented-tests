package com.mockkdagger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.mockkdagger.di.DaggerComponentProvider
import com.mockkdagger.repository.MainRepository
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var mMainRepository: MainRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (applicationContext as DaggerComponentProvider).component.inject(this)

        mMainRepository.getValue().observe(this, Observer { value ->
            text_main_activity_hello.text = value
        })
    }
}
