package com.kurban.flashlight.di

import android.content.Context
import com.kurban.flashlight.components.FlashHelper

import com.kurban.flashlight.components.LogHelper

class DependencyInjectorImpl(private val context: Context) : DependencyInjector {

    override fun logHelper(): LogHelper {
        return LogHelper(context)
    }

    override fun flashHelper(): FlashHelper {
        return FlashHelper(context)
    }
}
