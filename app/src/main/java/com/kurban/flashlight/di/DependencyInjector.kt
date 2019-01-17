package com.kurban.flashlight.di

import com.kurban.flashlight.components.LogHelper

interface DependencyInjector {

    fun logHelper(): LogHelper
}
