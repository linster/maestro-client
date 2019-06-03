package com.example.scriptingengine.hostService

import android.content.Context
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.squareup.duktape.Duktape
import javax.inject.Inject

class DukapeHost @Inject constructor(
    private val applicationContext : Context
) : LifecycleObserver {

    private lateinit var duktape : Duktape

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun startup() {
        duktape = Duktape.create()

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun shutdown() {
        duktape.close()
    }




}