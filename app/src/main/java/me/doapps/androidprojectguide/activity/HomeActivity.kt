package me.doapps.androidprojectguide.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_home.*
import me.doapps.androidprojectguide.R
import me.doapps.androidprojectguide.adapter.CategoryAdapter
import me.doapps.androidprojectguide.controller.HomeController
import me.doapps.androidprojectguide.presenter.HomePresenter
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class HomeActivity : AppCompatActivity(), HomeController {

    private val homePresenter: HomePresenter by inject { parametersOf(this) }
    private val categoryAdapter: CategoryAdapter by inject()
    private val gridLayoutManager: GridLayoutManager by inject { parametersOf(2) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        viewHolder()
    }

    private fun viewHolder() {
        categoryRecycler.layoutManager = gridLayoutManager
        categoryRecycler.adapter = categoryAdapter
        homePresenter.listCategory(this)
    }

    override fun listCategory(listString: MutableList<String>) {
        categoryAdapter.list = listString
        categoryAdapter.notifyDataSetChanged()
    }
}