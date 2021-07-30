package com.example.androidokhttpissues.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.androidokhttpissues.objects.IssuesDataResponse
import com.example.androidokhttpissues.repo.RetrofitClientInstance.retrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainRepository {

    private var issuesData: MutableLiveData<ArrayList<IssuesDataResponse?>>? = null

    fun getIssuesData(): LiveData<ArrayList<IssuesDataResponse?>> {
        if (issuesData == null) {
            issuesData = MutableLiveData()
        }
        return issuesData as MutableLiveData<ArrayList<IssuesDataResponse?>>
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
}
