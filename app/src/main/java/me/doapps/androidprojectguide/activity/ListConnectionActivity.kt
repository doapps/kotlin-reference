package me.doapps.androidprojectguide.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_list_connection.*
import me.doapps.androidprojectguide.R
import me.doapps.androidprojectguide.adapter.AlbumAdapter
import me.doapps.androidprojectguide.controller.ListConnectionController
import me.doapps.androidprojectguide.dialog.WarningDialog
import me.doapps.androidprojectguide.model.Album
import me.doapps.androidprojectguide.presenter.ListConnectionPresenter
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class ListConnectionActivity : AppCompatActivity(), ListConnectionController {

    private val listConnectionPresenter: ListConnectionPresenter by inject { parametersOf(this) }
    private val albumAdapter: AlbumAdapter by inject()
    private val linearLayoutManager: LinearLayoutManager by inject()
    private val warningDialog: WarningDialog by inject { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_connection)
        view()
    }

    private fun view() {
        albumRecycler.layoutManager = linearLayoutManager
        albumRecycler.adapter = albumAdapter
        listConnectionPresenter.listAlbum()
    }

    override fun listAlbum(albums: MutableList<Album>) {
        albumAdapter.listAlbum = albums
        albumAdapter.notifyDataSetChanged()
    }

    override fun messageError(message: String) {
        warningDialog.message = message
        warningDialog.show()

        warningDialog.setOnclickAccept(object : WarningDialog.Accept {
            override fun acceptOption() {
                warningDialog.cancel()
                listConnectionPresenter.listAlbum()
            }
        })
    }
}