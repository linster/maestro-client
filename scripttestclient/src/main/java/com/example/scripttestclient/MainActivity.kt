package com.example.scripttestclient

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ContextCompat.startForegroundService(this, Intent(this, InterpreterHostService::class.java))

        btn_rerun_test.setOnClickListener {
            rerunTestScripts()
        }
    }


    private fun rerunTestScripts() {
        sendBroadcast(Intent(InterpreterHostService.rerunTestScriptAction))
    }
}
