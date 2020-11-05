/*
 * This Groovy source file was generated by the Gradle 'init' task.
 */
package wa.docker

import org.gradle.testfixtures.ProjectBuilder

import spock.lang.Specification

/**
 * A simple unit test for the 'wa.gradle.eclipse.greeting' plugin.
 */
class WaDockerPluginTest extends Specification {

    void plugin_registers_tasks() {
        given:
        def project = ProjectBuilder.builder().build()

        when:
        project.plugins.apply('wa.docker')

        then:
        project.tasks.findByName('dockerTag') != null
        project.tasks.findByName('dockerPush') != null
    }

}