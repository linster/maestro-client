package com.example.scripttestclient.exposedScriptApis

import android.app.AlertDialog
import android.content.Context
import android.widget.Toast


interface ScriptableToastApi {
    fun showShortToast(message : String)
}

class ScriptableToast(
    private val applicationContext : Context
) : ScriptableToastApi{

    val jsApiName = "ScriptableToast"

    override fun showShortToast(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }

}