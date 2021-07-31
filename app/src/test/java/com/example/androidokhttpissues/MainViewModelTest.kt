package com.example.androidokhttpissues

import android.app.Application
import android.content.Context
import android.content.res.Resources
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.example.androidokhttpissues.objects.IssuesDataResponse
import com.example.androidokhttpissues.repo.MainRepository
import com.example.androidokhttpissues.utils.ObjectMapper
import com.example.androidokhttpissues.viewmodel.MainViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.powermock.api.mockito.PowerMockito
import org.powermock.core.classloader.annotations.PrepareForTest
import java.lang.reflect.Type
@PrepareForTest(ConnectivityManager::class)
class MainViewModelTest {

    @Rule
    @JvmField
    var rule: TestRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var application: Application

    @Mock
    private lateinit var mockConnectivityManager: ConnectivityManager

    @Mock
    lateinit var mockResources: Resources

    @Mock
    lateinit var mainRepository: MainRepository

    @Mock
    private lateinit var issuesData: MutableLiveData<java.util.ArrayList<IssuesDataResponse>>

    private val mockedIssuesSuccessResponse = ObjectMapper.getObjectFromJson(
        HTTP_ISSUES_SUCCESS_RESPONSE, IssuesDataResponse::class.java
    )

    private val mockedIssuesFailureResponse = ObjectMapper.getObjectFromJson(
        HTTP_ISSUES_FAILURE_RESPONSE, IssuesDataResponse::class.java
    ) as IssuesDataResponse?

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        PowerMockito.mock(MainRepository::class.java)
        PowerMockito.mock(ConnectivityManager::class.java)
        Mockito.`when`(mainRepository.getIssuesData()).thenReturn(issuesData)
        val context  =  Mockito.mock(Context::class.java)
        Mockito.`when`(application.applicationContext).thenReturn(context)
        mockConnectivityManager = Mockito.mock(ConnectivityManager::class.java)
        Mockito.`when`(context.getSystemService(Context.CONNECTIVITY_SERVICE)).thenReturn(mockConnectivityManager)
    }

    @Test
    fun verifyIssuesUIVisible_onSuccess() {
        val mainViewModel = MainViewModel(application)
        mainViewModel.fetchOkHttpIssuesData()
        mainViewModel.issueReponseStatus.postValue(mockedIssuesSuccessResponse as ArrayList<IssuesDataResponse>?)
        Assert.assertEquals(false, mainViewModel.issueReponseStatus.value)
    }

}