package com.palmerovicdev.astroinitializer.runConfig;

import com.intellij.execution.BeforeRunTaskProvider;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.ide.BrowserUtil;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.util.Key;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class AstroBeforeRunTaskProvider extends BeforeRunTaskProvider<AstroBeforeRunTask> {
    public static final Key<AstroBeforeRunTask> ID = Key.create("AstroBeforeRunTask");

    @Override
    public Key<AstroBeforeRunTask> getId() {
        return ID;
    }

    @Override
    public String getName() {
        return "Launch Web Browser";
    }

    @Override
    public Icon getIcon() {
        return null;
    }

    @Override
    public String getDescription(AstroBeforeRunTask task) {
        return "Launch Web Browser";
    }

    @Override
    public boolean isConfigurable() {
        return true;
    }

    @Nullable
    @Override
    public AstroBeforeRunTask createTask(@NotNull RunConfiguration runConfiguration) {
        if (runConfiguration instanceof AstroRunConfiguration) {
            return new AstroBeforeRunTask();
        }
        return null;
    }

    @Override
    public boolean executeTask(
            @NotNull DataContext context, @NotNull RunConfiguration configuration,
            @NotNull ExecutionEnvironment env, @NotNull AstroBeforeRunTask task) {
        BrowserUtil.browse("http://localhost:4321/");
        return true;
    }
}