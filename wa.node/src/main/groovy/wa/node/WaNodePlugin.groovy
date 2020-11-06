/*
 * This Groovy source file was generated by the Gradle 'init' task.
 */
package wa.node

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.Task

import com.github.gradle.node.npm.task.NpmTask

/**
 * A simple 'hello world' plugin.
 */
class WaNodePlugin implements Plugin<Project> {

    void apply(Project project) {
        project.pluginManager.apply('base')
        project.pluginManager.apply(com.github.gradle.node.NodePlugin)

        if (!project.file('node_modules').exists()) {
            project.tasks.assemble.dependsOn('npmInstall')
            project.tasks.check.dependsOn('npmInstall')
        }

        // Register npm tasks
        ////

        project.tasks.register('run', NpmTask) {
            inputs.dir('src')
            outputs.dir('build')
            args = ['start']
            mustRunAfter 'npmInstall'
        }

        project.tasks.assemble.dependsOn project.tasks.register('npmBuild', NpmTask) {
            inputs.dir('src')
            outputs.dir('build')
            args = ['run', 'build']
            mustRunAfter 'npmInstall'
        }

        project.tasks.check.dependsOn project.tasks.register('npmTest', NpmTask) {
            inputs.dir('src')
            outputs.dir('build')
            args = ['run', 'test']
            mustRunAfter 'npmInstall'
        }
    }

}
