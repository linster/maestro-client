package com.example.scriptableapi.ui

import com.example.scriptableapi.RequiresActivityContext

@RequiresActivityContext
interface SAlertDialog {

    //TODO The trick here is how to specify a function that can be called as an onclick listener for any buttons added
    //TODO here. I guess the user could pass a string for an eventhandler dict, but that's dumb
    //TODO what if the user just passes in the js they want to be called as a string? That pushes more crap to the
    //TODO user and adds another layer of evals(). However, since we're not building a general-purpose UI framework,
    //TODO it's probably okay.


    fun showAlertDialog(
        title : String,
        contents : String,

        showPositiveButton : Boolean,
        positiveButtonLabel : String,
        positiveButtonEval : String,

        showNeutralButton : Boolean,
        neutralButtonLabel : String,
        neutralButtonEval : String,

        showNegativeButton : Boolean,
        negativeButtonLabel : String,
        negativeButtonEval : String,

        cancellable : Boolean
    )
}