package com.example.weatherko.alert.mvvm

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.weatherko.alert.mvvm.repository.FakeRepoAlert
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class AlertViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: AlertViewModel
    private lateinit var fakeRepository: FakeRepoAlert

    @Before
    fun setup() {

    }

    @Test
    fun `test getItems success`() = runBlockingTest {

    }

    @Test
    fun `test delete`() = runBlockingTest {

    }
}
