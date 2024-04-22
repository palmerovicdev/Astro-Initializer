package com.palmerovicdev.astroinitializer.runConfig;

import com.intellij.execution.ExecutionException;
import com.intellij.execution.Executor;
import com.intellij.execution.configurations.*;
import com.intellij.execution.process.OSProcessHandler;
import com.intellij.execution.process.ProcessHandler;
import com.intellij.execution.process.ProcessHandlerFactory;
import com.intellij.execution.process.ProcessTerminatedListener;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.execution.runners.ProgramRunner;
import com.intellij.ide.BrowserUtil;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.NlsActions;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static com.intellij.util.TimeoutUtil.sleep;

public class AstroRunConfiguration extends RunConfigurationBase<AstroRunConfigurationOptions> {

    private String scriptText;

    protected AstroRunConfiguration(@NotNull Project project, @Nullable ConfigurationFactory factory, @Nullable String name) {
        super(project, factory, name);
    }


    @Nullable
    @Override
    public RunProfileState getState(
            @NotNull Executor executor,
            @NotNull ExecutionEnvironment environment) {
        return new CommandLineState(environment) {
            @NotNull
            @Override
            protected ProcessHandler startProcess() throws ExecutionException {
                GeneralCommandLine commandLine = new GeneralCommandLine();
                commandLine.setExePath("bash");
                commandLine.addParameter("-c");
                commandLine.addParameter(getScriptText());
                commandLine.setWorkDirectory(getProject().getBasePath());
                OSProcessHandler processHandler = ProcessHandlerFactory.getInstance()
                                                                       .createColoredProcessHandler(commandLine);
                ProcessTerminatedListener.attach(processHandler);

                return processHandler;
            }
        };
    }

    public String getScriptText() {
        return scriptText;
    }

    public void setScriptText(String scriptText) {
        this.scriptText = scriptText;
    }

    @Override
    public @NotNull ConfigurationType getType() {
        return super.getType();
    }

    @Override
    public @NotNull SettingsEditor<? extends RunConfiguration> getConfigurationEditor() {
        return new AstroSettingsEditor();
    }

    @Override
    public @Nullable ConfigurationPerRunnerSettings createRunnerSettings(ConfigurationInfoProvider provider) {
        return super.createRunnerSettings(provider);
    }

    @Override
    public @Nullable SettingsEditor<ConfigurationPerRunnerSettings> getRunnerSettingsEditor(ProgramRunner runner) {
        return super.getRunnerSettingsEditor(runner);
    }

    @Override
    public int getUniqueID() {
        return super.getUniqueID();
    }

    @Override
    public @Nullable @NonNls String getId() {
        return super.getId();
    }

    @Override
    public @NotNull @NlsActions.ActionText String getPresentableType() {
        return super.getPresentableType();
    }

    @Override
    public boolean hideDisabledExecutorButtons() {
        return super.hideDisabledExecutorButtons();
    }

    @Override
    public void checkConfiguration() throws RuntimeConfigurationException {
        super.checkConfiguration();
    }

    @Override
    public RestartSingletonResult restartSingleton(@NotNull ExecutionEnvironment environment) {
        return super.restartSingleton(environment);
    }
}