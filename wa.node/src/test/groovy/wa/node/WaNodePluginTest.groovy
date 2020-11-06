/*
 * This Groovy source file was generated by the Gradle 'init' task.
 */
package wa.node

import org.gradle.testfixtures.ProjectBuilder

import spock.lang.Specification

/**
 * A simple unit test for the 'wa.gradle.eclipse.greeting' plugin.
 */
class WaNodePluginTest extends Specification {

    void plugin_registers_tasks() {
        given:
        def project = ProjectBuilder.builder().build()

        when:
        project.plugins.apply('wa.node')

        then:
        project.tasks.findByName('npmInstall') != null
        project.tasks.findByName('npmBuild') != null
        project.tasks.findByName('yarnBuild') != null
    }

}
