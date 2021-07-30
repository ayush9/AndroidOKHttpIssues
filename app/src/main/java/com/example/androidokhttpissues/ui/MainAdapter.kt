package com.example.androidokhttpissues.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidokhttpissues.R
import com.example.androidokhttpissues.objects.IssuesDataResponse

class MainAdapter(private var items: ArrayList<IssuesDataResponse?>) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.issues_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(items[position]!!)

    override fun getItemCount() = items.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var poster: ImageView
        lateinit var title: TextView
        lateinit var releaseDate: TextView
        lateinit var userName: TextView
        lateinit var mainContainer: ConstraintLayout
        lateinit var description: TextView

        fun bind(item: IssuesDataResponse) = with(itemView) {
            poster = itemView.findViewById(R.id.poster)
            Glide.with(context.applicationContext).load(item.user.avatar_url).into(poster)

            title = itemView.findViewById(R.id.title)
            title.text = item.title

            releaseDate = itemView.findViewById(R.id.releaseDate)
            releaseDate.text = item.updated_at

            userName = itemView.findViewById(R.id.userName)
            userName.text = "User Name: " + item.user.login

            description = itemView.findViewById(R.id.description)
            if (item.labels.isNotEmpty()) {
                description.text = item.labels[0]?.description
            }

            mainContainer = itemView.findViewById(R.id.main_container)
            mainContainer.setOnClickListener {
//                val intent = Intent(context, IssueDetailsActivity::class.java)
//                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                context.startActivity(intent)
            }
        }
    }
}
