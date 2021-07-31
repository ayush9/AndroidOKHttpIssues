package com.example.androidokhttpissues.repo

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.androidokhttpissues.OpenForTesting
import com.example.androidokhttpissues.objects.CommentsDataResponse
import com.example.androidokhttpissues.objects.IssuesDataResponse
import com.example.androidokhttpissues.repo.RetrofitClientInstance.retrofitInstance
import com.example.androidokhttpissues.utils.NetworkUtil
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONException
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException
import java.io.InputStream
import java.lang.reflect.Type
import java.nio.charset.Charset
import java.util.*

@OpenForTesting
open class MainRepository {

    private lateinit var issuesData: MutableLiveData<ArrayList<IssuesDataResponse>>
    private var commentsData: MutableLiveData<ArrayList<CommentsDataResponse?>>? = null

    open fun getIssuesData(): LiveData<ArrayList<IssuesDataResponse>> {
        if (this::issuesData.isInitialized) {
            return issuesData
        } else {
            issuesData = MutableLiveData()
        }
        return issuesData
    }

    fun getCommentsData(): LiveData<ArrayList<CommentsDataResponse?>> {
        if (commentsData == null) {
            commentsData = MutableLiveData()
        }
        return commentsData as MutableLiveData<ArrayList<CommentsDataResponse?>>
    }

    fun fetchIssues(applicationContext: Context) {
        if (!NetworkUtil.isNetworkAvailable(applicationContext)) {
            loadDataFromLocalAssetsFile(applicationContext)
        } else {
            val service =
                retrofitInstance!!.create(
                    GetDataService::class.java
                )
            val call: Call<ArrayList<IssuesDataResponse>> = service.getOkHttpIssues()
            call.enqueue(object : Callback<ArrayList<IssuesDataResponse>> {
                override fun onResponse(
                    call: Call<ArrayList<IssuesDataResponse>>,
                    response: Response<ArrayList<IssuesDataResponse>>
                ) {
                    if (::issuesData.isInitialized) {
                        issuesData.postValue(response.body())
                    } else {
                        Log.d("error: ","SOMETHING WENT WRONG")
                    }
                }

                override fun onFailure(
                    call: Call<ArrayList<IssuesDataResponse>>,
                    t: Throwable?
                ) {
                    loadDataFromLocalAssetsFile(applicationContext)
                }
            })
        }
    }

    private fun loadDataFromLocalAssetsFile(applicationContext: Context) {
        try {
            val fileData = loadJSONFromAsset(applicationContext)!!

            val gson = Gson()
            val listType: Type = object : TypeToken<List<IssuesDataResponse?>?>() {}.type
            val posts: List<IssuesDataResponse> = gson.fromJson(fileData, listType)
            issuesData.postValue(posts as ArrayList<IssuesDataResponse>?)
        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }

    private fun loadJSONFromAsset(applicationContext: Context): String? {
        var json: String? = null
        json = try {
            val `is`: InputStream = applicationContext.assets.open("issue_details.json")
            val size: Int = `is`.available()
            val buffer = ByteArray(size)
            `is`.read(buffer)
            `is`.close()
            val charset: Charset = Charsets.UTF_8
            String(buffer, charset)
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
        return json
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
