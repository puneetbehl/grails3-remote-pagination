package remote.pagination

import grails.plugins.*
import groovy.util.logging.Commons

@Commons
class RemotePaginationGrailsPlugin extends Plugin {

    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "3.0.1 > *"
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
        "grails-app/views/error.gsp"
    ]

    // TODO Fill in these fields
    def title = "Remote Pagination" // Headline display name of the plugin
    def author = "Puneet Behl"
    def authorEmail = "puneet.behl007@gmail.com"
    def description = '''\
Remote-Pagination plugin provides tags for pagination and to sort columns without page refresh, using ajax and loads only the list of objects needed. It supports multiple paginations as well. More than one remotePaginate, remotePageScroll, remoteNonStopPageScroll and remoteSortableColumn can be used on the same page unlike non-ajax pagination tags.
'''
    def profiles = ['web']

    // URL to the plugin's documentation
    def documentation = "http://grails.org/plugin/remote-pagination"

    // Extra (optional) plugin metadata

    // License: one of 'APACHE', 'GPL2', 'GPL3'
   def license = "APACHE"

    // Details of company behind the plugin (if there is one)
   def organization = [ name: "Intelligrape Softwares", url: "http://www.intelligrape.com/" ]

    // Any additional developers beyond the author specified above.
   def developers = [ [ name: "Puneet Behl", email: "puneet.behl@intelligrape.com" ],
                      [ name: "Amit Jain", email: "amitjain1982@gmail.com"]
    ]

    // Location of the plugin's issue tracker.
   def issueManagement = [ system: "github", url: "https://github.com/puneetbehl/remote-pagination/issues" ]

    // Online location of the plugin's browseable source code.
   def scm = [ url: "https://github.com/puneetbehl/remote-pagination.git" ]

   ConfigObject rpaginationConfig

    Closure doWithSpring() { {->
            rpaginationConfig = grailsApplication.config.grails.plugins.remotePagination
            if(!rpaginationConfig.max) {
                rpaginationConfig.max = 10
            }
            if(!rpaginationConfig.enableBootstrap) {
                rpaginationConfig.enableBootstrap = false
            }
        } 
    }

    void doWithDynamicMethods() {
        // TODO Implement registering dynamic methods to classes (optional)
    }

    void doWithApplicationContext() {
        // TODO Implement post initialization spring config (optional)
    }

    void onChange(Map<String, Object> event) {
        // TODO Implement code that is executed when any artefact that this plugin is
        // watching is modified and reloaded. The event contains: event.source,
        // event.application, event.manager, event.ctx, and event.plugin.
    }

    void onConfigChange(Map<String, Object> event) {
        // TODO Implement code that is executed when the project configuration changes.
        // The event is the same as for 'onChange'.
    }

    void onShutdown(Map<String, Object> event) {
        // TODO Implement code that is executed when the application shuts down (optional)
    }
}
