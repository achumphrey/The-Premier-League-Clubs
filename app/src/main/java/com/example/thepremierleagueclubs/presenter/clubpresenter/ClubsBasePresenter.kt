package com.example.thepremierleagueclubs.presenter.clubpresenter

import androidx.annotation.CallSuper


abstract class ClubsBasePresenter<T : ClubsBasePresenter.View> {

    var view: T? = null

    @CallSuper
    open fun onViewAttached(view: T) {
        if (this.view != null) {
            throw IllegalStateException("View is already attached!")
        } else {
            this.view = view
        }
    }

    interface View
}