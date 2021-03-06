/*
 * This Groovy source file was generated by the Gradle 'init' task.
 */
package wa.docker

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * A simple 'hello world' plugin.
 */
class WaDockerPlugin implements Plugin<Project> {

    void apply(Project project) {
        project.pluginManager.apply('base')
        project.pluginManager.apply('publishing')
        project.pluginManager.apply('distribution')
        project.pluginManager.apply('project-report')

        project.pluginManager.apply('de.undercouch.download')
        project.pluginManager.apply('com.palantir.docker')
        project.pluginManager.apply('com.palantir.docker-compose')

        project.tasks.build.dependsOn('projectReport')

        if (project.file('Dockerfile').exists()) {
            project.tasks.build.dependsOn('dockerTag')
            project.tasks.publish.dependsOn('dockerPush')
            project.docker.name = "registry.digitalocean.com/watheia/${project.name}:${project.version}"
        }
    }

}
