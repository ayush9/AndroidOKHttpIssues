package com.example.androidokhttpissues.repo

import com.example.androidokhttpissues.objects.IssuesDataResponse
import retrofit2.Call
import retrofit2.http.GET


interface GetDataService {

    @GET("repos/square/okhttp/issues")
    fun getOkHttpIssues(): Call<ArrayList<IssuesDataResponse?>>
}