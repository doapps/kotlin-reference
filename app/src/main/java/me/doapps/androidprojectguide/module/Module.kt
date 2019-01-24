package me.doapps.androidprojectguide.module

import android.app.Activity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import me.doapps.androidprojectguide.adapter.AlbumAdapter
import me.doapps.androidprojectguide.adapter.CategoryAdapter
import me.doapps.androidprojectguide.controller.HomeController
import me.doapps.androidprojectguide.controller.ListConnectionController
import me.doapps.androidprojectguide.controller.LoginController
import me.doapps.androidprojectguide.controller.SplashController
import me.doapps.androidprojectguide.dialog.WarningDialog
import me.doapps.androidprojectguide.presenter.HomePresenter
import me.doapps.androidprojectguide.presenter.ListConnectionPresenter
import me.doapps.androidprojectguide.presenter.LoginPresenter
import me.doapps.androidprojectguide.presenter.SplashPresenter
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module

val layoutManagerModule = module {
    factory { LinearLayoutManager(androidContext()) }
    factory { (spanCount: Int) -> GridLayoutManager(androidContext(), spanCount) }
}

val splashModule = module {
    factory { (controller: SplashController) -> SplashPresenter(controller, androidContext()) }
}

val homeModule = module {
    factory { (controller: HomeController) -> HomePresenter(controller) }
    factory { CategoryAdapter() }

}

val loginModule = module {
    factory { (controller: LoginController) -> LoginPresenter(controller, androidContext()) }
}

val listConnectionModule = module {
    factory { (controller: ListConnectionController) -> ListConnectionPresenter(controller) }
    factory { AlbumAdapter() }
    factory { (activity: Activity) ->WarningDialog(activity) }
}