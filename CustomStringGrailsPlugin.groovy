import org.clean.string.FixChar

class CustomStringGrailsPlugin {
    def version = "0.1"
    def grailsVersion = "2.2 > *"
    def author = "Wasim Akhtar Khan"
    def authorEmail = "wasim.get@gmail.com"
    def title = "CustomString plugin"
    def description = 'This plugin adds a few custom methods to the String class'
    def documentation = "http://grails.org/plugin/custom-string"
    def license = 'APACHE'
    def issueManagement = [url: 'https://github.com/getwasim/CustomString/issues']
    def scm = [url: 'https://github.com/getwasim/CustomString']

    def doWithDynamicMethods = { ctx ->

        println "Class initialized... "

        String.metaClass.trunc = { int len ->
            if (len < delegate.length()) {
                delegate[0..len - 1]
            } else {
                delegate
            }
        }

        String.metaClass.ellipsis = { int len ->
            if (len < delegate.length()) {
                delegate[0..len - (ELLIPSIS.size() + 1)] + ELLIPSIS
            } else {
                delegate
            }
        }

        String.metaClass.clean = { ->
            FixChar.removeSpecialCharacter(delegate)
        }
    }
}
