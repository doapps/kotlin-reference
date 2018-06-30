package me.doapps.androidprojectguide.adapter

import android.app.Activity
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import me.doapps.androidprojectguide.R
import me.doapps.androidprojectguide.activity.ListConnectionActivity

class CategoryAdapter constructor(private val activity: Activity, private val listTitle: MutableList<String>)
    : RecyclerView.Adapter<CategoryAdapter.CategoryHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryHolder {
        return CategoryHolder(LayoutInflater.from(activity).inflate(R.layout.item_category, parent, false))
    }

    override fun getItemCount(): Int {
        return listTitle.size
    }

    override fun onBindViewHolder(holder: CategoryHolder, position: Int) {
        holder.categoryButton.text = listTitle[position]

        holder.categoryButton.setOnClickListener({
            activity.startActivity(activitySelect(position))
        })
    }

    class CategoryHolder(view: View) : RecyclerView.ViewHolder(view) {
        val categoryButton: Button = view.findViewById(R.id.category_button)
    }

    private fun activitySelect(position: Int): Intent {
        return when (position) {
            0 -> {
                Intent(activity, ListConnectionActivity::class.java)
            }
            1 -> {
                Intent(activity, ListConnectionActivity::class.java)
            }
            2 -> {
                Intent(activity, ListConnectionActivity::class.java)
            }
            else -> {
                Intent(activity, ListConnectionActivity::class.java)
            }
        }
    }
}