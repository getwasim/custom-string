import org.clean.string.CustomStringFunctions

class CustomStringBootStrap {

    def init = { servletContext ->
        println "Class initialized... "
        CustomStringFunctions.inject()
    }
    def destroy = {
    }
}