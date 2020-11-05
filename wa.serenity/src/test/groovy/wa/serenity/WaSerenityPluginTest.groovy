/*
 * This Groovy source file was generated by the Gradle 'init' task.
 */
package wa.serenity

import org.gradle.testfixtures.ProjectBuilder

import spock.lang.Specification

/**
 * @auther Aaron R Miller<amiller@watheia.dev>
 */
class WaSerenityPluginTest extends Specification {

    void plugin_registers_tasks() {
        given:
        def project = ProjectBuilder.builder().build()

        when:
        project.plugins.apply('wa.serenity')

        then:
        project.tasks.findByName('aggregate') != null
    }

}
