package com.kurban.flashlight.mvp

interface MainContract {

    interface MvpView {
        fun initUI()

        fun tik(value: Boolean);
    }

    interface Presenter {
        fun init(): MainPresenter

        fun handleTik()

        fun toast(msg: String)

        fun control(value: Boolean)
    }
}