package wa.xtext

import org.gradle.testfixtures.ProjectBuilder

import spock.lang.Specification

/**
 * @auther Aaron R Miller<amiller@watheia.dev>
 */
class WaXtextPluginTest extends Specification {

    void must_registers_tasks() {
        given:
        def project = ProjectBuilder.builder().build()

        when:
        project.plugins.apply('wa.xtext')

        then:
        project.tasks.findByName('generateXtext') != null
    }

}
