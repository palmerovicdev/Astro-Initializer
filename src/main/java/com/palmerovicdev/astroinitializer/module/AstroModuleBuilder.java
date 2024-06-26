package com.palmerovicdev.astroinitializer.module;

import com.intellij.execution.ExecutionException;
import com.intellij.execution.configurations.GeneralCommandLine;
import com.intellij.execution.process.OSProcessHandler;
import com.intellij.ide.util.projectWizard.ModuleBuilder;
import com.intellij.ide.util.projectWizard.ModuleWizardStep;
import com.intellij.ide.util.projectWizard.WizardContext;
import com.intellij.openapi.Disposable;
import com.intellij.openapi.module.ModifiableModuleModel;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleType;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ModifiableRootModel;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.newvfs.RefreshQueue;
import com.intellij.openapi.wm.ToolWindowAnchor;
import com.intellij.openapi.wm.ToolWindowId;
import com.intellij.openapi.wm.ToolWindowManager;
import com.intellij.terminal.TerminalExecutionConsole;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.util.Objects;

public class AstroModuleBuilder extends ModuleBuilder {

    private final AstroModuleWizardStep wizardStep = new AstroModuleWizardStep();

    @Override
    public void setupRootModel(@NotNull ModifiableRootModel model) {
    }

    @Override
    public ModuleType<AstroModuleBuilder> getModuleType() {
        return AstroModuleType.getInstance();
    }


    @Override
    public @Nullable Module commitModule(@NotNull Project project, @Nullable ModifiableModuleModel model) {
        var module = super.commitModule(project, model);
        runCommandInTerminal(project, wizardStep.getModuleEntity().getScript(), getModuleFileDirectory());
        refreshProjectDirectory();
        return module;
    }


    public void runCommandInTerminal(Project project, String command, String workingDirectory) {
        var toolWindowManager = ToolWindowManager.getInstance(project);
        toolWindowManager.invokeLater(() -> {
            var terminal = toolWindowManager.getToolWindow(ToolWindowId.COMMANDER);
            if (terminal == null) {
                terminal = toolWindowManager.registerToolWindow(ToolWindowId.COMMANDER, true, ToolWindowAnchor.BOTTOM);
                terminal.setTitle("Astro Commander");
            }
            var commandLine = new GeneralCommandLine();
            commandLine.setExePath("bash");
            commandLine.addParameter("-c");
            commandLine.addParameter(command.replace("|", getName().replace(" ", "-")));
            commandLine.setWorkDirectory(workingDirectory.substring(0, workingDirectory.lastIndexOf(File.separator)));

            try {
                OSProcessHandler processHandler = new OSProcessHandler(commandLine);
                TerminalExecutionConsole console = new TerminalExecutionConsole(project, processHandler);
                processHandler.startNotify();

                Content content = ContentFactory.SERVICE.getInstance().createContent(console.getComponent(), "", false);
                terminal.getContentManager().addContent(content);
                terminal.show(null);

            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });

    }

    private void refreshProjectDirectory() {
        var directory = getModuleFileDirectory();
        var virtualFile = LocalFileSystem.getInstance().refreshAndFindFileByPath(Objects.requireNonNullElse(directory, ""));
        if (virtualFile != null) {
            RefreshQueue.getInstance().refresh(false, true, null, virtualFile);
        }
    }

    @Nullable
    @Override
    public ModuleWizardStep getCustomOptionsStep(WizardContext context, Disposable parentDisposable) {
        return wizardStep;
    }

}