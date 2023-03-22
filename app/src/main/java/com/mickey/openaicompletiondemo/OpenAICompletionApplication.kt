package com.mickey.openaicompletiondemo

import android.app.Application
import com.mickey.openaicompletiondemo.data.AppContainer
import com.mickey.openaicompletiondemo.data.DefaultAppContainer

class OpenAICompletionApplication: Application() {
    /** AppContainer instance used by the rest of classes to obtain dependencies */
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}