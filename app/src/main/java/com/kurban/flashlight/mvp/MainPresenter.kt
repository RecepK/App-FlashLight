package com.kurban.flashlight.mvp

import com.kurban.flashlight.components.FlashHelper
import com.kurban.flashlight.components.LogHelper
import com.kurban.flashlight.di.DependencyInjector

class MainPresenter(private val view: MainContract.MvpView, var dependencyInjector: DependencyInjector) : MainContract.Presenter {

    private lateinit var logHelper: LogHelper
    private lateinit var flashHelper: FlashHelper
    private var isTouchOn = false

    override fun init(): MainPresenter {
        logHelper = dependencyInjector.logHelper()
        flashHelper = dependencyInjector.flashHelper()

        view.initUI()
        return this
    }

    private fun notValue(value: Boolean) = !value

    override fun handleTik() {
        isTouchOn = notValue(isTouchOn)
        view.tik(isTouchOn)
    }

    override fun toast(msg: String) {
        logHelper.toast(msg)
    }

    override fun control(value: Boolean) {
        flashHelper.flashControl(value)
    }
}