package me.doapps.androidprojectguide.adapter

import android.app.Activity
import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_category.view.*
import me.doapps.androidprojectguide.R
import me.doapps.androidprojectguide.activity.ListConnectionActivity

class CategoryAdapter constructor(private val activity: Activity,
                                  private val listTitle: MutableList<String>) :
        RecyclerView.Adapter<CategoryAdapter.CategoryHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryHolder {
        return CategoryHolder(LayoutInflater.from(activity).inflate(R.layout.item_category, parent,
                false))
    }

    override fun getItemCount(): Int {
        return listTitle.size
    }

    override fun onBindViewHolder(holder: CategoryHolder, position: Int) {
        holder.itemView.categoryButton.text = listTitle[position]
        holder.itemView.categoryButton.setOnClickListener({
            activity.startActivity(activitySelect(position))
        })
    }

    class CategoryHolder(view: View) : RecyclerView.ViewHolder(view)

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