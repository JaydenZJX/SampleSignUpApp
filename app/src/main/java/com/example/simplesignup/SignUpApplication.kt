package com.example.simplesignup

import android.app.Application
import com.example.simplesignup.viewModel.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin

class SignUpApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@SignUpApplication)
            loadKoinModules(listOf(viewModelModule))
        }
    }
}