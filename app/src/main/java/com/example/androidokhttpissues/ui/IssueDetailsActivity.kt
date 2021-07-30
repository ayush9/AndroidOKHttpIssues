package com.example.androidokhttpissues.ui

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidokhttpissues.R
import com.example.androidokhttpissues.viewmodel.MainViewModel

class IssueDetailsActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by lazy {
        getViewModelProvider(this, null).get(
            MainViewModel::class.java
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        mainViewModel.fetchIssueCommentsData(intent.extras!!.getInt("number"))

        mainViewModel.commentsReponseStatus.observe(this, {
            if(it != null && it.isNotEmpty()) {
                val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewComments)
                val mainAdapter = CommentsAdapter(it)
                recyclerView.setHasFixedSize(true)
                recyclerView.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
                recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                recyclerView.adapter = mainAdapter
                recyclerView.visibility = View.VISIBLE
                findViewById<TextView>(R.id.no_comments).visibility = View.GONE
            } else {
                Toast.makeText(this, "NO COMMENTS", Toast.LENGTH_LONG).show()
                findViewById<TextView>(R.id.no_comments).visibility = View.VISIBLE
            }
        })
    }

    private fun getViewModelProvider(
        fragment: IssueDetailsActivity,
        factory: ViewModelProvider.Factory?
    ): ViewModelProvider {
        return ViewModelProviders.of(fragment, factory)
    }

}
