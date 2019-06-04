package ca.stefanm.maestro.scriptableApiImpl.ui.delegation


//I need a way to convert a class with the RequiresActivityContext annotation to intercept every method call made
//on that class, and launch an activity first, get the context of that activity, construct the required type (via dagger
// or via a factory), then call the method that was requested.
class ActivityContextDelegator {

    operator fun invoke() {

    }

}

fun wat() {
    ActivityContextDelegator()()
}