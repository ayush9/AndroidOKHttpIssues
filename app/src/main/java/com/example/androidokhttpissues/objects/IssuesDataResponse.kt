package com.example.androidokhttpissues.objects

import com.google.gson.annotations.SerializedName

data class IssuesDataResponse (
    @SerializedName("url") val url : String,
    @SerializedName("repository_url") val repository_url : String,
    @SerializedName("labels_url") val labels_url : String,
    @SerializedName("comments_url") val comments_url : String,
    @SerializedName("events_url") val events_url : String,
    @SerializedName("html_url") val html_url : String,
    @SerializedName("id") val id : Int,
    @SerializedName("node_id") val node_id : String,
    @SerializedName("number") val number : Int,
    @SerializedName("title") val title : String,
    @SerializedName("user") val user : User,
    @SerializedName("labels") val labels : List<Labels?>,
    @SerializedName("state") val state : String,
    @SerializedName("locked") val locked : Boolean,
    @SerializedName("assignee") val assignee : String,
    @SerializedName("assignees") val assignees : List<String>,
    @SerializedName("milestone") val milestone : Milestone?,
    @SerializedName("comments") val comments : Int,
    @SerializedName("created_at") val created_at : String,
    @SerializedName("updated_at") val updated_at : String,
    @SerializedName("closed_at") val closed_at : String,
    @SerializedName("author_association") val author_association : String,
    @SerializedName("active_lock_reason") val active_lock_reason : String,
    @SerializedName("pull_request") val pull_request : Pull_request,
    @SerializedName("body") val body : String,
    @SerializedName("performed_via_github_app") val performed_via_github_app : String
)

data class Labels (
    @SerializedName("id") val id : Double,
    @SerializedName("node_id") val node_id : String,
    @SerializedName("url") val url : String,
    @SerializedName("name") val name : String,
    @SerializedName("color") val color : String,
    @SerializedName("default") val default : Boolean,
    @SerializedName("description") val description : String
)

data class Pull_request (
    @SerializedName("url") val url : String,
    @SerializedName("html_url") val html_url : String,
    @SerializedName("diff_url") val diff_url : String,
    @SerializedName("patch_url") val patch_url : String
)

data class User (
    @SerializedName("login") val login : String,
    @SerializedName("id") val id : Int,
    @SerializedName("node_id") val node_id : String,
    @SerializedName("avatar_url") val avatar_url : String,
    @SerializedName("gravatar_id") val gravatar_id : String,
    @SerializedName("url") val url : String,
    @SerializedName("html_url") val html_url : String,
    @SerializedName("followers_url") val followers_url : String,
    @SerializedName("following_url") val following_url : String,
    @SerializedName("gists_url") val gists_url : String,
    @SerializedName("starred_url") val starred_url : String,
    @SerializedName("subscriptions_url") val subscriptions_url : String,
    @SerializedName("organizations_url") val organizations_url : String,
    @SerializedName("repos_url") val repos_url : String,
    @SerializedName("events_url") val events_url : String,
    @SerializedName("received_events_url") val received_events_url : String,
    @SerializedName("type") val type : String,
    @SerializedName("site_admin") val site_admin : Boolean
)

data class Milestone (
    @SerializedName("url") val url : String,
    @SerializedName("html_url") val html_url : String,
    @SerializedName("labels_url") val labels_url : String,
    @SerializedName("id") val id : Int,
    @SerializedName("node_id") val node_id : String,
    @SerializedName("number") val number : Int,
    @SerializedName("title") val title : String,
    @SerializedName("description") val description : String,
    @SerializedName("creator") val creator : Creator,
    @SerializedName("open_issues") val open_issues : Int,
    @SerializedName("closed_issues") val closed_issues : Int,
    @SerializedName("state") val state : String,
    @SerializedName("created_at") val created_at : String,
    @SerializedName("updated_at") val updated_at : String,
    @SerializedName("due_on") val due_on : String,
    @SerializedName("closed_at") val closed_at : String
)

data class Creator (
    @SerializedName("login") val login : String,
    @SerializedName("id") val id : Int,
    @SerializedName("node_id") val node_id : String,
    @SerializedName("avatar_url") val avatar_url : String,
    @SerializedName("gravatar_id") val gravatar_id : String,
    @SerializedName("url") val url : String,
    @SerializedName("html_url") val html_url : String,
    @SerializedName("followers_url") val followers_url : String,
    @SerializedName("following_url") val following_url : String,
    @SerializedName("gists_url") val gists_url : String,
    @SerializedName("starred_url") val starred_url : String,
    @SerializedName("subscriptions_url") val subscriptions_url : String,
    @SerializedName("organizations_url") val organizations_url : String,
    @SerializedName("repos_url") val repos_url : String,
    @SerializedName("events_url") val events_url : String,
    @SerializedName("received_events_url") val received_events_url : String,
    @SerializedName("type") val type : String,
    @SerializedName("site_admin") val site_admin : Boolean
)


