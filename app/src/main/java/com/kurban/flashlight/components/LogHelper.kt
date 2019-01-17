package com.kurban.flashlight.components

import android.content.Context
import android.util.Log
import android.widget.Toast

class LogHelper(private val context: Context) {

    fun toast(msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

    fun mLog(msg: String) {
        Log.d("RKRK", msg)
    }
}
