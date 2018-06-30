package me.doapps.androidprojectguide.adapter

import android.app.Activity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import me.doapps.androidprojectguide.R
import me.doapps.androidprojectguide.model.Album

class AlbumAdapter constructor(private val activity: Activity, private val listAlbum: MutableList<Album>)
    : RecyclerView.Adapter<AlbumAdapter.AlbumHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumHolder {
        return AlbumHolder(LayoutInflater.from(activity).inflate(R.layout.item_album, parent, false))
    }

    override fun getItemCount(): Int {
        return listAlbum.size
    }

    override fun onBindViewHolder(holder: AlbumHolder, position: Int) {
        holder.userIdText.text = listAlbum[position].userId.toString()
        holder.idText.text = listAlbum[position].id.toString()
        holder.titleText.text = listAlbum[position].title
    }

    class AlbumHolder(view: View) : RecyclerView.ViewHolder(view) {
        val userIdText: TextView = view.findViewById(R.id.user_id_text)
        val idText: TextView = view.findViewById(R.id.id_text)
        val titleText: TextView = view.findViewById(R.id.title_text)
    }
}