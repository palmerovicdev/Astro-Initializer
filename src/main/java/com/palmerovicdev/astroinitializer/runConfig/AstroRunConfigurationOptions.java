package com.palmerovicdev.astroinitializer.runConfig;

import com.intellij.execution.configurations.RunConfigurationOptions;

public class AstroRunConfigurationOptions extends RunConfigurationOptions {

    {string("").provideDelegate(this, "scriptName");}

}