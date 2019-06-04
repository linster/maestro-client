package ca.stefanm.maestro.scriptableApiImpl.ui

import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog
import com.example.scriptableapi.ui.SAlertDialog

class SAlertDialogImpl(
    private val activityContext : Context //transient to it's holder
) : SAlertDialog {

    override fun showAlertDialog(
        title: String,
        contents: String,
        showPositiveButton: Boolean,
        positiveButtonLabel: String,
        positiveButtonEval: String,
        showNeutralButton: Boolean,
        neutralButtonLabel: String,
        neutralButtonEval: String,
        showNegativeButton: Boolean,
        negativeButtonLabel: String,
        negativeButtonEval: String,
        cancellable: Boolean
    ) {
        AlertDialog.Builder(activityContext)
            .setTitle(title)
            .setMessage(contents)
            .apply {
                if (showPositiveButton) {
                    setPositiveButton(positiveButtonLabel, evalButtonOnclickListener(positiveButtonEval))
                }
                if (showNeutralButton) {
                    setNeutralButton(neutralButtonLabel, evalButtonOnclickListener(neutralButtonEval))
                }
                if (showNegativeButton) {
                    setNegativeButton(negativeButtonEval, evalButtonOnclickListener(negativeButtonEval))
                }
            }
            .setCancelable(cancellable)
            .create()
            .show()
    }


    private fun evalButtonOnclickListener(toEval : String) : DialogInterface.OnClickListener {
        return DialogInterface.OnClickListener { dialog, which -> }
    }

}