/*
 * This Groovy source file was generated by the Gradle 'init' task.
 */
package wa.xtext

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * A simple 'hello world' plugin.
 */
class WaXtextPlugin implements Plugin<Project> {

    static final String XTEXT_VERSION = '2.23.0'

    void apply(Project project) {
        project.pluginManager.apply('wa.base')
        project.pluginManager.apply('java')
        project.pluginManager.apply('eclipse')
        project.pluginManager.apply('org.xtext.xtend')

        project.ext.xtextVersion = XTEXT_VERSION

        project.repositories {
            mavenCentral()
        }

        project.configurations.all {
            exclude group: 'asm'
        }

        configureSources(project)
    }

    void configureSources(Project project) {
        project.dependencies {
            compile platform("org.eclipse.xtext:xtext-dev-bom:${XTEXT_VERSION}")
        }

        project.sourceSets {
            main {
                java.srcDirs = ['src/main/java', 'src/main/xtext-gen']
                resources.srcDirs = ['src/main/resources', 'src/main/xtext-gen']
                xtendOutputDir = 'src/main/xtend-gen'
            }
            test {
                java.srcDirs = ['src/test/java', 'src/test/xtext-gen']
                resources.srcDirs = ['src/test/resources', 'src/test/xtext-gen']
                xtendOutputDir = 'src/test/xtend-gen'
            }
        }

        project.tasks.jar {
            from('model') {
                into('model')
            }
            from(project.sourceSets.main.allSource) {
                include '**/*.xtext'
            }
            manifest {
                attributes 'Bundle-SymbolicName': project.name
            }
        }
    }

}