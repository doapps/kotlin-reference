package me.doapps.androidprojectguide.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_album.view.*
import me.doapps.androidprojectguide.R
import me.doapps.androidprojectguide.model.Album

class AlbumAdapter : RecyclerView.Adapter<AlbumAdapter.AlbumHolder>() {

    lateinit var listAlbum: MutableList<Album>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumHolder {
        return AlbumHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_album, parent, false))
    }

    override fun getItemCount(): Int {
        return if (::listAlbum.isInitialized) listAlbum.size else 0
    }

    override fun onBindViewHolder(holder: AlbumHolder, position: Int) {
        holder.itemView.userIdText.text = listAlbum[position].userId.toString()
        holder.itemView.idText.text = listAlbum[position].id.toString()
        holder.itemView.titleText.text = listAlbum[position].title
    }

    class AlbumHolder(view: View) : RecyclerView.ViewHolder(view)
}