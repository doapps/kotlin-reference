package me.doapps.androidprojectguide.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_list_connection.*
import me.doapps.androidprojectguide.R
import me.doapps.androidprojectguide.adapter.AlbumAdapter
import me.doapps.androidprojectguide.controller.ViewController
import me.doapps.androidprojectguide.dialog.WarningDialog
import me.doapps.androidprojectguide.model.Album
import me.doapps.androidprojectguide.presenter.ListConnectionPresenter

class ListConnectionActivity : AppCompatActivity(), ViewController.ViewListConnection {

    private lateinit var listConnectionPresenter: ListConnectionPresenter
    private lateinit var albumAdapter: AlbumAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var warningDialog: WarningDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_connection)

        view()
    }

    private fun view() {

        listConnectionPresenter = ListConnectionPresenter(this)

        linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL

        listConnectionPresenter.listAlbum()
    }

    override fun listAlbum(albums: MutableList<Album>) {
        albumAdapter = AlbumAdapter(this, albums)

        albumRecycler.layoutManager = linearLayoutManager
        albumRecycler.adapter = albumAdapter
    }

    override fun messageError(message: String) {
        warningDialog = WarningDialog(this, message)
        warningDialog.show()

        warningDialog.setOnclickAccept(object : WarningDialog.Accept {
            override fun acceptOption() {
                warningDialog.cancel()
                listConnectionPresenter.listAlbum()
            }
        })
    }
}