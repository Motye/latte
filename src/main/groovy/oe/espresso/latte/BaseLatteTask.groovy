/**
  Copyright © 2019 Progress Software Corporation and/or its subsidiaries or affiliates. All Rights Reserved.
*/
package oe.espresso.latte

import org.gradle.api.tasks.Input
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Optional
import org.gradle.api.tasks.Internal


import org.gradle.api.GradleException

import java.lang.ProcessBuilder
import java.nio.file.Paths

/**
    Base task (not for source tasks) for some boilerplate stuff related to setting
    dlcHome and similar.

*/
abstract class BaseLatteTask extends DefaultTask {

    /**
        value for OpenEdge installation location.
        defaults to using dlcHome value of extension
        if not specified
    */
    @Input @Optional
    File dlcHome = ext.dlcHome

    /**
    use prowin32 or prowin (whichever is appropriate),
    otherwise _progress
    */
    @Input @Optional
    Boolean graphicalMode = ext.graphicalMode

    /**
        get value of DlcHome
    */
    File getDlcHome() {
        return dlcHome
    }    

    @Internal
    protected LatteExtension getExt() {
        return project.extensions.getByType(LatteExtension)
    }

}
