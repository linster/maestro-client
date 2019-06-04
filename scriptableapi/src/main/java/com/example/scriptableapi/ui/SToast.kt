package com.example.scriptableapi.ui

import com.example.scriptableapi.JsCallable

@JsCallable(name = "Toast")
interface SToast {
    fun showShortToast(message : String)
    fun showLongToast(message : String)
}
