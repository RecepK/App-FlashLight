package com.kurban.flashlight.components

import android.content.Context
import android.content.pm.PackageManager
import android.hardware.camera2.CameraAccessException
import android.hardware.camera2.CameraManager
import android.os.Build

class FlashHelper(context: Context) {

    private val cameraManager: CameraManager
    private var cameraID = ""

    init {
        context.packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH)
        cameraManager = context.getSystemService(Context.CAMERA_SERVICE) as CameraManager

        try {
            cameraID = cameraManager.cameraIdList[0]
        } catch (e: CameraAccessException) {
            e.printStackTrace()
        }

    }

    fun flashControl(value: Boolean) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            try {
                cameraManager.setTorchMode(cameraID, value)
            } catch (e: CameraAccessException) {
                e.printStackTrace()
            }
        }
    }
}
