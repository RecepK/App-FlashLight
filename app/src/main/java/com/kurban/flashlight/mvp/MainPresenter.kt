package com.kurban.flashlight.mvp

import android.content.Context
import android.content.pm.PackageManager
import android.hardware.camera2.CameraManager
import android.os.Build
import com.kurban.flashlight.components.LogHelper
import com.kurban.flashlight.di.DependencyInjector
import com.kurban.flashlight.ui.MainActivity

class MainPresenter(private val view: MainContract.MvpView, var dependencyInjector: DependencyInjector) : MainContract.Presenter {

    private lateinit var context: Context
    private var isTouchOn = false

    private lateinit var cameraManager: CameraManager
    private lateinit var cameraID: String

    private lateinit var logHelper: LogHelper

    override fun init(): MainPresenter {
        context = view as MainActivity
        logHelper = dependencyInjector.logHelper()

        context.packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH)
        cameraManager = context.getSystemService(Context.CAMERA_SERVICE) as CameraManager;
        cameraID = cameraManager.cameraIdList[0]

        view.initUI()
        return this
    }

    override fun handleTik() {
        isTouchOn = notValue(isTouchOn)
        view.tik(isTouchOn)
    }

    override fun toast(msg: String) {
        logHelper.toast(msg)
    }

    override fun control(value: Boolean) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            cameraManager.setTorchMode(cameraID, value)
        }
    }

    private fun notValue(value: Boolean) = !value

}