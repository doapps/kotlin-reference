package me.doapps.androidprojectguide.adapter

import android.app.Activity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_album.view.*
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
        holder.itemView.userIdText.text = listAlbum[position].userId.toString()
        holder.itemView.idText.text = listAlbum[position].id.toString()
        holder.itemView.titleText.text = listAlbum[position].title
    }

    class AlbumHolder(view: View) : RecyclerView.ViewHolder(view)
}