package ca.stefanm.maestro.scriptableApiImpl.ui

import android.content.Context
import android.widget.Toast
import com.example.scriptableapi.ui.SToast
import javax.inject.Inject

class SToastImpl @Inject constructor(
    private val applicationContext: Context
) : SToast {

    override fun showLongToast(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
    }

    override fun showShortToast(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }
}