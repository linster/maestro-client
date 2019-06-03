package com.example.scripttestclient

import android.app.*
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import androidx.core.app.NotificationCompat
import com.example.scripttestclient.exposedScriptApis.ScriptableToast
import com.example.scripttestclient.exposedScriptApis.ScriptableToastApi
import com.squareup.duktape.Duktape

class InterpreterHostService : Service() {

    override fun onBind(intent: Intent) = null

    private lateinit var duktape : Duktape

    override fun onCreate() {
        startForeground(1, setupForegroundNotification())

        duktape = Duktape.create()

        registerReceiver(stopServiceReceiver, IntentFilter(stopServiceAction))
        registerReceiver(rerunTestScriptReceiver, IntentFilter(rerunTestScriptAction))

        registerTest()
        runTest()
    }

    override fun onDestroy() {
        super.onDestroy()
        duktape.close()
        unregisterReceiver(stopServiceReceiver)
        unregisterReceiver(rerunTestScriptReceiver)
    }

    private val stopServiceReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            this@InterpreterHostService.stopSelf()
        }
    }

    private val rerunTestScriptReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            runTest()
        }
    }


    private fun setupForegroundNotification() : Notification{
        //Create channel
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val channelId = "testInterpreter"
        if (Build.VERSION.SDK_INT >= 26) {
            notificationManager.createNotificationChannel(
                NotificationChannel(channelId, "Runs the Interpreter", NotificationManager.IMPORTANCE_HIGH)
            )
        }

        return NotificationCompat.Builder(this, channelId)
            .setContentTitle("Duktape Running")
            .setContentText("Running IPL")
            .addAction(0, "Stop Service", getStopServicePendingIntent(this))
            .build()
    }

    private fun registerTest() {

        val scriptableToastApi = ScriptableToast(this.applicationContext)
        duktape.set(scriptableToastApi.jsApiName, ScriptableToastApi::class.java, scriptableToastApi)
    }

    private fun runTest() {
        val script = """

            ScriptableToast.showShortToast("Hello, World! From Duktape!!!");

        """.trimIndent()

        duktape.evaluate(script)
    }



    companion object {

        private val stopServiceAction = "stopInterpreter"

        private fun getStopServicePendingIntent(context : Context) : PendingIntent {
            return PendingIntent.getBroadcast(context, 0, Intent(stopServiceAction), PendingIntent.FLAG_UPDATE_CURRENT)
        }

        const val rerunTestScriptAction = "reRunTestScript"
    }
}
