/*
 * This Groovy source file was generated by the Gradle 'init' task.
 */
package gradle.plugin

import org.gradle.testkit.runner.GradleRunner
import org.gradle.testkit.runner.TaskOutcome

import spock.lang.Specification

/**
 * A simple functional test for the 'gradle.plugin.greeting' plugin.
 */
class BasePluginFunctionalTest extends Specification {

    void may_run_build_task() {
        given:
        def projectDir = new File('build/functionalTest/base')
        projectDir.mkdirs()

        when:
        def runner = GradleRunner.create()
        runner.forwardOutput()
        runner.withPluginClasspath()
        runner.withArguments('build')
        runner.withProjectDir(projectDir)
        def result = runner.build()

        then:
        result.task(':build').outcome != TaskOutcome.FAILED
    }

}
