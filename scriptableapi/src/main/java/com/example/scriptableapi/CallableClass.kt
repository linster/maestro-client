package com.example.scriptableapi

import kotlin.reflect.full.findAnnotation


@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class JsCallable(
    val name : String
)

fun Any.getJsCallableName() : String? = this::class.findAnnotation<JsCallable>()?.name


//We also need a @RequiresActivityContext to indicate that the thing using this should start an activity
//Notably, background activity starts are allowed from DPCs in DeviceOwner mode.
//TODO when an activity context is required, we could opt to make an invisible activity, or one with a solid color
//TODO background. This should be configurable from the interpeter

//TODO any class that is marked
/** Any class marked with this indicates that when it's methods are called, and if the method requires a Context,
 *  an Activity should be started first, and that context should be proxied to the requested function call. (By means
 *  of patching a delegate before attaching to Duktape).
 *
 *  //TODO write delegating proxy activity context provider.
 *
 *
 */
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class RequiresActivityContext

fun Any.requiresActivityContext() : Boolean = this::class.findAnnotation<RequiresActivityContext>()?.let { true } ?: false