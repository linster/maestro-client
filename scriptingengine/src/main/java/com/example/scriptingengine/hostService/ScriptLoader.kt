package com.example.scriptingengine.hostService

import com.squareup.duktape.Duktape

abstract class ScriptLoader (
    private val duktape : Duktape
){

    /**
     * Called just after the interpreter loads. Use the provided interpreter to perform setup work.
     */
    abstract fun initialProgramEval(interpreter : Duktape)




}