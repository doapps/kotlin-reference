package me.doapps.androidprojectguide.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import me.doapps.androidprojectguide.R
import me.doapps.androidprojectguide.adapter.CategoryAdapter
import me.doapps.androidprojectguide.controller.ViewController
import me.doapps.androidprojectguide.presenter.HomePresenter

class HomeActivity : AppCompatActivity(), ViewController.ViewHome {

    @BindView(R.id.category_recycler)
    lateinit var categoryRecycler: RecyclerView

    private lateinit var homePresenter: HomePresenter
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        viewHolder()
    }

    private fun viewHolder() {
        ButterKnife.bind(this)

        homePresenter = HomePresenter(this)

        linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL

        homePresenter.listCategory(this)
    }

    override fun listCategory(listString: MutableList<String>) {
        categoryAdapter = CategoryAdapter(this, listString)

        categoryRecycler.layoutManager = GridLayoutManager(this, 2)
        categoryRecycler.adapter = categoryAdapter
    }
}