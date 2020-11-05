/*
 * This Groovy source file was generated by the Gradle 'init' task.
 */
package wa.base

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.JavaVersion

/**
 * A simple 'hello world' plugin.
 */
class WaBasePlugin implements Plugin<Project> {

    static final String XTEXT_VERSION = '2.23.0'
    static final JavaVersion JAVA_VERSION = JavaVersion.VERSION_11

    void apply(Project project) {
        project.pluginManager.apply('base')
        project.pluginManager.apply('publishing')
        project.pluginManager.apply('distribution')
        project.pluginManager.apply('de.undercouch.download')

        project.plugins.withType(org.gradle.api.plugins.JavaBasePlugin) {
            project.sourceCompatibility = JAVA_VERSION
            project.targetCompatibility = JAVA_VERSION
            project.repositories {
                jcenter()
                mavenCentral()
            }
        }
    }

}
