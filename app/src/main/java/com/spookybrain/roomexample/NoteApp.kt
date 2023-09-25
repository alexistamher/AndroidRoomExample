package com.spookybrain.roomexample

import android.app.Application

class NoteApp : Application() {
    override fun onCreate() {
        super.onCreate()
        DatabaseFactory.instance.setContext(this)
    }
}