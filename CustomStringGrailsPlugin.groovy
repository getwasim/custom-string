import org.clean.string.CustomStringFunctions

class CustomStringGrailsPlugin {
    def version = "0.2"
    def grailsVersion = "1.3.7 > *"
    def author = "Wasim Akhtar Khan"
    def authorEmail = "wasim.get@gmail.com"
    def title = "CustomString plugin"
    def description = 'This plugin adds a few custom methods to the String class'
    def documentation = "http://grails.org/plugin/custom-string"
    def license = 'APACHE'
    def issueManagement = [url: 'https://github.com/getwasim/CustomString/issues']
    def scm = [url: 'https://github.com/getwasim/CustomString']

    def doWithDynamicMethods = { ctx ->
        println "String cleaning method initialized... "
        CustomStringFunctions.inject()
    }
}
