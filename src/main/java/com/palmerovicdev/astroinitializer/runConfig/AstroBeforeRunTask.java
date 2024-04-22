package com.palmerovicdev.astroinitializer.runConfig;

import com.intellij.execution.BeforeRunTask;

public class AstroBeforeRunTask extends BeforeRunTask<AstroBeforeRunTask> {
    protected AstroBeforeRunTask() {
        super(AstroBeforeRunTaskProvider.ID);
        setEnabled(true);
    }
}