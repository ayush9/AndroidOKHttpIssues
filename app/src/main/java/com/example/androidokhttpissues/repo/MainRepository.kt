package com.example.androidokhttpissues.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.androidokhttpissues.objects.CommentsDataResponse
import com.example.androidokhttpissues.objects.IssuesDataResponse
import com.example.androidokhttpissues.repo.RetrofitClientInstance.retrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainRepository {

    private var issuesData: MutableLiveData<ArrayList<IssuesDataResponse?>>? = null
    private var commentsData: MutableLiveData<ArrayList<CommentsDataResponse?>>? = null

    fun getIssuesData(): LiveData<ArrayList<IssuesDataResponse?>> {
        if (issuesData == null) {
            issuesData = MutableLiveData()
        }
        return issuesData as MutableLiveData<ArrayList<IssuesDataResponse?>>
    }

    fun getCommentsData(): LiveData<ArrayList<CommentsDataResponse?>> {
        if (commentsData == null) {
            commentsData = MutableLiveData()
        }
        return commentsData as MutableLiveData<ArrayList<CommentsDataResponse?>>
    }

    fun fetchIssues() {
        val service =
            retrofitInstance!!.create(
                GetDataService::class.java
            )
        val call: Call<ArrayList<IssuesDataResponse?>> = service.getOkHttpIssues()
        call.enqueue(object : Callback<ArrayList<IssuesDataResponse?>> {
            override fun onResponse(
                call: Call<ArrayList<IssuesDataResponse?>>,
                response: Response<ArrayList<IssuesDataResponse?>>
            ) {
                issuesData?.postValue(response.body())
            }

            override fun onFailure(
                call: Call<ArrayList<IssuesDataResponse?>>?,
                t: Throwable?
            ) {
                issuesData?.postValue(null)
            }
        })
    }

    fun fetchComments(number: Int) {
        val service =
            retrofitInstance!!.create(
                GetDataService::class.java
            )
        val call: Call<ArrayList<CommentsDataResponse?>> = service.getIssuesComment(number)
        call.enqueue(object : Callback<ArrayList<CommentsDataResponse?>> {
            override fun onResponse(
                call: Call<ArrayList<CommentsDataResponse?>>,
                response: Response<ArrayList<CommentsDataResponse?>>
            ) {
                commentsData?.postValue(response.body())
            }

            override fun onFailure(
                call: Call<ArrayList<CommentsDataResponse?>>?,
                t: Throwable?
            ) {
                commentsData?.postValue(null)
            }
        })
    }
}
