package com.example.androidokhttpissues.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.androidokhttpissues.objects.IssuesDataResponse
import com.example.androidokhttpissues.objects.CommentsDataResponse
import com.example.androidokhttpissues.repo.MainRepository

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val mainRepository = MainRepository()
    val issueReponseStatus = MutableLiveData<ArrayList<IssuesDataResponse>>()
    val commentsReponseStatus = MutableLiveData<ArrayList<CommentsDataResponse?>>()

    init {
        mainRepository.getIssuesData()?.observeForever {
            if (it != null && it.isNotEmpty()) {
                issueReponseStatus.postValue(it)
            } else {
                issueReponseStatus.postValue(null)
            }
        }
        mainRepository.getCommentsData().observeForever {
            if (it != null && it.isNotEmpty()) {
                commentsReponseStatus.postValue(it)
            } else {
                commentsReponseStatus.postValue(null)
            }
        }
    }

    fun fetchOkHttpIssuesData() {
        mainRepository.fetchIssues(getApplication<Application>().applicationContext)
    }

    fun fetchIssueCommentsData(number: Int) {
        mainRepository.fetchComments(number)
    }
}
