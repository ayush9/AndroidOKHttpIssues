package com.example.androidokhttpissues.repo

import com.example.androidokhttpissues.objects.CommentsDataResponse
import com.example.androidokhttpissues.objects.IssuesDataResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface GetDataService {

    @GET("repos/square/okhttp/issues")
    fun getOkHttpIssues(): Call<ArrayList<IssuesDataResponse>>

    @GET("repos/square/okhttp/issues/{id}/comments")
    fun getIssuesComment(@Path(value = "id", encoded = true) id : Int): Call<java.util.ArrayList<CommentsDataResponse?>>
}