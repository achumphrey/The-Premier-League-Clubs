package com.example.thepremierleagueclubs.presenter.clubdetailspresenter

import androidx.annotation.CallSuper

abstract class ClubsDetailsBasePresenter<T : ClubsDetailsBasePresenter.View> {

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