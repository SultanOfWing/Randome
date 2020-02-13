package com.seleznov.randome

import android.app.Application

class RandomApp : Application() {

    companion object {
        lateinit var app: RandomApp
    }

    override fun onCreate() {
        super.onCreate()
        app = this
    }
}