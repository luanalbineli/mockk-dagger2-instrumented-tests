package com.mockkdagger

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.mockkdagger.di.DaggerComponentProvider
import com.mockkdagger.di.DaggerTestAppComponent
import com.mockkdagger.repository.MainRepository
import io.mockk.every

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import javax.inject.Inject

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @Rule
    @JvmField
    val taskExecutorRule = InstantTaskExecutorRule()

    @Rule
    @JvmField
    val mActivityRule = ActivityTestRule(MainActivity::class.java, true, false)

    private val mContext: Context = InstrumentationRegistry.getInstrumentation().targetContext

    private val mApp = mContext.applicationContext as DaggerComponentProvider

    private val testAppComponent by lazy {
        DaggerTestAppComponent.builder()
            .build()
    }

    @Inject
    lateinit var mMainRepository: MainRepository

    @Before
    fun daggerTestSetup() {
        mApp.component = testAppComponent
        testAppComponent.inject(this)
    }

    @Test
    fun test_check_textview_content() {
        val expectedStringValue = "EXPECTED_STRING_VALUE"
        val getValueExpectedResultLiveData = MutableLiveData<String>().also {
            it.value = expectedStringValue
        }

        every {
            mMainRepository.getValue()
        } returns getValueExpectedResultLiveData

        mActivityRule.launchActivity(null)

        onView(withId(R.id.text_main_activity_hello))
            .check(matches(withText(expectedStringValue)))
    }
}
