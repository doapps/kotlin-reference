package me.doapps.androidprojectguide.adapter

import android.content.Context
import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_category.view.*
import me.doapps.androidprojectguide.R
import me.doapps.androidprojectguide.activity.ListConnectionActivity

class CategoryAdapter : RecyclerView.Adapter<CategoryAdapter.CategoryHolder>() {

    lateinit var list: MutableList<String>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryHolder {
        return CategoryHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent,
                false))
    }

    override fun getItemCount(): Int {
        return if (::list.isInitialized) list.size else 0
    }

    override fun onBindViewHolder(holder: CategoryHolder, position: Int) {
        holder.itemView.categoryButton.text = list[position]
        holder.itemView.categoryButton.setOnClickListener {
            holder.itemView.context.startActivity(activitySelect(holder.itemView.context, position))
        }
    }

    class CategoryHolder(view: View) : RecyclerView.ViewHolder(view)

    private fun activitySelect(context: Context, position: Int): Intent {
        return when (position) {
            0 -> {
                Intent(context, ListConnectionActivity::class.java)
            }
            1 -> {
                Intent(context, ListConnectionActivity::class.java)
            }
            2 -> {
                Intent(context, ListConnectionActivity::class.java)
            }
            else -> {
                Intent(context, ListConnectionActivity::class.java)
            }
        }
    }
}